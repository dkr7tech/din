package com.model.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * The persistent class for the tt_user database table.
 * 
 */
@Entity
@Table(name="tt_user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	private int blocked;

	@Temporal(TemporalType.TIMESTAMP)
	private Date blockedtime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	private String dob;

	private String email;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="last_name")
	private String lastName;

	private String login;

	@Column(name="middle_name")
	private String middleName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date modtime;

	@Column(name="no_attempt")
	private int noAttempt;

	private String password;

	private int status;

	//bi-directional many-to-one association to UserRole
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)  
	    @JoinTable(name="tl_user_role",  
	    joinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")},  
	    inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")} ,foreignKey = @ForeignKey(name = "UserRoleForeignKey"))
	//@OneToMany(mappedBy="user")
	private List<Role> roleList;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    @JoinColumn(name = "userpreferenceid", referencedColumnName = "UserPreferenceId" ,foreignKey = @ForeignKey(name = "UserPreferenceForeignKey"))
    private UserPreference userPreference;
	public User(int userId, String login) {
		super();
		this.userId = userId;
		this.login = login;
	}

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBlocked() {
		return this.blocked;
	}

	public void setBlocked(int blocked) {
		this.blocked = blocked;
	}

	public Date getBlockedtime() {
		return this.blockedtime;
	}

	public void setBlockedtime(Date blockedtime) {
		this.blockedtime = blockedtime;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getModtime() {
		return this.modtime;
	}

	public void setModtime(Date modtime) {
		this.modtime = modtime;
	}

	public int getNoAttempt() {
		return this.noAttempt;
	}

	public void setNoAttempt(int noAttempt) {
		this.noAttempt = noAttempt;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public UserPreference getUserPreference() {
		return userPreference;
	}

	public void setUserPreference(UserPreference userPreference) {
		this.userPreference = userPreference;
	}

	

}