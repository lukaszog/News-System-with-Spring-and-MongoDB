package com.newssystem.lab.rest;

import org.springframework.context.annotation.Bean;

import com.newssystem.lab.model.Comment;
import com.newssystem.lab.model.News;
import com.newssystem.lab.service.CommentService;
import com.newssystem.lab.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Lukasz on 2016-03-02.
 */
@RestController
@RequestMapping("/api/news")
public class AppRESTController {


    private final NewsService newsService;
    private final CommentService commentService;
    private final Map<String, Object> response = new LinkedHashMap<>();

    @Autowired
    public AppRESTController(NewsService newsService, CommentService commentService) {
        this.newsService = newsService;
        this.commentService = commentService;
    }
    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/getNews")
    public @ResponseBody List<News> findAll() {
        return newsService.getObj();
    }

    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/getNewsById/{id}")
    public @ResponseBody News findById(@PathVariable String id){
        System.out.println("To jest id: " + id);
        return newsService.findById(id);
    }

    @CrossOrigin(value = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/getCommetnsByNewsId/{id}")
    public @ResponseBody List<Comment> findByNewsId(@PathVariable String id){
        return commentService.findByNewsId(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveNews")
    public Map<String, Object> create(@Valid @RequestBody News newsEntity, BindingResult bindingResult){


        if (bindingResult.hasErrors()) {
            System.out.println("Error");
            List<FieldError> errors = bindingResult.getFieldErrors();

            response.put("message", "Error");

            for (FieldError error : errors ) {
                System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
                response.put(error.getObjectName(),  error.getDefaultMessage());
            }
        }else {

            newsService.create(newsEntity);

            response.put("message", "News created successfully");
            response.put("news", newsService.create(newsEntity));

        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveComment")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody @Valid Comment commentEntity){
        return commentService.create(commentEntity);
    }
}
