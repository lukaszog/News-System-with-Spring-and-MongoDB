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
    public String idNews;
    public String comment;
    public String author;
    public String data;


    public Comment(String idNews, String comment) {
        this.idNews = idNews;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdNews() {
        return idNews;
    }

    public void setIdNews(String idNews) {
        this.idNews = idNews;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
