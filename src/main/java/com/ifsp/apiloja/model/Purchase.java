package com.ifsp.apiloja.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Purchase implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nameCompany;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant date;
    private Double total;  
    private int installments;

    private String status;

    public Purchase() {
    }

    public Purchase(Long id, String nameCompany, Instant date, Double total, int installments, String status) {
        super();
        this.id = id;
        this.nameCompany = nameCompany;
        this.date = date;
        this.total = total;
        this.installments = installments;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCompany() {
        return this.nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Instant getDate() {
        return this.date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getInstallments() {
        return this.installments;
    }

    public void setInstallments(int installments) {
        this.installments = installments;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) o;
        return Objects.equals(id, purchase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}