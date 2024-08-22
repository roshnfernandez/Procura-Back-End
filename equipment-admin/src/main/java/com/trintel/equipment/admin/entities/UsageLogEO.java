package com.trintel.equipment.admin.entities;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USAGE_LOGS")
public class UsageLogEO{
    @Column(length = 200)
    private String comments;
    @Column(name="CREATED_ON")
    private Timestamp createdOn;
    @Id
    @Column(name="LOG_ID", nullable = false, length = 50)
    private String logId;
    @Column(name="NOTICED_PROBLEMS")
    private String noticedProblems;
    @ManyToOne
    @JoinColumn(name = "EQUIPMENT_ID")
    private EquipmentEO equipment;
    @ManyToOne
    @JoinColumn(name = "CREATED_BY")
    private UserEO users;
	@Column(name="IS_ACTIVE")
	private Character isActive;
	
    public UsageLogEO() {
    }

    public UsageLogEO(String comments, UserEO users, Timestamp createdOn,
                     EquipmentEO equipment, String logId,
                     String noticedProblems, Character isActive) {
        this.comments = comments;
        this.users = users;
        this.createdOn = createdOn;
        this.equipment = equipment;
        this.logId = logId;
        this.noticedProblems = noticedProblems;
        this.isActive = isActive;
    }

    public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }


    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getNoticedProblems() {
        return noticedProblems;
    }

    public void setNoticedProblems(String noticedProblems) {
        this.noticedProblems = noticedProblems;
    }

    public EquipmentEO getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentEO equipment) {
        this.equipment = equipment;
    }

    public UserEO getUsers() {
        return users;
    }

    public void setUsers(UserEO users) {
        this.users = users;
    }
}
