package com.cn.normanleevisuals.controller;

import com.cn.normanleevisuals.dao.UserDao;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户操作")
@RestController
public class HelloController {

    @Autowired
    UserDao userDao;

    @ApiOperation(value="用户登录", notes="根据用户姓名密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "userName", value = "用户姓名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "password", value = "密码", required = true, dataType = "String")
    })
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
