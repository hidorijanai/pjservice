/*
 * Copyright (C) 2013-2015 Smart Service
 *
 */
package jp.co.smart.domain.repository.userinfo;

import jp.co.smart.domain.model.UserInfo;
import jp.co.smart.domain.repository.BaseCrudRepository;

public interface UserInfoRepository extends BaseCrudRepository<UserInfo, String> {

    public abstract UserInfo findOne(String paramID);
}
