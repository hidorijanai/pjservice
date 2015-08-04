/*
 * Copyright (C) 2013-2015 Smart Service
 *
 */
package jp.co.smart.domain.service.userdetails;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import jp.co.smart.domain.model.UserInfo;

public class BaseUserDetails extends User {

    private static final long serialVersionUID = 1L;

    private final UserInfo userInfo;

    /**
     * Calls the more complex constructor with all boolean arguments set to {@code true}.
     */
    public BaseUserDetails(UserInfo userInfo, Collection<? extends GrantedAuthority> authorities) {

        super(userInfo.getUserId(), userInfo.getPassword(), true, true, true, true, authorities);
        this.userInfo = userInfo;
    }

    public String getDisplayName() {
        return this.userInfo.getUsername();
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }
}
