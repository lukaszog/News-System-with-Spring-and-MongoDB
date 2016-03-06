package com.newssystem.lab.rest;

import com.newssystem.lab.model.Comment;
import com.newssystem.lab.model.News;
import com.newssystem.lab.service.CommentService;
import com.newssystem.lab.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Lukasz on 2016-03-02.
 */
@RestController
@RequestMapping("/api/news")
public class AppRESTController {


    private final NewsService newsService;
    private final CommentService commentService;


    public AppRESTController(NewsService newsService, CommentService commentService) {
        this.newsService = newsService;
        this.commentService = commentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<News> findAll(){
        return newsService.getNews();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.CREATED)
    public News create(@RequestBody News newsEntity){
        return newsService.create(newsEntity);
    }




}
