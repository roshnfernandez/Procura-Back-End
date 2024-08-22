package com.trintel.equipment.admin.entities;



import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Bills")
public class BillEO {
    @Column(name="BILLED_ON")
    private Timestamp billedOn;
    @Id
    @Column(name="BILL_NUMBER", nullable = false, length = 50)
    private String billNumber;
    @Column(name="PAID_ON")
    @OneToMany(mappedBy="bill")
    private List<BillItemEO> billItems;
    private Timestamp paidOn;
    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID")
    private ProviderEO providers;
	@Column(name="IS_ACTIVE")
	private Character isActive;
    
    public BillEO() {
    }

    public BillEO(String billNumber, Timestamp billedOn, Timestamp paidOn,
                 ProviderEO providers, List<BillItemEO> billItems, Character isActive) {
        this.billNumber = billNumber;
        this.billedOn = billedOn;
        this.paidOn = paidOn;
        this.providers = providers;
        this.billItems = billItems;
        this.isActive = isActive;
    }

    public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public Timestamp getBilledOn() {
        return billedOn;
    }

    public void setBilledOn(Timestamp billedOn) {
        this.billedOn = billedOn;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public List<BillItemEO> getBillItems() {
		return billItems;
	}

	public void setBillItems(List<BillItemEO> billItems) {
		this.billItems = billItems;
	}

	public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public Timestamp getPaidOn() {
        return paidOn;
    }

    public void setPaidOn(Timestamp paidOn) {
        this.paidOn = paidOn;
    }


    public ProviderEO getProviders() {
        return providers;
    }

    public void setProviders(ProviderEO providers) {
        this.providers = providers;
    }
}
