package com.mgc.usercenter.model.domain.request;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author YJH
 * @Date 2024/10/29 20:28
 * @注释
 */
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 267513786095501013L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }
}
