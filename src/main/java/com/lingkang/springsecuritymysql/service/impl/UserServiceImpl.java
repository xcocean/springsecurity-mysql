package com.lingkang.springsecuritymysql.service.impl;

import com.lingkang.springsecuritymysql.entity.SeRole;
import com.lingkang.springsecuritymysql.entity.SeUser;
import com.lingkang.springsecuritymysql.mapper.SeRoleMapper;
import com.lingkang.springsecuritymysql.mapper.SeUserMapper;
import com.lingkang.springsecuritymysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SeUserMapper seUserMapper;
    @Autowired
    private SeRoleMapper seRoleMapper;

    @Override
    public SeUser getUserInfo(String username) {
        return seUserMapper.get(username);
    }

    @Override
    public List<SeRole> getUserRoleByUserId(Integer userId) {
        return seRoleMapper.getRoles(userId);
    }
}
