package com.cloud.usercenter.service;

import com.cloud.modle.apimodle.user.AppUser;
import com.cloud.modle.apimodle.user.LoginAppUser;
import com.cloud.modle.apimodle.user.SysRole;

import java.util.Map;
import java.util.Set;

public interface AppUserService {

	void addAppUser(AppUser appUser);

	void updateAppUser(AppUser appUser);

	LoginAppUser findByUsername(String username);


	AppUser findById(Long id);

	void setRoleToUser(Long id, Set<Long> roleIds);

	void updatePassword(Long id, String oldPassword, String newPassword);

	Set<SysRole> findRolesByUserId(Long userId);

	void bindingPhone(Long userId, String phone);
}
