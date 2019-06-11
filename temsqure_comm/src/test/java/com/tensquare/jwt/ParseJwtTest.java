package com.tensquare.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2019/5/27.
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        Claims claims = Jwts.parser()
                .setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1NTg5NTcyMTcsImV4cCI6MTU1ODk1NzI3Nywicm9sZSI6ImFkbWluIn0.ElmboNIWLaXF3bg2yy-TDLJaGlDYlSO8E6YTUWruIzM")
                .getBody();
        System.out.println("用户id:"+claims.getId());
        System.out.println("用户名称:"+claims.getSubject());
        System.out.println("登录时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("用户角色:"+claims.get("role"));
    }
}
