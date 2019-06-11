package com.tensquare.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 * Configuration:让系统知道这是个配置类
 * extends WebSecurityConfigurerAdapter：让配置类自动去加载
 * WebSecurityConfigurerAdapter:里面默认是很多没有做实现的空方法，当我们需要其中的空方法时，就把对应的方法拿出来进行重写
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorizeRequests：所有Security全注解配置实现的开端，表示开始说明需要的权限
        //需要的权限分两部分：拦截的路径、访问该路径需要的权限
        //antMatchers：拦截路径
        //permitAll：任何权限都可以访问，直接放行所有
        //anyRequest：任何的请求
        //authenticated：认证后才能访问
        //and().csrf().disable();固定写法，表示csrf拦截失效
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
