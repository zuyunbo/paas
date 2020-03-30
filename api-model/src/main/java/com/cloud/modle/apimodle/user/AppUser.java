package com.cloud.modle.apimodle.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 2u
 */
@Data
public class AppUser implements Serializable {

	private static final long serialVersionUID = 611197991672067628L;

	private Long id;
	private String username;
	private String password;
	/**
     * 昵称
	 */
	private String nickname;
	/**
     * 头像url
	 */
	private String headImgUrl;
	private String phone;
	private Integer sex;
	/**
	 * 状态（1有效,0无效）
	 */
	private Boolean enabled;
	/**
     * 预留字段
	 */
	private String type;
	private Date createTime;
	private Date updateTime;

}
