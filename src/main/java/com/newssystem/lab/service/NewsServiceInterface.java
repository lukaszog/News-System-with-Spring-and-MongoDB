package com.newssystem.lab.service;

import com.newssystem.lab.model.News;

import java.util.List;

/**
 * Created by Lukasz on 2016-03-03.
 */
public interface NewsServiceInterface {

    List<News> getNews();
    News save(News obj);
    News delete(String id);
    News findById(String id);
    News update(News obj);
}
