package com.newssystem.lab.service;

import com.newssystem.lab.model.Comment;
import com.newssystem.lab.model.News;
import com.newssystem.lab.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lukasz on 2016-03-06.
 */
@Service
public class CommentService implements ServiceInterface<Comment>{

    public CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getNews() {
        return null;
    }

    @Override
    public News create(Comment obj) {
        return null;
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
    public News update(Comment obj) {
        return null;
    }
}
