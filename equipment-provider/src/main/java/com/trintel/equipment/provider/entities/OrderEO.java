package com.trintel.equipment.provider.entities;

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
@Table(name="ORDERS")
public class OrderEO{
    @Column(name="BILL_NUMBER", length = 20)
    private String billNumber;
    @Column(name="ORDERED_ON")
    private Timestamp orderedOn;
    @Column(name="SHIPPED_ON")
    private Timestamp shippedOn;
    @Column(name="DELIVERED_ON")
    private Timestamp deliveredOn;
    @Id
    @Column(name="ORDER_NUM", nullable = false)
    private String orderNum;
    @Column(name="ORDER_STATUS", length = 20)
    private String orderStatus;
    
    @OneToMany(mappedBy="order")
    private List<OrderItemEO> orderItems;
    
    @ManyToOne
    @JoinColumn(name = "PROVIDER_ID")
    private ProviderEO providers;
    
	@Column(name="IS_ACTIVE")
	private Character isActive;
	
	@Column(name="ESTIMATED_TOTAL")
	private Integer estimatedTotal;
    
	@Column(name="ACTUAL_TOTAL")
	private Integer actualTotal;
	
    public OrderEO() {
    }

    public OrderEO(
    		Timestamp deliveredOn,
    		Timestamp shippedOn,
    		Integer estimatedTotal,
    		Integer actualTotal,
    		String billNumber, String orderNum, String orderStatus,
                  Timestamp orderedOn, ProviderEO providers, List<OrderItemEO> orderItems, Character isActive) {
        this.billNumber = billNumber;
        this.orderNum = orderNum;
        this.orderStatus = orderStatus;
        this.orderedOn = orderedOn;
        this.providers = providers;
        this.orderItems = orderItems;
        this.isActive = isActive;
        this.estimatedTotal = estimatedTotal;
        this.actualTotal = actualTotal;
        this.shippedOn = shippedOn;
        this.deliveredOn = deliveredOn;
    }

    public Timestamp getShippedOn() {
		return shippedOn;
	}

	public void setShippedOn(Timestamp shippedOn) {
		this.shippedOn = shippedOn;
	}

	public Timestamp getDeliveredOn() {
		return deliveredOn;
	}

	public void setDeliveredOn(Timestamp deliveredOn) {
		this.deliveredOn = deliveredOn;
	}

	public Integer getEstimatedTotal() {
		return estimatedTotal;
	}

	public void setEstimatedTotal(Integer estimatedTotal) {
		this.estimatedTotal = estimatedTotal;
	}

	public Integer getactualTotal() {
		return actualTotal;
	}

	public void setactualTotal(Integer actualTotal) {
		this.actualTotal = actualTotal;
	}

	public List<OrderItemEO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemEO> orderItems) {
		this.orderItems = orderItems;
	}

	public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public Timestamp getOrderedOn() {
        return orderedOn;
    }

    public void setOrderedOn(Timestamp orderedOn) {
        this.orderedOn = orderedOn;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
	public String toString() {
		return "OrderEO [billNumber=" + billNumber + ", orderedOn=" + orderedOn + ", orderNum=" + orderNum
				+ ", orderStatus=" + orderStatus + ", orderItems=" + orderItems + ", providers=" + providers + "]";
	}

	public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public ProviderEO getProviders() {
        return providers;
    }

    public void setProviders(ProviderEO providers) {
        this.providers = providers;
    }
}
