package jpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="driverlicenses")
public class DriverLicense extends License{
	
	@Column(name="driver_Licence_name")
	private String driverLicenseName;
	@Temporal(TemporalType.DATE)
	private Date driverLicenseExpiryDate;
	@Temporal(TemporalType.DATE)
	private Date driverLicenseIssueDate;
	
	
	
	
	
	public String getDriverLicenseName() {
		return driverLicenseName;
	}
	public void setDriverLicenseName(String driverLicenseName) {
		this.driverLicenseName = driverLicenseName;
	}
	public Date getDriverLicenseExpiryDate() {
		return driverLicenseExpiryDate;
	}
	public void setDriverLicenseExpiryDate(Date driverLicenseExpiryDate) {
		this.driverLicenseExpiryDate = driverLicenseExpiryDate;
	}
	public Date getDriverLicenseIssueDate() {
		return driverLicenseIssueDate;
	}
	public void setDriverLicenseIssueDate(Date driverLicenseIssueDate) {
		this.driverLicenseIssueDate = driverLicenseIssueDate;
	}
}
