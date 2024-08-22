package com.trintel.equipment.admin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_ITEMS")
public class OrderItemEO {
    @Id
    @Column(name="ITEM_ID", nullable = false, length = 20)
    private String itemId;
    private Long quantity;
    @Column(name = "ORDER_NUM")
    private String order;
	@ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private CatalogEO catalog;
	@Column(name="IS_ACTIVE")
	private Character isActive;
	
    public OrderItemEO() {
    }

    public OrderItemEO(String itemId, String order, CatalogEO catalog,
                      Long quantity, Character isActive) {
        this.itemId = itemId;
        this.order = order;
        this.catalog = catalog;
        this.quantity = quantity;
        this.isActive = isActive;
    }

    public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }


    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getorder() {
        return order;
    }

    public void setorder(String order) {
        this.order = order;
    }

    public CatalogEO getCatalog() {
        return catalog;
    }

    public void setCatalog(CatalogEO catalog) {
        this.catalog = catalog;
    }
    
    @Override
	public String toString() {
		return "OrderItemEO [itemId=" + itemId + ", quantity=" + quantity + ", order=" + order + ", catalog=" + catalog
				+ "]";
	}
}
