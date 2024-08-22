package com.trintel.equipment.maintenance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "BILL_ITEMS")
public class BillItemEO{
    @Id
    @Column(name="ITEM_ID", nullable = false, length = 50)
    private String itemId;
    @Column(name="MP_PER_UNIT")
    private Long mpPerUnit;
    private Long quantity;
    @Column(name="SP_PER_UNIT")
    private Long spPerUnit;
    @Column(name="TOTAL_PRICE")
    private Long totalPrice;
    @Column(name = "BILL_NUMBER")
    private String bill;
    @ManyToOne
    @JoinColumn(name = "CATALOG_ITEM_ID")
    private CatalogEO catalog;
	@Column(name="IS_ACTIVE")
	private Character isActive;

    public BillItemEO() {
    }

    public BillItemEO(String bill, CatalogEO catalog, String itemId,
                     Long mpPerUnit, Long quantity, Long spPerUnit,
                     Long totalPrice, Character isActive) {
        this.bill = bill;
        this.catalog = catalog;
        this.itemId = itemId;
        this.mpPerUnit = mpPerUnit;
        this.quantity = quantity;
        this.spPerUnit = spPerUnit;
        this.totalPrice = totalPrice;
        this.isActive = isActive;
    }


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Long getMpPerUnit() {
        return mpPerUnit;
    }

    public void setMpPerUnit(Long mpPerUnit) {
        this.mpPerUnit = mpPerUnit;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getSpPerUnit() {
        return spPerUnit;
    }

    public void setSpPerUnit(Long spPerUnit) {
        this.spPerUnit = spPerUnit;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getBills() {
        return bill;
    }

    public void setBills(String bills) {
        this.bill = bills;
    }

    public CatalogEO getCatalog() {
        return catalog;
    }

    public void setCatalog(CatalogEO catalog) {
        this.catalog = catalog;
    }
}
