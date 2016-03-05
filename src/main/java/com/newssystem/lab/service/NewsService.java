package com.newssystem.lab.service;

import com.newssystem.lab.model.News;
import com.newssystem.lab.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lukasz on 2016-03-03.
 */
@Service
public class NewsService implements NewsServiceInterface{


    private NewsRepository newsRepository;


    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }


    public List<News> getNews(){
        return newsRepository.findAll();
    }

    public News save(News obj){
        return newsRepository.save(obj);
    }

    @Override
    public News delete(String id) {
        return null;
    }

    @Override
    public News findById(String id) {
        return null;
    }

    @Override
    public News update(News obj) {
        return null;
    }

}
