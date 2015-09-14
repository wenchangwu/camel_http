package jpa.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private int employeeId;
	
	@Basic(optional=false)
	private String employeeName;
	
	@OneToMany(mappedBy = "employee", cascade = { CascadeType.ALL })
	@MapKey(name = "authType")
	private Map<AuthType, AuthInfo> authInfos = new HashMap<AuthType, AuthInfo>();

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Map<AuthType, AuthInfo> getAuthInfos() {
		return authInfos;
	}

	public void setAuthInfos(Map<AuthType, AuthInfo> authInfos) {
		this.authInfos = authInfos;
	}
	
}
