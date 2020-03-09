package com.cloud.usercenter.service.impl;


import com.cloud.modle.apimodle.user.SysPermission;
import com.cloud.modle.apimodle.user.SysRole;
import com.cloud.usercenter.dao.RolePermissionDao;
import com.cloud.usercenter.dao.SysRoleDao;
import com.cloud.usercenter.dao.UserRoleDao;
import com.cloud.usercenter.service.SysRoleService;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private UserRoleDao userRoleDao;
	@Autowired
	private RolePermissionDao rolePermissionDao;


	@Override
	public void save(SysRole sysRole) {
		SysRole role = sysRoleDao.findByCode(sysRole.getCode());
		if (role != null) {
			throw new IllegalArgumentException("角色code已存在");
		}

		sysRole.setCreateTime(new Date());
		sysRole.setUpdateTime(sysRole.getCreateTime());

		sysRoleDao.save(sysRole);
		log.info("保存角色：{}", sysRole);
	}

	@Override
	public void update(SysRole sysRole) {
		sysRole.setUpdateTime(new Date());

		sysRoleDao.update(sysRole);
		log.info("修改角色：{}", sysRole);
	}

	@Override
	public void deleteRole(Long id) {
		SysRole sysRole = sysRoleDao.findById(id);

		sysRoleDao.delete(id);
		rolePermissionDao.deleteRolePermission(id, null);
		userRoleDao.deleteUserRole(null, id);

		log.info("删除角色：{}", sysRole);

		// 发布role删除的消息
	}

	/**
	 * 给角色设置权限
	 *
	 * @param roleId
	 * @param permissionIds
	 */
	@Override
	public void setPermissionToRole(Long roleId, Set<Long> permissionIds) {
		SysRole sysRole = sysRoleDao.findById(roleId);
		if (sysRole == null) {
			throw new IllegalArgumentException("角色不存在");
		}

		// 查出角色对应的old权限
		Set<Long> oldPermissionIds = rolePermissionDao.findPermissionsByRoleIds(Sets.newHashSet(roleId)).stream()
				.map(p -> p.getId()).collect(Collectors.toSet());

		// 需要添加的权限
		Collection<Long> addPermissionIds = org.apache.commons.collections4.CollectionUtils.subtract(permissionIds,
				oldPermissionIds);
		if (!CollectionUtils.isEmpty(addPermissionIds)) {
			addPermissionIds.forEach(permissionId -> {
				rolePermissionDao.saveRolePermission(roleId, permissionId);
			});
		}
		// 需要移除的权限
		Collection<Long> deletePermissionIds = org.apache.commons.collections4.CollectionUtils
				.subtract(oldPermissionIds, permissionIds);
		if (!CollectionUtils.isEmpty(deletePermissionIds)) {
			deletePermissionIds.forEach(permissionId -> {
				rolePermissionDao.deleteRolePermission(roleId, permissionId);
			});
		}

		log.info("给角色id：{}，分配权限：{}", roleId, permissionIds);
	}

	@Override
	public SysRole findById(Long id) {
		return sysRoleDao.findById(id);
	}



	@Override
	public Set<SysPermission> findPermissionsByRoleId(Long roleId) {
		return rolePermissionDao.findPermissionsByRoleIds(Sets.newHashSet(roleId));
	}
}
