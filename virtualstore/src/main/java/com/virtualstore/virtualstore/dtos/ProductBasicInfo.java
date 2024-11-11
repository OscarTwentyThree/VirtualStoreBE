package com.virtualstore.virtualstore.dtos;

public class ProductBasicInfo {

    private Long id;
    private String name;
    private String brand;
    private String description;
    private Integer stock;
    private Double unitPrice;
    private String size;
    private String image;

    private CategoryBasicInfo category;

    private SubCategoryBasicInfo subCategory;

    public ProductBasicInfo() {
    }

    public ProductBasicInfo(Long id, String name, String brand, String description, Integer stock, Double unitPrice, String size, String image, CategoryBasicInfo category, SubCategoryBasicInfo subCategory) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.stock = stock;
        this.unitPrice = unitPrice;
        this.size = size;
        this.image = image;
        this.category = category;
        this.subCategory = subCategory;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStock() {
        return stock;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public String getSize() {
        return size;
    }

    public String getImage() {
        return image;
    }

    public CategoryBasicInfo getCategory() {
        return category;
    }

    public SubCategoryBasicInfo getSubCategory() {
        return subCategory;
    }

    public ProductBasicInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public ProductBasicInfo setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBasicInfo setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public ProductBasicInfo setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductBasicInfo setStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public ProductBasicInfo setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }   

    public ProductBasicInfo setSize(String size) {
        this.size = size;
        return this;
    }

    public ProductBasicInfo setImage(String image) {
        this.image = image;
        return this;
    }

    public ProductBasicInfo setCategory(CategoryBasicInfo category) {
        this.category = category;
        return this;
    }

    public ProductBasicInfo setSubCategory(SubCategoryBasicInfo subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    @Override
    public String toString() {
        return "ProductBasicInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", unitPrice=" + unitPrice +
                ", size='" + size + '\'' +
                ", image='" + image + '\'' +
                ", category=" + category +
                ", subCategory=" + subCategory +
                '}';
    }
    
}
