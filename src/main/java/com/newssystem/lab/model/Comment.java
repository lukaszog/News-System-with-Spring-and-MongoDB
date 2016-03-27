package com.newssystem.lab.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Lukasz on 2016-03-02.
 */
@Document
public class Comment {

    @Id
    public String id;
    public String newsId;
    public String comment;
    public String author;
    public String data;

    public Comment() {}

    public Comment(String id, String newsId, String comment, String author, String data) {
        this.id = id;
        this.newsId = newsId;
        this.comment = comment;
        this.author = author;
        this.data = data;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
