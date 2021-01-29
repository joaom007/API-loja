package com.ifsp.apiloja.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem  implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private OrderItemPK id;
    
    private Integer quantity;
    private Double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Book book, Integer quantity, Double price) {
        super();
        id.setOrder(order);
        id.setBook(book);
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Book getBook() {
        return id.getBook();
    }

    public void setBook(Book book) {
        id.setBook(book);
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderItem)) {
            return false;
        }
        OrderItem oderItem = (OrderItem) o;
        return Objects.equals(id, oderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    
}
