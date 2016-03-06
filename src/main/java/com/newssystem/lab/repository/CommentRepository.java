package com.newssystem.lab.repository;

import com.newssystem.lab.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Lukasz on 2016-03-02.
 */

public interface CommentRepository extends MongoRepository<Comment, String> {

}
