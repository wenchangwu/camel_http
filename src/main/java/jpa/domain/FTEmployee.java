package jpa.domain;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TBL_EMPLOYEE")
@AssociationOverrides({
	@AssociationOverride(name="address",joinColumns=@JoinColumn(name="addr_id"))
})
public class FTEmployee extends Employee{

	@Column(name="salary")
	private int salary;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
