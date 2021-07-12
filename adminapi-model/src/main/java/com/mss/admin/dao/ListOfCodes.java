package com.mss.admin.dao;

import java.util.HashSet;
import java.util.Set;

public class ListOfCodes {

	private Set<StateCode> stateCodes=new HashSet<StateCode>();
	private Set<CompanyCode> companyCodes=new HashSet<CompanyCode>();
	private Set<ReasonCode> reasons=new HashSet<ReasonCode>();
	private Set<LobCode> lineOfBusiness=new HashSet<LobCode>();
	private Set<PolicyTypeCode> policyTypes=new HashSet<PolicyTypeCode>();
	private Set<GenderCode> gender=new HashSet<GenderCode>();
	private Set<CoverageCode> coverageCodes=new HashSet<CoverageCode>();
	private Set<RoleCode> roles=new HashSet<RoleCode>();
	private Set<UserCode> users=new HashSet<UserCode>();
	public Set<StateCode> getStateCodes() {
		return stateCodes;
	}
	public void setStateCodes(Set<StateCode> stateCodes) {
		this.stateCodes = stateCodes;
	}
	public Set<CompanyCode> getCompanyCodes() {
		return companyCodes;
	}
	public void setCompanyCodes(Set<CompanyCode> companyCodes) {
		this.companyCodes = companyCodes;
	}
	public Set<ReasonCode> getReasons() {
		return reasons;
	}
	public void setReasons(Set<ReasonCode> reasons) {
		this.reasons = reasons;
	}
	public Set<LobCode> getLineOfBusiness() {
		return lineOfBusiness;
	}
	public void setLineOfBusiness(Set<LobCode> lineOfBusiness) {
		this.lineOfBusiness = lineOfBusiness;
	}
	public Set<PolicyTypeCode> getPolicyTypes() {
		return policyTypes;
	}
	public void setPolicyTypes(Set<PolicyTypeCode> policyTypes) {
		this.policyTypes = policyTypes;
	}
	public Set<GenderCode> getGender() {
		return gender;
	}
	public void setGender(Set<GenderCode> gender) {
		this.gender = gender;
	}
	public Set<CoverageCode> getCoverageCodes() {
		return coverageCodes;
	}
	public void setCoverageCodes(Set<CoverageCode> coverageCodes) {
		this.coverageCodes = coverageCodes;
	}
	public Set<RoleCode> getRoles() {
		return roles;
	}
	public void setRoles(Set<RoleCode> roles) {
		this.roles = roles;
	}
	public Set<UserCode> getUsers() {
		return users;
	}
	public void setUsers(Set<UserCode> users) {
		this.users = users;
	}
	
	
	
}
