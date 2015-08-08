/*
 * Copyright (C) 2013-2015 Smart Service
 *
 */
package jp.co.smart.domain.repository.userinfo;

import jp.co.smart.domain.model.UserInfo;
import jp.co.smart.domain.repository.BaseRepository;

public interface UserInfoSharedRepository extends BaseRepository<UserInfo, String> {

    public abstract UserInfo findOne(String paramID);
}
