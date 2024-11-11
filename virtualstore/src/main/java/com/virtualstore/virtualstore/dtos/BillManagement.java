package com.virtualstore.virtualstore.dtos;

import java.util.Collection;
import java.util.Date;

public class BillManagement {

    private Long id;
    private Double total;
    private Double subtotal;
    private Double tax;
    private Date date;

    PaymentMethodBasicInfo paymentMethod;

    Collection<OrderBasicInfo> orders;

    StatusBasicInfo status;

    ShippingAddressBasicInfo shippingAddress;

    public BillManagement() {
    }

    public BillManagement(Long id, Double total, Double subtotal, Double tax, Date date, PaymentMethodBasicInfo paymentMethod, Collection<OrderBasicInfo> orders, StatusBasicInfo status, ShippingAddressBasicInfo shippingAddress) {
        this.id = id;
        this.total = total;
        this.subtotal = subtotal;
        this.tax = tax;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.orders = orders;
        this.status = status;
        this.shippingAddress = shippingAddress;
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

    public Date getDate() {
        return date;
    }


    public PaymentMethodBasicInfo getPaymentMethod() {
        return paymentMethod;
    }

    public Collection<OrderBasicInfo> getOrders() {
        return orders;
    }

    public ShippingAddressBasicInfo getShippingAddress() {
        return shippingAddress;
    }

    public BillManagement setId(Long id) {
        this.id = id;
        return this;
    }

    public BillManagement setTotal(Double total) {
        this.total = total;
        return this;
    }

    public BillManagement setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public BillManagement setTax(Double tax) {
        this.tax = tax;
        return this;
    }

    public BillManagement setDate(Date date) {
        this.date = date;
        return this;
    }

    public BillManagement setPaymentMethod(PaymentMethodBasicInfo paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public BillManagement setOrders(Collection<OrderBasicInfo> orders) {
        this.orders = orders;
        return this;
    }

    public StatusBasicInfo getStatus() {
        return status;
    }

    public BillManagement setStatus(StatusBasicInfo status) {
        this.status = status;
        return this;
    }

    public BillManagement setShippingAddress(ShippingAddressBasicInfo shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    @Override
    public String toString() {
        return "BillBasicInfo{" +
                "id=" + id +
                ", total=" + total +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", date=" + date +
                ", paymentMethod=" + paymentMethod +
                ", orders=" + orders +
                ", status=" + status +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
    
}
