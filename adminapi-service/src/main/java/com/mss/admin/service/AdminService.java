package com.mss.admin.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.mss.admin.dto.Company;
import com.mss.admin.dto.Coverage;
import com.mss.admin.dto.Gender;
import com.mss.admin.dto.LineOfBusiness;
import com.mss.admin.dto.PolicyType;
import com.mss.admin.dto.Reason;
import com.mss.admin.dto.Role;
import com.mss.admin.dto.State;
import com.mss.admin.dto.User;
import com.mss.admin.dto.User2;
import com.mss.admin.dto.UserRole;
import com.mss.admin.dto.UserRole2;
import com.mss.admin.repo.CompanyRepo;
import com.mss.admin.repo.CoverageRepo;
import com.mss.admin.repo.GenderRepo;
import com.mss.admin.repo.LobRepo;
import com.mss.admin.repo.PolicyTypeRepo;
import com.mss.admin.repo.ReasonRepo;
import com.mss.admin.repo.RoleRepo;
import com.mss.admin.repo.StateRepo;
import com.mss.admin.repo.UserRepo;
import com.mss.admin.repo.UserRepo2;
import com.mss.admin.repo.UserRoleRepo;

@Service
public class AdminService {

	@Autowired
	private CompanyRepo companyRepo;

	@Autowired
	private CoverageRepo coverageRepo;

	@Autowired
	private GenderRepo genderRepo;

	@Autowired
	private LobRepo lobRepo;

	@Autowired
	private PolicyTypeRepo policyTypeRepo;

	@Autowired
	private ReasonRepo reasonRepo;

	@Autowired
	private UserRoleRepo userRoleRepo;

	@Autowired
	private StateRepo stateRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserRepo2 userRepo2;

	public void saveCompany(List<CompanyCode> codes) {
		List<com.mss.admin.dto.Company> list = new ArrayList<>();
		codes.forEach(e -> {
			com.mss.admin.dto.Company company = new com.mss.admin.dto.Company();
			company.setCode(e.getCode());
			company.setValue(e.getValue());
			list.add(company);
		});
		companyRepo.saveAll(list);
	}
	
	public void deleteCompany(List<CompanyCode> codes) {
		List<com.mss.admin.dto.Company> list = new ArrayList<>();
		codes.forEach(e -> {
			companyRepo.deleteById(e.getId());
		});
		
	}

	public void saveState(List<StateCode> codes) {
		List<State> list = new ArrayList<>();
		codes.forEach(e -> {
			com.mss.admin.dto.State state = new com.mss.admin.dto.State();
			state.setCode(e.getCode());
			state.setValue(e.getValue());
			list.add(state);
		});
		stateRepo.saveAll(list);
	}

	public void saveGender(List<GenderCode> codes) {
		List<Gender> list = new ArrayList<>();
		codes.forEach(e -> {
			com.mss.admin.dto.Gender clz = new com.mss.admin.dto.Gender();
			clz.setCode(e.getCode());
			clz.setValue(e.getValue());
			list.add(clz);
		});
		genderRepo.saveAll(list);
	}

	public void saveLob(List<LobCode> codes) {
		List<LineOfBusiness> list = new ArrayList<>();
		codes.forEach(e -> {
			com.mss.admin.dto.LineOfBusiness clz = new com.mss.admin.dto.LineOfBusiness();
			clz.setCode(e.getCode());
			clz.setValue(e.getValue());
			list.add(clz);
		});
		lobRepo.saveAll(list);
	}

	public void savePolicyType(List<PolicyTypeCode> codes) {
		List<PolicyType> list = new ArrayList<>();
		codes.forEach(e -> {
			PolicyType clz = new PolicyType();
			clz.setCode(e.getCode());
			clz.setValue(e.getValue());
			list.add(clz);
		});
		policyTypeRepo.saveAll(list);
	}

	public void saveReason(List<ReasonCode> codes) {
		List<Reason> list = new ArrayList<>();
		codes.forEach(e -> {
			Reason clz = new Reason();
			clz.setCode(e.getCode());
			clz.setValue(e.getValue());
			list.add(clz);
		});
		reasonRepo.saveAll(list);
	}

	public void saveRole(List<RoleCode> codes) {
		List<Role> list = new ArrayList<>();
		codes.forEach(e -> {
			Role clz = new Role();
			clz.setRole(e.getRole());
			clz.setDescription(e.getDescription());
			list.add(clz);
		});
		roleRepo.saveAll(list);
	}

	public void deleteRole(List<RoleCode> codes) {
		codes.forEach(e -> {
			roleRepo.deleteById(e.getRoleId());
		});
	}

