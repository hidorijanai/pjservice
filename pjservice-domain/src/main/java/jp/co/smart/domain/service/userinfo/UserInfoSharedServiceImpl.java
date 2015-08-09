package jp.co.smart.domain.service.userinfo;

import javax.inject.Inject;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.terasoluna.gfw.common.exception.BusinessException;

import jp.co.smart.domain.model.UserInfo;
import jp.co.smart.domain.repository.userinfo.UserInfoRepository;

@Service
public class UserInfoSharedServiceImpl implements UserInfoSharedService {

	@Inject
	PasswordEncoder passwordEncoder;

	@Inject
	UserInfoRepository userInfoRepository;

	@Override
	public UserInfo findOneById(String userId) {

		UserInfo userInfo = userInfoRepository.findOne(userId);

		if (userInfo == null) {
			throw new BusinessException("user not found!");
		}
		return userInfo;
	}

	public String register(UserInfo userInfo, String rawPassword) {
	    // omitted
	    // Password Hashing
	    String password = passwordEncoder.encode(rawPassword); // (2)
	    userInfo.setPassword(password);
	    // omitted
	    return null;
	}

	public boolean matches(UserInfo userInfo, String rawPassword) {
	    return passwordEncoder.matches(rawPassword, userInfo.getPassword()); // (3)
	}

}
