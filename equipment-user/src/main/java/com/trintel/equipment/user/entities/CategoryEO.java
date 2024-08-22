package com.trintel.equipment.user.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIES")
public class CategoryEO{
    @Id
    @Column(name="CATEGORY_ID", nullable = false, length = 20)
    private String categoryId;
    @Column(name="CATEGORY_NAME", length = 50)
    private String categoryName;

    public CategoryEO() {
    }

    public CategoryEO(String categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
