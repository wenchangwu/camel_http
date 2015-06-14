/*
 * 
 */
package jpa.domain.realname;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * 实名认证状态
 * 
 * @author ray
 * @since 1.4.0
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "STATUS", discriminatorType = DiscriminatorType.STRING, length = 2)
@Table(name = "TBL_REAL_NAME_AUTH_STATUS")
abstract public class RealNameAuthStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "STATUS", insertable = false, nullable = false, updatable = false)
	private String status;
	/**
	 * 操作人员id
	 */
	@Column(name = "OPERATOR_ID")
	private Long operatorId;

	/**
	 * 操作时间
	 */
	@Column(name = "OPERATOR_DATE")
	private Date operatorDate;

	/**
	 * 操作人员登录名
	 */
	@Column(name = "OPERATOR_NAME")
	private String operatorName;
	/**
	 * 备注
	 */
	@Column(name = "REMARK")
	private String remark;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	public Date getOperatorDate() {
		return operatorDate;
	}
	public void setOperatorDate(Date operatorDate) {
		this.operatorDate = operatorDate;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	
	
}