	public void saveUser(UserCode userCode) {
		User clz = new User();
		Optional<User> userDb = userRepo.findByUsername(userCode.getUsername());
		if (!userDb.isPresent()) {
			clz.setUsername(userCode.getUsername());
			clz.setPassword(userCode.getPassword());
			if (!userCode.getUserRoles().isEmpty()) {
				userCode.getUserRoles().forEach(a -> {
					UserRole role = new UserRole();
					role.setCode(a.getRole());
					role.setValue(a.getDescription());
					clz.getRoles().add(role);
				});
			}
			userRepo.save(clz);
		} else
			updateUser(userCode);
	}
	
	public void saveSingleUser(UserCode userCode) {
		User2 clz = new User2();
		Optional<User2> userDb = userRepo2.findByUsername(userCode.getUsername());
		if (!userDb.isPresent()) {
			clz.setUsername(userCode.getUsername());
			clz.setPassword(userCode.getPassword());
			if (!userCode.getUserRoles().isEmpty()) {
				userCode.getUserRoles().forEach(a -> {
					UserRole2 role = new UserRole2();
					role.setCode(a.getRole());
					role.setValue(a.getDescription());
					clz.setRoles(role);
				});
			}
			userRepo2.save(clz);
		} 
	}

	// update password, email, description
	public void updateUser(UserCode request) {
		Optional<User> userDb = userRepo.findByUsername(request.getUsername());
		User clz = new User();
		if (userDb.isPresent()) {
			clz.setUserId(userDb.get().getUserId());
			clz.setUsername(userDb.get().getUsername());
			clz.setPassword(request.getPassword());

			List<UserRole> rolesdb = userDb.get().getRoles();
			if (!rolesdb.isEmpty()) {
				userRepo.updateUser(request.getPassword(), userDb.get().getUserId());

				request.getUserRoles().forEach(x -> {
					boolean exists = rolesdb.stream().anyMatch(b -> b.getCode().equalsIgnoreCase(x.getRole()));
					if (!exists) {
						userRoleRepo.addRole(x.getRole(), x.getDescription(), userDb.get().getUserId());
					}

				});
			} else {
				clz.setRoles(userDb.get().getRoles());
				userRepo.save(clz);
			}

		} else
			saveUser(request);

	}

	public void addUserRole(UserCode userCode) {
		Optional<User> user = userRepo.findByUsername(userCode.getUsername());
		user.ifPresent(a -> {
			userCode.getUserRoles().forEach(x -> {
				boolean exists = a.getRoles().stream().anyMatch(b -> b.getCode().equalsIgnoreCase(x.getRole()));
				if (!exists)
					userRoleRepo.addRole(x.getRole(), x.getDescription(), a.getUserId());

			});
		});
	}

	public void deleteUserRole(UserCode userCode) {
		Optional<User> user = userRepo.findByUsername(userCode.getUsername());
		user.ifPresent(a -> {
			userCode.getUserRoles().forEach(x -> {
				userRoleRepo.deleteRole(x.getRole(), a.getUserId());
			});
		});
	}

	public void saveCoverage(List<CoverageCode> codes) {
		List<Coverage> list = new ArrayList<>();
		codes.forEach(e -> {
			Coverage clz = new Coverage();
			clz.setCode(e.getCode());
			clz.setValue(e.getValue());
			clz.setCoverageType(e.getCoverageType());
			clz.setInnerLimit(e.getInnerLimit());
			clz.setOuterLimit(e.getOuterLimit());

			list.add(clz);
		});
		coverageRepo.saveAll(list);
	}

	public ListOfCodes getListOfCodes() {
		ListOfCodes list = new ListOfCodes();

		List<Company> companies = new ArrayList<>();
		Set<CompanyCode> companyCodeSet = new HashSet<>();

		List<Reason> reasons = new ArrayList<>();
		Set<ReasonCode> reasonCodeSet = new HashSet<>();
		
		companies = companyRepo.findAll();
		
		reasons= reasonRepo.findAll();

		if (!companies.isEmpty()) {
			companies.forEach(a -> {
				CompanyCode companycode = new CompanyCode();
				companycode.setCode(a.getCode());
				companycode.setValue(a.getValue());
				companyCodeSet.add(companycode);
			});
		}
		
		if (!reasons.isEmpty()) {
			reasons.forEach(a -> {
				ReasonCode reasoncode = new ReasonCode();
				reasoncode.setCode(a.getCode());
				reasoncode.setValue(a.getValue());
				reasonCodeSet.add(reasoncode);
			});
		}
		
		list.setCompanyCodes(companyCodeSet);
		list.setReasons(reasonCodeSet);
		return list;
	}

	/*
	 * public List<RoleCode> getRolesList() { List<Role> roles=roleRepo.findAll();
	 * List<RoleCode> roleCodes=new ArrayList<>(); if(!roles.isEmpty()) {
	 * roleCodes=roles; } }
	 */
}
