package com.zkp.jwt.controller;

import com.zkp.jwt.pojo.User;
import com.zkp.jwt.until.JWTutils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
@Slf4j
@RestController
public class UserLoginController {

        @Value("admin")
        private String realUsername;
        @Value(("123456"))
        private String realPassword;


        @GetMapping("login")
        public String login(String username, String password) {
            log.info("执行login");
            if (username.equals(realUsername) && password.equals(realPassword)) {
                User u = new User();
                u.setPassword(password);
                u.setUsername(username);
                log.info("获取token"+JWTutils.getToken(u));
                return JWTutils.getToken(u);
            }
            return "登录失败！账号或者密码不对！";
        }

        @GetMapping("test")
        public String test( ) {
            return "访问test - API";
        }

//
//        @GetMapping("/t1")
//    public String t1(HttpServletRequest request,String name){
//
//        //    request.getSession().setAttribute("username",name);
//          //  System.out.println(request.getSession().getAttribute("username"));
//            return "查看cookie";
//        }



}
