package com.virtualstore.virtualstore.dtos;

import java.util.Date;

public class BillForOrder {

    private Long id;
    private Double total;
    private Double subtotal;
    private Double tax;
    private Date date;

    public BillForOrder() {
    }

    public BillForOrder(Long id, Double total, Double subtotal, Double tax, Date date) {
        this.id = id;
        this.total = total;
        this.subtotal = subtotal;
        this.tax = tax;
        this.date = date;
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

    public BillForOrder setId(Long id) {
        this.id = id;
        return this;
    }

    public BillForOrder setTotal(Double total) {
        this.total = total;
        return this;
    }

    public BillForOrder setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public BillForOrder setTax(Double tax) {
        this.tax = tax;
        return this;
    }

    public BillForOrder setDate(Date date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "BillForOrder{" +
                "id=" + id +
                ", total=" + total +
                ", subtotal=" + subtotal +
                ", tax=" + tax +
                ", date=" + date +
                '}';
    }

    
}
