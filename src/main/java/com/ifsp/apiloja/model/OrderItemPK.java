package com.ifsp.apiloja.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderItemPK implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
     

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof OrderItemPK)) {
            return false;
        }
        OrderItemPK orderItem = (OrderItemPK) o;
        return Objects.equals(order, orderItem.order) && Objects.equals(book, orderItem.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, book);
    }

}
