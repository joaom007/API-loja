package com.ifsp.apiloja.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCustomer;
    private String nameCustomer;
    private String cpf;
    private String rg;
    private String email;
    private String password;
    private String token;
    private String dateBirth;


    public Customer() {
    }

    public Customer(int idCustomer, String nameCustomer, String cpf, String rg, String email, String password, String token, String dateBirth) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.cpf = cpf;
        this.rg = rg;
        this.email = email;
        this.password = password;
        this.token = token;
        this.dateBirth = dateBirth;
    }

    public int getIdCustomer() {
        return this.idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return this.nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return this.rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getDateBirth() {
        return this.dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    
}
