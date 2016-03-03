package com.newssystem.lab.rest;

import com.newssystem.lab.dao.DaoService;
import com.newssystem.lab.model.Comment;
import com.newssystem.lab.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Lukasz on 2016-03-02.
 */
@RestController
@RequestMapping("/news")
public class NewsController {


    private final DaoService<News> newsService;

    private final DaoService<Comment> commentDaoService;


    @Autowired
    public NewsController(DaoService<News> newsService, DaoService<Comment> commentDaoService) {
        this.newsService = newsService;
        this.commentDaoService = commentDaoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void save(){
        newsService.save(new News("elo","a","c"));
        commentDaoService.save(new Comment("iss","we"));
    }
}
