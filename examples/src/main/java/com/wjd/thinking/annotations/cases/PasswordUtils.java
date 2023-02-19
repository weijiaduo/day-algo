package com.wjd.thinking.annotations.cases;

import com.wjd.thinking.annotations.UseCase;

import java.util.List;

public class PasswordUtils {

    private PasswordUtils() {}

    /**
     * 密码验证
     *
     * @param password 密码
     * @return
     */
    @UseCase(id = 47, description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password) {
        return (password != null && password.matches("\\w*\\d\\w*"));
    }


    /**
     * 加密密码
     *
     * @param password 密码
     * @return
     */
    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    /**
     * 验证历史密码
     *
     * @param prePasswords 历史密码集合
     * @param password 当前密码
     * @return
     */
    @UseCase(id = 49, description = "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prePasswords, String password) {
        return !prePasswords.contains(password);
    }
}
