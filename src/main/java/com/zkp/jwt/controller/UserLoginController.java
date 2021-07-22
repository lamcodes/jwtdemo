package com.zkp.jwt.controller;

import com.zkp.jwt.pojo.User;
import com.zkp.jwt.until.JWTutils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("user")
public class UserLoginController {

        @Value("admin")
        private String realUsername;
        @Value(("123456"))
        private String realPassword;


        @GetMapping("login")
        public String login(String username, String password) {
            if (username.equals(realUsername) && password.equals(realPassword)) {
                User u = new User();
                u.setPassword(password);
                u.setUsername(username);
                return JWTutils.getToken(u);
            }
            return "登录失败！账号或者密码不对！";
        }

        @GetMapping("test")
        public String test() {
            return "访问test - API";
        }



}
