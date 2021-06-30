package com.cn.normanleevisuals.controller;

import com.cn.normanleevisuals.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    UserDao userDao;

    @RequestMapping("/index")
    public String index(String userName, String password) {
        System.out.println("用户名：" + userName);
        System.out.println("密码：" + password);
        int count = userDao.getUserByLoginName(userName, password);
        if (count > 0){
            return "login success!";
        }
        else{
            return "login failed!";
        }
    }
}
