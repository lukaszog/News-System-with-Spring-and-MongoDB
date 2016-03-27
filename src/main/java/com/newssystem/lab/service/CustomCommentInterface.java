package com.newssystem.lab.service;

import com.newssystem.lab.model.Comment;

import java.util.List;

/**
 * Created by Lukasz on 2016-03-06.
 */
public interface CustomCommentInterface {

    List<Comment> findByNewsId(String id);
}
