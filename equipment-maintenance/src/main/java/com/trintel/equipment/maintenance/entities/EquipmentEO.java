package com.trintel.equipment.maintenance.entities;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name="EQUIPMENT")
public class EquipmentEO{
    private Long cost;
    @Id
    @Column(name="EQUIPMENT_ID", nullable = false, length = 50)
    private String equipmentId;
    @Column(name="MANUFACTURED_ON")
    private Timestamp manufacturedOn;
    @Column(name="PURCHASED_ON")
    private Timestamp purchasedOn;
    @Column(name="SERVICE_DURATION_IN_DAYS")
    private Long serviceDurationInDays;
    @Column(name="SERVICE_DURATION_IN_HOURS_USED")
    private Long serviceDurationInHoursUsed;
    @Column(length = 20)
    private String status;
    @Column(name="ORDER_NUM")
    private String orderNum;
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private CatalogEO catalog;
    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID")
    private ProviderEO providers;
	@Column(name="IS_ACTIVE")
	private Character isActive;

    public EquipmentEO() {
    }

    public EquipmentEO(Long cost, String equipmentId, Timestamp manufacturedOn, String orderNum,
                     CatalogEO catalog, ProviderEO providers,
                     Timestamp purchasedOn, Long serviceDurationInDays,
                     Long serviceDurationInHoursUsed, String status, Character isActive ) {
        this.cost = cost;
        this.orderNum = orderNum;
        this.equipmentId = equipmentId;
        this.manufacturedOn = manufacturedOn;
        this.catalog = catalog;
        this.providers = providers;
        this.purchasedOn = purchasedOn;
        this.serviceDurationInDays = serviceDurationInDays;
        this.serviceDurationInHoursUsed = serviceDurationInHoursUsed;
        this.status = status;
        this.isActive = isActive;
    }
    
    public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Timestamp getManufacturedOn() {
        return manufacturedOn;
    }

    public void setManufacturedOn(Timestamp manufacturedOn) {
        this.manufacturedOn = manufacturedOn;
    }


    public Timestamp getPurchasedOn() {
        return purchasedOn;
    }

    public void setPurchasedOn(Timestamp purchasedOn) {
        this.purchasedOn = purchasedOn;
    }

    public Long getServiceDurationInDays() {
        return serviceDurationInDays;
    }

    public void setServiceDurationInDays(Long serviceDurationInDays) {
        this.serviceDurationInDays = serviceDurationInDays;
    }

    public Long getServiceDurationInHoursUsed() {
        return serviceDurationInHoursUsed;
    }

    public void setServiceDurationInHoursUsed(Long serviceDurationInHoursUsed) {
        this.serviceDurationInHoursUsed = serviceDurationInHoursUsed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CatalogEO getCatalog() {
        return catalog;
    }

    public void setCatalog(CatalogEO catalog) {
        this.catalog = catalog;
    }

    public ProviderEO getProviders() {
        return providers;
    }

    public void setProviders(ProviderEO providers) {
        this.providers = providers;
    }
}
