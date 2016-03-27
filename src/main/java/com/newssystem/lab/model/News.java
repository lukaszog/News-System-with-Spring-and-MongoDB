package com.newssystem.lab.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Lukasz on 2016-02-19.
 */
@Document
public class News {

    @Id
    public String id;
    @NotNull(message = "Pole nie może być puste")
    @Size(min = 1, max = 30, message = "Minimalna wartosc 1, max 30")
    public String title;
    public String text;
    public String data;
    public String author;

    public News() {}

    public News(String title, String text, String data, String author) {
        this.title = title;
        this.text = text;
        this.data = data;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
