package com.biao.lanjie.token;

import java.util.List;

public class JSON_WEB_TOKEN {

    private Integer id;
    private List<String> roles;
    private List<String> permissions;

    public JSON_WEB_TOKEN(Integer id, List<String> permissions) {
        this.id = id;
        this.permissions = permissions;
    }

    public JSON_WEB_TOKEN(Integer id, List<String> roles, List<String> permissions) {
        this.id = id;
        this.roles = roles;
        this.permissions = permissions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

}
