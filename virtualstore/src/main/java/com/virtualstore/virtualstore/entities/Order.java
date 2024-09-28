package com.virtualstore.virtualstore.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double Amount;
    private Double quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "bill_id", nullable = false, referencedColumnName = "id")
    private Bill bill;

    public Order() {
    }

    public Order(Long id, Double amount, Double quantity, Product product, Bill bill) {
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

    public Product getProduct() {
        return product;
    }

    public Bill getBill() {
        return bill;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", Amount=" + Amount +
                ", quantity=" + quantity +
                ", product=" + product +
                ", bill=" + bill +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (getId() != null ? !getId().equals(order.getId()) : order.getId() != null) return false;
        if (getAmount() != null ? !getAmount().equals(order.getAmount()) : order.getAmount() != null) return false;
        if (getQuantity() != null ? !getQuantity().equals(order.getQuantity()) : order.getQuantity() != null)
            return false;
        if (getProduct() != null ? !getProduct().equals(order.getProduct()) : order.getProduct() != null) return false;
        return getBill() != null ? getBill().equals(order.getBill()) : order.getBill() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getAmount() != null ? getAmount().hashCode() : 0);
        result = 31 * result + (getQuantity() != null ? getQuantity().hashCode() : 0);
        result = 31 * result + (getProduct() != null ? getProduct().hashCode() : 0);
        result = 31 * result + (getBill() != null ? getBill().hashCode() : 0);
        return result;
    }



}
