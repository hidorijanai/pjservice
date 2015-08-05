/*
 * Copyright (C) 2013-2015 Smart Service
 *
 */
package jp.co.smart.domain.service.userdetails;

import java.util.Collections;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import jp.co.smart.domain.common.constants.DomainConstants;
import jp.co.smart.domain.model.UserInfo;
import jp.co.smart.domain.repository.userinfo.UserInfoRepository;

public class BaseUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory
            .getLogger(BaseUserDetailsService.class);

    @Inject
    UserInfoRepository usreInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.debug("Execute Method loadUserByUsername.");

        UserInfo userInfo = usreInfoRepository.findOne(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException(username + " is not found."); // TODO to property file
        }

        String userRole = userInfo.getUserRole();

        if (!DomainConstants.ROLE_USER.equals(userRole) && !DomainConstants.ROLE_ADMIN.equals(userRole)) {
            logger.error("user role: " + userRole + " is not permitted");
            throw new AuthenticationServiceException("user role: " + userRole + " is not permitted");
        }

        BaseUserDetails userDetails = new BaseUserDetails(userInfo, Collections
                .singletonList(new SimpleGrantedAuthority(userRole)));

        return userDetails;
    }

}
