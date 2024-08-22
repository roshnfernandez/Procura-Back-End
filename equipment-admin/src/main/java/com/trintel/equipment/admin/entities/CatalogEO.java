package com.trintel.equipment.admin.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CATALOG")
public class CatalogEO {
    @Id
    @Column(name="CATALOG_ID", nullable = false, length = 50)
    private String catalogId;
    @Column(name="MANUFACTURER_NAME", length = 50)
    private String manufacturerName;
    @Column(name="PRODUCT_NAME", length = 100)
    private String productName;
    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryEO categories;
	@Column(name="IS_ACTIVE")
	private Character isActive;
	@Column(name="MARKED_PRICE")
	private Integer markedPrice;
	
    public CatalogEO() {
    }

    public CatalogEO(String catalogId, CategoryEO categories,
                   String manufacturerName, String productName, Character isActive, Integer markedPrice) {
        this.catalogId = catalogId;
        this.categories = categories;
        this.manufacturerName = manufacturerName;
        this.productName = productName;
        this.isActive = isActive;
        this.markedPrice = markedPrice;
    }

    
    public Integer getMarkedPrice() {
		return markedPrice;
	}

	public void setMarkedPrice(Integer markedPrice) {
		this.markedPrice = markedPrice;
	}

	public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }


    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public CategoryEO getCategories() {
        return categories;
    }

    public void setCategories(CategoryEO categories) {
        this.categories = categories;
    }
}
