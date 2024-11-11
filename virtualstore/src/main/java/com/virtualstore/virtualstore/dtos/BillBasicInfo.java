package com.virtualstore.virtualstore.dtos;

import java.util.Collection;
import java.util.Date;


public class BillBasicInfo {

    private Long id;
    private Double total;
    private Double subtotal;
    private Double tax;
    private Date date;

    UserBasicInfo user;

    PaymentMethodBasicInfo paymentMethod;

    Collection<OrderBasicInfo> orders;

    StatusBasicInfo status;

    ShippingAddressBasicInfo shippingAddress;


    public BillBasicInfo() {
    }

    public BillBasicInfo(Long id, Double total, Double subtotal, Double tax, Date date, UserBasicInfo user, PaymentMethodBasicInfo paymentMethod, Collection<OrderBasicInfo> orders, StatusBasicInfo status, ShippingAddressBasicInfo shippingAddress) {
        this.id = id;
        this.total = total;
        this.subtotal = subtotal;
        this.tax = tax;
        this.date = date;
        this.user = user;
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

    public UserBasicInfo getUser() {
        return user;
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

    public BillBasicInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public BillBasicInfo setTotal(Double total) {
        this.total = total;
        return this;
    }

    public BillBasicInfo setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public BillBasicInfo setTax(Double tax) {
        this.tax = tax;
        return this;
    }

    public BillBasicInfo setDate(Date date) {
        this.date = date;
        return this;
    }

    public BillBasicInfo setUser(UserBasicInfo user) {
        this.user = user;
        return this;
    }

    public BillBasicInfo setPaymentMethod(PaymentMethodBasicInfo paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public BillBasicInfo setOrders(Collection<OrderBasicInfo> orders) {
        if(orders != null) {
            this.orders = orders;
            return this;
        }
        return this;
    }

    public StatusBasicInfo getStatus() {
        return status;
    }

    public BillBasicInfo setStatus(StatusBasicInfo status) {
        this.status = status;
        return this;
    }


    public BillBasicInfo setShippingAddress(ShippingAddressBasicInfo shippingAddress) {
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
                ", user=" + user +
                ", paymentMethod=" + paymentMethod +
                ", orders=" + orders +
                ", status=" + status +
                ", shippingAddress=" + shippingAddress +
                '}';
    }

    
}
