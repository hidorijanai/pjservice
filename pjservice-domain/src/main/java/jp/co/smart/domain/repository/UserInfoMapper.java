/*
 * Copyright (C) 2013-2015 Smart Service
 *
 */
package jp.co.smart.domain.repository;

import jp.co.smart.domain.model.UserInfo;

public interface UserInfoMapper {

    public abstract UserInfo findOne(String paramID);
}
