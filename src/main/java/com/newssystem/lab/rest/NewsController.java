package com.newssystem.lab.rest;

import com.newssystem.lab.model.Comment;
import com.newssystem.lab.model.News;
import com.newssystem.lab.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lukasz on 2016-03-02.
 */
@RestController
@RequestMapping("/news")
public class NewsController {


    private final NewsService newsService;


    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void save(){
        newsService.save(new News("cos tam nowego","a","c"));
    }


}
