package com.cloud.usercenter.service.impl;


import com.cloud.modle.apimodle.user.AppUser;
import com.cloud.modle.apimodle.user.SysRole;
import com.cloud.modle.apimodle.user.UserCredential;
import com.cloud.usercenter.dao.AppUserDao;
import com.cloud.usercenter.dao.UserCredentialsDao;
import com.cloud.usercenter.dao.UserRoleDao;
import com.cloud.usercenter.service.AppUserService;
import com.cloud.usercenter.service.SysPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author zuyunbo
 */
@Slf4j
@Service
public class AppUserServiceImpl implements AppUserService {

    @Resource
    private AppUserDao appUserDao;

    @Resource
    private SysPermissionService sysPermissionService;
    @Resource
    private UserRoleDao userRoleDao;
    @Resource
    private UserCredentialsDao userCredentialsDao;

    @Override
    public void addAppUser(AppUser appUser) {
        String username = appUser.getUsername();
        if (StringUtils.isBlank(username)) {
            throw new IllegalArgumentException("用户名不能为空");
        }

        UserCredential userCredential = userCredentialsDao.findByUsername(appUser.getUsername());
        if (userCredential != null) {
            throw new IllegalArgumentException("用户名已存在");
        }
        // 加密密码
        appUser.setPassword(appUser.getPassword());
        appUser.setEnabled(Boolean.TRUE);
        appUser.setCreateTime(new Date());
        appUser.setUpdateTime(appUser.getCreateTime());

        appUserDao.save(appUser);
        userCredentialsDao
                .save(new UserCredential(appUser.getUsername(), "USERNAME", appUser.getId()));
        log.info("添加用户：{}", appUser);
    }

    @Override
    public void updateAppUser(AppUser appUser) {
        appUser.setUpdateTime(new Date());
        appUserDao.update(appUser);
        log.info("修改用户：{}", appUser);
    }


    @Override
    public AppUser findById(Long id) {
        return appUserDao.findById(id);
    }

    /**
     * 给用户设置角色<br>
     * 这里采用先删除老角色，再插入新角色
     */
    @Override
    public void setRoleToUser(Long id, Set<Long> roleIds) {
        AppUser appUser = appUserDao.findById(id);
        if (appUser == null) {
            throw new IllegalArgumentException("用户不存在");
        }

        userRoleDao.deleteUserRole(id, null);
        if (!CollectionUtils.isEmpty(roleIds)) {
            roleIds.forEach(roleId -> {
                userRoleDao.saveUserRoles(id, roleId);
            });
        }

        log.info("修改用户：{}的角色，{}", appUser.getUsername(), roleIds);
    }

    /**
     * 修改密码
     *
     * @param id
     * @param oldPassword
     * @param newPassword
     */
    @Override
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        AppUser appUser = appUserDao.findById(id);
        if (StringUtils.isNoneBlank(oldPassword)) {
            // 旧密码校验
          /*  if (!passwordEncoder.matches(oldPassword, appUser.getPassword())) {
                throw new IllegalArgumentException("旧密码错误");
            }*/
        }

        AppUser user = new AppUser();
        user.setId(id);
        // 加密密码
        user.setPassword(newPassword);

        updateAppUser(user);
        log.info("修改密码：{}", user);
    }


    @Override
    public Set<SysRole> findRolesByUserId(Long userId) {
        return userRoleDao.findRolesByUserId(userId);
    }

    /**
     * 绑定手机号
     */
    @Override
    public void bindingPhone(Long userId, String phone) {
        UserCredential userCredential = userCredentialsDao.findByUsername(phone);
        if (userCredential != null) {
            throw new IllegalArgumentException("手机号已被绑定");
        }

        AppUser appUser = appUserDao.findById(userId);
        appUser.setPhone(phone);

        updateAppUser(appUser);
        log.info("绑定手机号成功,username:{}，phone:{}", appUser.getUsername(), phone);

        // 绑定成功后，将手机号存到用户凭证表，后续可通过手机号+密码或者手机号+短信验证码登陆
        userCredentialsDao.save(new UserCredential(phone, "PHONE", userId));
    }

}
