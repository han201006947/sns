package com.tensquare.user.interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2019/5/28.
 */
@Component
public class JwtInteceptor implements HandlerInterceptor{

    @Autowired
    private JwtUtil jwtUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("经过了拦截器");
        //拦截器负把有请求头中包含tocked的令牌进行解析验证
        //无论如何都放行，具体能不能操作还是在具体的操作。抽取有头的
        String header = request.getHeader("Authorization");
        if(header!=null && !"".equals(header)){
            //如果有包含头信息Authorization就对其进行解析
            if(header.startsWith("Bearer ")){
                //得到令牌
                String tocken = header.substring(7);
                //对灵盘进行验证
                try {
                    Claims claims = jwtUtil.parseJWT(tocken);
                    String roles = (String)claims.get("roles");
                    if(roles != null || roles.equals("admin")){
                        request.setAttribute("claims_admin",tocken);
                    }
                    if(roles != null || roles.equals("user")){
                        request.setAttribute("claims_user",tocken);
                    }
                }catch (Exception e){
                    throw new RuntimeException("令牌异常");
                }
            }
        }
        return true;
    }
}
