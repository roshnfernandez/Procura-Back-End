package com.trintel.equipment.maintenance.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Users")
public class UserEO {
    @Column(length = 50)
    private String email;
    @Column(length = 50)
    private String password;
    @Column(length = 20)
    private String phone;
    @Column(length = 50)
    private String username;
    @Id
    @Column(name="USER_ID", nullable = false, length = 50)
    private String userId;
    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private RoleEO roles;
	@Column(name="IS_ACTIVE")
	private Character isActive;
    
    public UserEO() {
    }

    public UserEO(String email, String password, String phone, RoleEO roles,
                 String userId, String username, Character isActive) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.roles = roles;
        this.userId = userId;
        this.username = username;
        this.isActive = isActive;
    }

    public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public RoleEO getRoles() {
        return roles;
    }

    public void setRoles(RoleEO roles) {
        this.roles = roles;
    }
}
