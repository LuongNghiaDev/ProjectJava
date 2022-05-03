package com.laptrinhjavaweb.dto;

import com.laptrinhjavaweb.entity.RoleEntity;

import java.util.Set;

public class UserDTO extends AbstractDTO<UserDTO> {

    public String userName;
    public String passWord;
    public String fullName;
    public int status;
    public Long roleId;
    public Set<RoleEntity> roleEntityList;

    /*public Set<RoleEntity> getRoleEntityList() {
        return roleEntityList;
    }

    public void setRoleEntityList(Set<RoleEntity> roleEntityList) {
        this.roleEntityList = roleEntityList;
    }*/

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    private String roleCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
