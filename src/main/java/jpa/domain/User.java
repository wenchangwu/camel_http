package jpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import jpa.domain.realname.RealNameAuthStatus;

@Entity
@Table(name = "tbl_user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User() {

	}

	
	public User(int id, String name) {
		this.id = id;
		this.userName = name;
	}
	
	@OneToOne
	@JoinColumn(name="status_id")
	private RealNameAuthStatus realNameAuthStatus;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "user_name")
	private String userName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public RealNameAuthStatus getRealNameAuthStatus() {
		return realNameAuthStatus;
	}


	public void setRealNameAuthStatus(RealNameAuthStatus realNameAuthStatus) {
		this.realNameAuthStatus = realNameAuthStatus;
	}

}
