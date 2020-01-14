package com.cloud.usercenter.service;

import com.cloud.modle.apimodle.user.SysPermission;
import com.cloud.modle.apimodle.user.SysRole;

import java.util.Map;
import java.util.Set;

public interface SysRoleService {

	void save(SysRole sysRole);

	void update(SysRole sysRole);

	void deleteRole(Long id);

	void setPermissionToRole(Long id, Set<Long> permissionIds);

	SysRole findById(Long id);

	Set<SysPermission> findPermissionsByRoleId(Long roleId);
}
