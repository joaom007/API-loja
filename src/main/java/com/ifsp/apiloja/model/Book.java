package com.ifsp.apiloja.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Book implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private int idbook;
    private String author;
    private String title;
    private String isbn;
    private String publisher;
    private String city;
    private String edition;
    private String year;
    private String pages;
    private Double unitaryValue;
    private String description;
    private Category category;


    public Book() {
    }


    public Book(int idbook, String author, String title, String isbn, String publisher, String city, String edition, String year, String pages, Double unitaryValue, String description, Category category) {
        this.idbook = idbook;
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.city = city;
        this.edition = edition;
        this.year = year;
        this.pages = pages;
        this.unitaryValue = unitaryValue;
        this.description = description;
        this.category = category;
    }


    public int getIdbook() {
        return this.idbook;
    }

    public void setIdbook(int idbook) {
        this.idbook = idbook;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEdition() {
        return this.edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPages() {
        return this.pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public Double getUnitaryValue() {
        return this.unitaryValue;
    }

    public void setUnitaryValue(Double unitaryValue) {
        this.unitaryValue = unitaryValue;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
}
