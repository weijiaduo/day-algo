package com.wjd.thinking.annotations.handler;

import com.wjd.thinking.annotations.Constraints;
import com.wjd.thinking.annotations.DBTable;
import com.wjd.thinking.annotations.SQLInteger;
import com.wjd.thinking.annotations.SQLString;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解 {@link com.wjd.thinking.annotations.DBTable} 的处理器
 */
public class DBTableAnnotationHandler implements AnnotationHandler {

    /**
     * 注解处理方法
     * @param classNames 指定要处理的类名集合
     */
    public static void handle(List<String> classNames) throws Exception {
        if (classNames.size() <= 0) {
            System.err.println("No annotation classes");
            return;
        }

        for (String className: classNames) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.err.println("No DBTable annotation in class " + className);
                continue;
            }

            // 数据库表名，表名为空时使用类名全大写作为表名
            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = cl.getName().toUpperCase();
            }

            List<String> columnDefs = new ArrayList<>();
            for (Field field: cl.getDeclaredFields()) {
                String columnName;

                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) {
                    continue;
                }

                // SQLInteger 类型声明
                if (anns[0] instanceof SQLInteger) {
                    SQLInteger sqlInteger = (SQLInteger) anns[0];
                    if (sqlInteger.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlInteger.name();
                    }

                    // 记录数据表列的声明
                    columnDefs.add(columnName + " INT" + getConstraints(sqlInteger.constraints()));
                }

                // SQLString 类型声明
                if (anns[0] instanceof SQLString) {
                    SQLString sqlString = (SQLString) anns[0];
                    if (sqlString.name().length() < 1) {
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sqlString.name();
                    }

                    // 记录数据表列的声明
                    columnDefs.add(columnName + " VARCHAR(" + sqlString.value() + ")"
                            + getConstraints(sqlString.constraints()));
                }
            }

            // 拼接创建表的 SQL 语句
            StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
            for (String columnDef: columnDefs) {
                createCommand.append("\n    " + columnDef + ",");
            }

            // 移除最后一个逗号
            createCommand.deleteCharAt(createCommand.length() - 1);
            createCommand.append(");");

            // 最后生成的 SQL 语句
            String tableCreate = createCommand.toString();
            System.out.println("Table creation SQL for " + className + " is :\n" + tableCreate);
        }
    }

    /**
     * 获取约束条件
     *
     * @param constraints 约束条件注解
     * @return
     */
    private static String getConstraints(Constraints constraints) {
        String con = "";

        if (!constraints.allowNull()) {
            con += " NOT NULL";
        }
        if (constraints.primaryKey()) {
            con += " PRIMARY KEY";
        }
        if (constraints.unique()) {
            con += " UNIQUE";
        }

        return con;
    }
}
