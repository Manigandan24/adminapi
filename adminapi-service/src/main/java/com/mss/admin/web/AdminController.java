package com.mss.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mss.admin.dao.CompanyCode;
import com.mss.admin.dao.CoverageCode;
import com.mss.admin.dao.GenderCode;
import com.mss.admin.dao.ListOfCodes;
import com.mss.admin.dao.LobCode;
import com.mss.admin.dao.PolicyTypeCode;
import com.mss.admin.dao.ReasonCode;
import com.mss.admin.dao.RoleCode;
import com.mss.admin.dao.StateCode;
import com.mss.admin.dao.UserCode;
import com.mss.admin.service.AdminService;

@RestController
@RequestMapping(path = "/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@CrossOrigin(origins = "http://localhost:4100")
	@GetMapping("codes")
	public ListOfCodes getCodes(){
		return adminService.getListOfCodes();
	}
	
	@GetMapping("user/{username}")
	public List<UserCode> getUserRole(@PathVariable(name = "username") String username){
		return null;
	}
	
	@PostMapping("company")
	public void addCompany(@RequestBody List<CompanyCode> category) {
		adminService.saveCompany(category);
	}
	
	@DeleteMapping("company")
	public void updateCompany(@RequestBody List<CompanyCode> category) {
		adminService.saveCompany(category);
	}
	
	@PostMapping("state")
	public void addState(@RequestBody List<StateCode> category) {
		adminService.saveState(category);
	}
	
	@PutMapping("state")
	public void updateState(@RequestBody List<StateCode> category) {
		adminService.saveState(category);
	}
	
	@PostMapping("gender")
	public void addGender(@RequestBody List<GenderCode> category) {
		adminService.saveGender(category);
	}
	
	@PutMapping("gender")
	public void updateGender(@RequestBody List<GenderCode> category) {
		adminService.saveGender(category);
	}
	
	@PostMapping("lob")
	public void addLob(@RequestBody List<LobCode> category) {
		adminService.saveLob(category);
	}
	
	@PutMapping("lob")
	public void updateLob(@RequestBody List<LobCode> category) {
		adminService.saveLob(category);
	}
	
	@PostMapping("policytype")
	public void addPolicyType(@RequestBody List<PolicyTypeCode> category) {
		adminService.savePolicyType(category);
	}
	
	@PutMapping("policytype")
	public void updatePolicyType(@RequestBody List<PolicyTypeCode> category) {
		adminService.savePolicyType(category);
	}
	
	@PostMapping("reason")
	public void addReason(@RequestBody List<ReasonCode> category) {
		adminService.saveReason(category);
	}
	
	@PutMapping("reason")
	public void updateReason(@RequestBody List<ReasonCode> category) {
		adminService.saveReason(category);
	}
	
	@PostMapping("role")
	public void addRole(@RequestBody List<RoleCode> category) {
		adminService.saveRole(category);
	}
	
	@DeleteMapping("role")
	public void updateRole(@RequestBody List<RoleCode> category) {
		adminService.deleteRole(category);
	}
	
	@PostMapping("user")
	public void addUser(@RequestBody UserCode category) {
		adminService.saveUser(category);
	}
	
	@PutMapping("user")
	public void updateUser(@RequestBody UserCode category) {
		adminService.updateUser(category);
	}
	
	@PostMapping("user/role")
	public void addUserRole(@RequestBody UserCode category) {
		adminService.addUserRole(category);
	}
	
	@DeleteMapping("user/role")
	public void deleteUserRole(@RequestBody UserCode category) {
		adminService.deleteUserRole(category);
	}
	
	@PostMapping("coverage")
	public void addCoverage(@RequestBody List<CoverageCode> category) {
		adminService.saveCoverage(category);
	}
	
	@DeleteMapping("coverage")
	public void deleteCoverage(@RequestBody List<CoverageCode> category) {
		adminService.saveCoverage(category);
	}
	
}
