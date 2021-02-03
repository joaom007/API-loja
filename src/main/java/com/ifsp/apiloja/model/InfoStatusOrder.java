package com.ifsp.apiloja.model;

import java.time.Instant;

public class InfoStatusOrder {

    private String nameCompany;
    private Instant date;
    private String status;

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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
