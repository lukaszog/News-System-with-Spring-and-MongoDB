package com.newssystem.lab.service;

import com.newssystem.lab.model.Comment;

/**
 * Created by Lukasz on 2016-03-06.
 */
public interface CustomCommentInterface {

    Comment findByNewsId(int id);
}
