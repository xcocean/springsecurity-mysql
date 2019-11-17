package com.lingkang.springsecuritymysql.mapper;

import com.lingkang.springsecuritymysql.entity.SeUser;

public interface SeUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeUser record);

    int insertSelective(SeUser record);

    SeUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SeUser record);

    int updateByPrimaryKey(SeUser record);

    SeUser get(String username);
}