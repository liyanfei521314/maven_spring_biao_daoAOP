package com.biao.pojo.System;

import java.util.List;

public class LoginReturn {

    private long userId; //用戶id
    private String username;//用户名
    private List<Integer> roleId;//角色id
    private List<Integer> moduleId;//模块id
    private String token; //所有权限token

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getRoleId() {
        return roleId;
    }

    public void setRoleId(List<Integer> roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getModuleId() {
        return moduleId;
    }

    public void setModuleId(List<Integer> moduleId) {
        this.moduleId = moduleId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginReturn{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", roleId=" + roleId +
                ", moduleId=" + moduleId +
                ", token='" + token + '\'' +
                '}';
    }
}
