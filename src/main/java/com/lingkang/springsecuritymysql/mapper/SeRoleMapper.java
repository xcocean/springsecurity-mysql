package com.lingkang.springsecuritymysql.mapper;

import com.lingkang.springsecuritymysql.entity.SeRole;

import java.util.List;

public interface SeRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeRole record);

    int insertSelective(SeRole record);

    SeRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeRole record);

    int updateByPrimaryKey(SeRole record);

    List<SeRole> getRoles(Integer userId);
}