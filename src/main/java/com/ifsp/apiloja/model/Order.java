// package com.ifsp.apiloja.model;

// import java.io.Serializable;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

// @Entity
// public class Order implements Serializable{
    
//     private static final long serialVersionUID = 1L;

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int idOrder;
//     private String date;
//     private String paymentForm;
//     private String status;
//     private Customer customer;


//     public Order() {
//     }

//     public Order(int idOrder, String date, String paymentForm, String status, Customer customer) {
//         this.idOrder = idOrder;
//         this.date = date;
//         this.paymentForm = paymentForm;
//         this.status = status;
//         this.customer = customer;
//     }

//     public int getIdOrder() {
//         return this.idOrder;
//     }

//     public void setIdOrder(int idOrder) {
//         this.idOrder = idOrder;
//     }

//     public String getDate() {
//         return this.date;
//     }

//     public void setDate(String date) {
//         this.date = date;
//     }

//     public String getPaymentForm() {
//         return this.paymentForm;
//     }

//     public void setPaymentForm(String paymentForm) {
//         this.paymentForm = paymentForm;
//     }

//     public String getStatus() {
//         return this.status;
//     }

//     public void setStatus(String status) {
//         this.status = status;
//     }

//     public Customer getCustomer() {
//         return this.customer;
//     }

//     public void setCustomer(Customer customer) {
//         this.customer = customer;
//     }

// }
