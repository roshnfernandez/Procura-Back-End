package com.trintel.equipment.maintenance.entities;


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
    @Column(name="HOURS_USED")
    private Double hoursUsed;
    @Column(name="CREATED_ON")
    private Timestamp createdOn;
    @Id
    @Column(name="LOG_ID", nullable = false, length = 50)
    private String logId;
    @Column(name="NOTICED_PROBLEMS")
    private Character noticedProblems;
    @ManyToOne
    @JoinColumn(name = "EQUIPMENT_ID")
    private EquipmentEO equipment;
    @ManyToOne
    @JoinColumn(name = "CREATED_BY")
    private UserEO users;

    public UsageLogEO() {
    }

    public UsageLogEO(String comments, UserEO users, Timestamp createdOn,
                     EquipmentEO equipment, String logId,
                     Character noticedProblems, Double hoursUsed) {
        this.comments = comments;
        this.users = users;
        this.createdOn = createdOn;
        this.equipment = equipment;
        this.logId = logId;
        this.noticedProblems = noticedProblems;
        this.hoursUsed = hoursUsed;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    public Double getHoursUsed() {
		return hoursUsed;
	}

	public void setHoursUsed(Double hoursUsed) {
		this.hoursUsed = hoursUsed;
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

    public Character getNoticedProblems() {
        return noticedProblems;
    }

    public void setNoticedProblems(Character noticedProblems) {
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
