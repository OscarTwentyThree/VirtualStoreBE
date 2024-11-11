package com.virtualstore.virtualstore.dtos;


public class OrderBasicInfo {

    private Long id;
    private Double Amount;
    private Double quantity;

    private ProductBasicInfo product;

    private BillForOrder bill;

    public OrderBasicInfo() {
    }

    public OrderBasicInfo(Long id, Double amount, Double quantity, ProductBasicInfo product, BillForOrder bill) {
        this.id = id;
        Amount = amount;
        this.quantity = quantity;
        this.product = product;
        this.bill = bill;
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return Amount;
    }

    public Double getQuantity() {
        return quantity;
    }

    public ProductBasicInfo getProduct() {
        return product;
    }

    public BillForOrder getBill() {
        return bill;
    }

    public OrderBasicInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public OrderBasicInfo setAmount(Double amount) {
        Amount = amount;
        return this;
    }

    public OrderBasicInfo setQuantity(Double quantity) {
        this.quantity = quantity;
        return this;
    }

    public OrderBasicInfo setProduct(ProductBasicInfo product) {
        this.product = product;
        return this;
    }

   public OrderBasicInfo setBill(BillForOrder bill) {
        this.bill = bill;
        return this;
    }

    @Override
    public String toString() {
        return "OrderBasicInfo{" +
                "id=" + id +
                ", Amount=" + Amount +
                ", quantity=" + quantity +
                ", product=" + product +
                ", bill=" + bill +
                '}';
    }
    
}
