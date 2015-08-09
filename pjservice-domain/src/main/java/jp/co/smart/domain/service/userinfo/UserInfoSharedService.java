package jp.co.smart.domain.service.userinfo;

import jp.co.smart.domain.model.UserInfo;

public interface UserInfoSharedService {

    UserInfo findOneById(String userId);
}
