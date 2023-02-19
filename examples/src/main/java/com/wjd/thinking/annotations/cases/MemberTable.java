package com.wjd.thinking.annotations.cases;

import com.wjd.thinking.annotations.Constraints;
import com.wjd.thinking.annotations.DBTable;
import com.wjd.thinking.annotations.SQLInteger;
import com.wjd.thinking.annotations.SQLString;

/**
 * 组员表
 */
@DBTable(name = "MEMBER")
public class MemberTable {

    /**
     * 姓
     */
    @SQLString(30)
    String firstName;

    /**
     * 名
     */
    @SQLString(50)
    String lastName;

    /**
     * 年龄
     */
    @SQLInteger
    Integer age;

    /**
     * 主键
     */
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;

    static int memberCount;

    @Override
    public String toString() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }
}
