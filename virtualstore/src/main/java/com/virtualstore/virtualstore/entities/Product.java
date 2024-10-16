package com.virtualstore.virtualstore.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String brand;
    private String description;
    private Integer stock;
    private Double unitPrice;
    private String size;
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "subCategory_id", nullable = false, referencedColumnName = "id")
    private SubCategory subCategory;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = false, mappedBy = "product")
    private List<Order> orders;

    public Product() {
    }

    public Product(Long id, String name, String brand, String description, Integer stock, Double unitPrice, String size, String image, Category category, SubCategory subCategory, List<Order> orders) {
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
        this.orders = orders;
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

    public Category getCategory() {
        return category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Product{" +
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
                ", orders=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (brand != null ? !brand.equals(product.brand) : product.brand != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (stock != null ? !stock.equals(product.stock) : product.stock != null) return false;
        if (unitPrice != null ? !unitPrice.equals(product.unitPrice) : product.unitPrice != null) return false;
        if (size != null ? !size.equals(product.size) : product.size != null) return false;
        if (image != null ? !image.equals(product.image) : product.image != null) return false;
        if (category != null ? !category.equals(product.category) : product.category != null) return false;
        if (subCategory != null ? !subCategory.equals(product.subCategory) : product.subCategory != null) return false;
        return orders != null ? orders.equals(product.orders) : product.orders == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (stock != null ? stock.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (subCategory != null ? subCategory.hashCode() : 0);
        result = 31 * result + (orders != null ? orders.hashCode() : 0);
        return result;
    }



   
    
}
