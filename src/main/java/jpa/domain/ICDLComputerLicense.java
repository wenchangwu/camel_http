package jpa.domain;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="icdlcomputerlicense")
@AttributeOverride(name="licenseId",column=@Column(name="icdlLicenseId"))
@AssociationOverride(name="employee",joinColumns={@JoinColumn(name="icdlEmployeeId")})
public class ICDLComputerLicense extends License{
	private String icdlLicenseDegree;
	
	public String getIcdlLicenseDegree() {
		return icdlLicenseDegree;
	}

	public void setIcdlLicenseDegree(String icdlLicenseDegree) {
		this.icdlLicenseDegree = icdlLicenseDegree;
	}


	
}
