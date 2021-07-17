package com.mss.admin.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_role2")
public class UserRole2 {

	@Id
	@GeneratedValue(generator = "user_role2_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "user_role2_seq", sequenceName = "user_role2_seq",allocationSize=1)
	private int roleId;
	private String code;
	private String value; //role description
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
