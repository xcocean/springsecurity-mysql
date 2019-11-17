package com.lingkang.springsecuritymysql.service;

import com.lingkang.springsecuritymysql.entity.SeRole;
import com.lingkang.springsecuritymysql.entity.SeUser;

import java.util.List;

public interface UserService {

    //获取用户信息
    SeUser getUserInfo(String username);

    //获取用户角色，可能一个用户存在多个角色的情况
    List<SeRole> getUserRoleByUserId(Integer userId);
}
