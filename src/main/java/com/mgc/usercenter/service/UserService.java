package com.mgc.usercenter.service;

import com.mgc.usercenter.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 86156
 * @description 针对表【user(用户表)】的数据库操作Service
 * @createDate 2024-10-25 20:41:34
 */
public interface UserService extends IService<User> {


    /**
     * @param userAccount   用户名
     * @param userPassword  密码
     * @param checkPassword 确认密码
     * @return 返回值
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);

    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);
}
