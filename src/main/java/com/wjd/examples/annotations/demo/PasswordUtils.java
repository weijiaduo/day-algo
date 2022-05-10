package com.wjd.examples.annotations.demo;

import java.util.List;

/**
 * @since 2022/1/1
 */
public class PasswordUtils {

    @UseCase(id = 47)
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49)
    public boolean checkNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }

}
