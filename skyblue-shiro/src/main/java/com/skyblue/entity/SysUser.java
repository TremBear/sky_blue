package com.skyblue.entity;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 * 
 * @author TremBear
 * @email 1424479171@qq.com
 * @date 2018年3月18日 上午9:28:55
 */
public class SysUser implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private transient String password;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 状态  0：禁用   1：正常
	 */
	private Integer status;

	/**
	 * 角色ID列表
	 */
	private List<Long> roleIdList;
	private String roleId;
	/**
	 * 创建者ID
	 */
	private Long createUserId;

	/**
	 * 创建时间
	 */
	private Date createTime;
	private String orgId;
	private String orderPowerType;
	private String orderArea;
	private String[] orderAreaArr;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Long> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrderPowerType() {
		return orderPowerType;
	}

	public void setOrderPowerType(String orderPowerType) {
		this.orderPowerType = orderPowerType;
	}

	public String getOrderArea() {
		return orderArea;
	}

	public void setOrderArea(String orderArea) {
		this.orderArea = orderArea;
	}

	public String[] getOrderAreaArr() {
		return orderAreaArr;
	}

	public void setOrderAreaArr(String[] orderAreaArr) {
		this.orderAreaArr = orderAreaArr;
	}
}
