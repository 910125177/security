package com.zlflovemm.security.config;

import com.zlflovemm.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName SecurityConfig
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/12/24 15:16
 * @Version 1.0
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;


    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCryptPasswordEncoder：Spring Security 提供的加密工具
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder());//passwoldEncoder是对密码的加密处理，如果user中密码没有加密，则可以不加此方法。注意加密请使用security自带的加密方式。
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/", "/hello").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            //.loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .permitAll();
    }

    /*//将用户名密码写死在内存中
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("begin: "+passwordEncoder().encode("123456"));
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder()) // 指定加密方式
                .withUser("qaz").password(passwordEncoder().encode("123456")).roles("admin")
                .and()
                .withUser("test").password(passwordEncoder().encode("123456")).roles("USER");

        System.out.println("end: "+passwordEncoder().encode("123456"));
    }*/

}