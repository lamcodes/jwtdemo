package com.zkp.jwt.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.zkp.jwt.until.JWTutils;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<String,Object> map = new HashMap<>();
        String token = request.getHeader("token");
        if(token==null){
            throw new Exception("token不能为空");
        }
        try {
            JWTutils.verify(token);
        } catch (SignatureVerificationException e) {
            log.error("无效签名！ 错误 ->", e);
            map.put("msg","无效签名");
            return false;
        } catch (TokenExpiredException e) {
            log.error("token过期！ 错误 ->", e);
            map.put("msg","token过期");
            return false;
        } catch (AlgorithmMismatchException e) {
            log.error("token算法不一致！ 错误 ->", e);
            map.put("msg","token算法不一致");
            return false;
        } catch (Exception e) {
            log.error("token无效！ 错误 ->", e);
            map.put("msg","token无效");
            return false;
        }
        String s = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=utf-8");
      //  response.getWriter().println(s);
        return true;
    }

}
