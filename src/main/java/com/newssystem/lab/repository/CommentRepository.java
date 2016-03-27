package com.newssystem.lab.repository;

import com.newssystem.lab.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lukasz on 2016-03-02.
 */
@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    List<Comment> findByNewsId(String id);

}
