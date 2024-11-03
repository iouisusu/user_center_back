package com.mgc.usercenter.service;

import java.util.Date;

import com.mgc.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0
 * @Author YJH
 * @Date 2024/10/25 20:46
 * @注释 用户服务测试
 */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("yupi2");
        user.setUserAccount("123");
        user.setAvatarUrl("https://img.zcool.cn/commun" +
                "ity/016a2e5f110b9fa801215aa097202c.png?x-oss-process=image/auto-orient,1/resize,m_lfit,w_1280,limit_1/sharpen,100/quality,q_100/format,webp\n");
        user.setGender(0);
        user.setUserPassword("123");
        user.setEmail("123@");
        user.setPhone("156");
        boolean res = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(res);
    }


    @Test
    void userRegister() {
        String userAccount = "yupi";
        String userPassword = "";
        String checkPassword = "123456";
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        //检测出来 密码为空
        userAccount = "yu";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        //检测出来 账户《4
        userAccount = "yupi";
        userPassword = "123456";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        //检测出来 密码《8
        userAccount = "yu pi";
        userPassword = "12345678";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-55, result);
        //不断言 检测出来 有空格
        userAccount = "yupi";
        checkPassword = "123456789";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        //不断言 检测出来 确认密码错误
        userAccount = "123456";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);
        //不断言 检测出来 用户名重复
        userAccount = "yupi";
        result = userService.userRegister(userAccount, userPassword, checkPassword);
        System.out.println("res=" + result);
        Assertions.assertTrue(result > 0);
        //不断言 没有问题，
    }
}
