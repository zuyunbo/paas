package com.cloud.modle.apimodle.user;

import lombok.Data;

import java.util.Date;

/**
 * 权限
 */
@Data
public class SysPermission {


    private Long id;
    private String permission;
    private String name;

    private Date createTime;
    private Date updateTime;

}
