package com.cloud.modle.apimodle.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色
 */
@Data
public class SysRole implements Serializable {

	private static final long serialVersionUID = -2054359538140713354L;

	private Long id;
	/**
     * 角色code
	 */
	private String code;

    /**
     * 角色名称
	 */
	private String name;
	private Date createTime;
	private Date updateTime;
}
