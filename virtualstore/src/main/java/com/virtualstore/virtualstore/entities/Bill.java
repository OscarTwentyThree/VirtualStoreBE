package com.virtualstore.virtualstore.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double total;
    private Double subtotal;
    private Double tax;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "paymentMethod_id", nullable = false, referencedColumnName = "id")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false, referencedColumnName = "id")
    private Status status;

    @OneToMany (cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "bill")
    private List<Order> orders;

    public Bill() {
    }

    public Bill(Long id, Double total, Double subtotal, Double tax, User user, PaymentMethod paymentMethod, Status status, List<Order> orders) {
        this.id = id;
        this.total = total;
        this.subtotal = subtotal;
        this.tax = tax;
        this.user = user;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.orders = orders;
    }

    public Long getId() {
        return id;
    }

    public Double getTotal() {
        return total;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Double getTax() {
        return tax;
    }

    public User getUser() {
        return user;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public Status getStatus() {
        return status;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", total=" + total +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", user=" + user +
                ", paymentMethod=" + paymentMethod +
                ", status=" + status +
                ", orders=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bill)) return false;

        Bill bill = (Bill) o;

        if (getId() != null ? !getId().equals(bill.getId()) : bill.getId() != null) return false;
        if (getTotal() != null ? !getTotal().equals(bill.getTotal()) : bill.getTotal() != null) return false;
        if (getSubtotal() != null ? !getSubtotal().equals(bill.getSubtotal()) : bill.getSubtotal() != null) return false;
        if (getTax() != null ? !getTax().equals(bill.getTax()) : bill.getTax() != null) return false;
        if (getUser() != null ? !getUser().equals(bill.getUser()) : bill.getUser() != null) return false;
        if (getPaymentMethod() != null ? !getPaymentMethod().equals(bill.getPaymentMethod()) : bill.getPaymentMethod() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(bill.getStatus()) : bill.getStatus() != null) return false;
        return getOrders() != null ? getOrders().equals(bill.getOrders()) : bill.getOrders() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTotal() != null ? getTotal().hashCode() : 0);
        result = 31 * result + (getSubtotal() != null ? getSubtotal().hashCode() : 0);
        result = 31 * result + (getTax() != null ? getTax().hashCode() : 0);
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getPaymentMethod() != null ? getPaymentMethod().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getOrders() != null ? getOrders().hashCode() : 0);
        return result;
    }


    
    
}
