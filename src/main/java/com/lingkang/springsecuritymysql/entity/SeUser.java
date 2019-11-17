package com.lingkang.springsecuritymysql.entity;

import java.io.Serializable;
import java.util.Date;

public class SeUser implements Serializable {
    private Integer id;

    private String name;

    private String username;

    private String password;

    private Integer status;

    private Date createTime;

    private Date updateTitme;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTitme() {
        return updateTitme;
    }

    public void setUpdateTitme(Date updateTitme) {
        this.updateTitme = updateTitme;
    }
}