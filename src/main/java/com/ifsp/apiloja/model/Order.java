package com.ifsp.apiloja.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date;
    private String paymentForm;
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerOd;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order() {
    }

    public Order(Long id, Instant date, String paymentForm, String status, Customer customerOd) {
        this.id = id;
        this.date = date;
        this.paymentForm = paymentForm;
        this.status = status;
        this.customerOd = customerOd;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return this.date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getPaymentForm() {
        return this.paymentForm;
    }

    public void setPaymentForm(String paymentForm) {
        this.paymentForm = paymentForm;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomerOd() {
        return this.customerOd;
    }

    public void setCustomerOd(Customer customerOd) {
        this.customerOd = customerOd;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
 
}
