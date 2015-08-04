/*
 * Copyright (C) 2013-2015 Smart Service
 *
 */
package jp.co.smart.domain.model;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String username;

    private String userKana;

    private String password;

    private Date userBirth;

    private String userJob;

    private String userMail;

    private String userTel;

    private String userPost;

    private String userAdd;

    private String userRole;

    public UserInfo() {
    }

    public UserInfo(String userId) {
        this.userId = userId;
    }

    public UserInfo(String userId, String username, String userKana, String password, Date userBirth, String userJob,
            String userTel, String userPost, String userAdd, String userRole) {
        this.userId = userId;
        this.username = username;
        this.userKana = userKana;
        this.password = password;
        this.userBirth = userBirth;
        this.userJob = userJob;
        this.userTel = userTel;
        this.userPost = userPost;
        this.userAdd = userAdd;
        this.userRole = userRole;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserKana() {
        return userKana;
    }

    public void setUserKana(String userKana) {
        this.userKana = userKana;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public String getUserJob() {
        return userJob;
    }

    public void setUserJob(String userJob) {
        this.userJob = userJob;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserPost() {
        return userPost;
    }

    public void setUserPost(String userPost) {
        this.userPost = userPost;
    }

    public String getUserAdd() {
        return userAdd;
    }

    public void setUserAdd(String userAdd) {
        this.userAdd = userAdd;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are
        // not set
        if (!(object instanceof UserInfo)) {
            return false;
        }
        UserInfo other = (UserInfo) object;
        if ((this.userId == null && other.userId != null)
                || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jp.co.smartservice.domain.model.UserInfo[ userId=" + userId + " ]";
    }

}
