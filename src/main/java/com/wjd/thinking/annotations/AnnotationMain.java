package com.wjd.thinking.annotations;

import com.wjd.thinking.annotations.handler.DBTableAnnotationHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 注解运行主类
 */
public class AnnotationMain {

    public static void main(String[] args) throws Exception {
        // 简单注解用例
//        List<Integer> useCases = new ArrayList<>();
//        Collections.addAll(useCases, 47, 48, 49, 50);
//        UseCaseAnnotationHandler.handle(useCases, PasswordUtils.class);

        // 创建数据库表语句
        List<String> dbTables = new ArrayList<>();
        Collections.addAll(dbTables, "com.wjd.learn.annotations.cases.MemberTable");
        DBTableAnnotationHandler.handle(dbTables);

    }
}
