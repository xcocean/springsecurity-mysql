package com.lingkang.springsecuritymysql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author linke
 * @date 2019-11-16 下午 15:10
 * @description
 */
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //注入我们加密的方式，spring5+以上必须要加密密码，这是官网推荐的加密方式，也可选择MD5
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //由于我们自定义了UserDetailsService，我们需要新注入这个bean
    @Bean
    @Override //重写
    public UserDetailsService  userDetailsServiceBean() {
        //使用我们自定义的 UserDetailsService
        return new CustomUserDetailsService();
    }

    //认证----自定义认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //自定义认证
        auth.userDetailsService(userDetailsServiceBean());
    }

    //授权
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //授权规则，除了要授权的，其他所有人能访问
        http.authorizeRequests()
                .antMatchers("/vip1/**").hasAnyRole("vip1")
                .antMatchers("/vip2/**").hasAnyRole("vip2")
                .antMatchers("/vip3/**").hasAnyRole("vip3")
                .anyRequest().permitAll(); //其他页面所有人能访问

        //启动登陆页面
        //定制登陆页面，表单提交的路径loginProcessingUrl
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");

        //注销功能 ,跳回首页
        //关闭跨域认证请求，否则你需要post来注销
        http.logout().logoutSuccessUrl("/")
                .and().csrf().disable();

        //开启记住我功能，表单提交remember的参数
        http.rememberMe().rememberMeParameter("remember");
    }
}
