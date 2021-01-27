package com.ifsp.apiloja.model;

import java.io.Serializable;

public class Category implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private int idCategory;
    private String category;

    public Category() {

    }

    public Category(int idCategory, String category) {
        this.idCategory = idCategory;
        this.category = category;
    }

    public int getIdCategory() {
        return this.idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
