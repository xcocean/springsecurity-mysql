package com.lingkang.springsecuritymysql.config;

import com.lingkang.springsecuritymysql.entity.SeRole;
import com.lingkang.springsecuritymysql.entity.SeUser;
import com.lingkang.springsecuritymysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component //交给spring托管，应为我们使用@Autowired注入了spring的接口
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //查询用户
        SeUser user = userService.getUserInfo(s);
        if (user == null) {
            throw new UsernameNotFoundException("帐号：" + s + " 不存在！");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        //查询拥有的角色
        List<SeRole> roles = userService.getUserRoleByUserId(user.getId());
        roles.forEach(r -> {
            //security的验证规则需要ROLE_，由于我数据库是vip1、vip2、vip3这种值，需要加上ROLE_
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + r.getName()));
        });
        //spring5+要求密码加密，我这里传明文密码来加密
        String password = new BCryptPasswordEncoder().encode(user.getPassword());
        return new User(user.getUsername(), password, grantedAuthorities);
    }

}
