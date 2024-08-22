package com.trintel.equipment.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROVIDERS")
public class ProviderEO {
    @Column(name="IS_ACTIVE")
    private String isActive;
    @Column(name="PROVIDER_ADDRESS", length = 100)
    private String providerAddress;
    @Id
    @Column(name="PROVIDER_ID", nullable = false, length = 50)
    private String providerId;
    @Column(name="PROVIDER_NAME", length = 50)
    private String providerName;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEO users;

    public ProviderEO() {
    }

    public ProviderEO(String isActive, String providerAddress,
                     String providerId, String providerName, UserEO users) {
        this.isActive = isActive;
        this.providerAddress = providerAddress;
        this.providerId = providerId;
        this.providerName = providerName;
        this.users = users;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public UserEO getUsers() {
        return users;
    }

    public void setUsers(UserEO users) {
        this.users = users;
    }
}
