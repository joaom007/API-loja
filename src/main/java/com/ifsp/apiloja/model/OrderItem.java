package com.ifsp.apiloja.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderItem implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrderItem;
    private int amount;
    private Book book;
    private Order order;

    public OrderItem() {
    }

    public OrderItem(int idOrderItem, int amount, Book book, Order order) {
        this.idOrderItem = idOrderItem;
        this.amount = amount;
        this.book = book;
        this.order = order;
    }

    public int getIdOrderItem() {
        return this.idOrderItem;
    }

    public void setIdOrderItem(int idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


}
