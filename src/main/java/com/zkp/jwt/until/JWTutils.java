package com.zkp.jwt.until;

import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zkp.jwt.pojo.User;
import org.springframework.util.StringUtils;
import com.auth0.jwt.JWT;

import java.util.Calendar;

public class JWTutils {
    /**
     * 密钥
     */
    private static final String SECRET = "my_secret";
    /**
     * 获取token
     * @param u user
     * @return token
     */
    public static String getToken(User u) {
        Calendar instance = Calendar.getInstance();
        //默认令牌过期时间7天
        instance.add(Calendar.DATE, 7);
       // instance.add(Calendar.SECOND,20);
        //如果不设置head，则使用默认head设置

        String token = JWT.create()
                .withClaim("userId", u.getId())
                .withClaim("username", u.getUsername())
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SECRET));


                return token;
    }

    /**
     * 验证token合法性 成功返回token
     */
    public static DecodedJWT verify(String token) throws Exception {
        //创建一个验证对象
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            DecodedJWT decodedToken = verifier.verify(token);
            return decodedToken;
        }catch (Exception e){
            e.printStackTrace();
        }
        //通过验证对象，将token解码，得到解码后的token对象。
     //   DecodedJWT decodedToken = verifier.verify(token);
        //可以在decodedJWT获取内部数据
       // System.out.println(decodedToken.getClaim("username").asString());

        if(StringUtils.isEmpty(token)){
            throw new Exception("token不能为空");
        }

        //获取登录用户真正的密码假如数据库查出来的是123456
      //  String password = "admin";

        //return decodedToken;
        return null;
    }

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setUsername("admin");
        user.setId(1);
        String token = getToken(user);
        System.out.println("创造token："+token);
        DecodedJWT verify = verify(token);

        System.out.println("解码后："+verify.toString());

        System.out.println(token.equals(verify.toString()));
    }


}
