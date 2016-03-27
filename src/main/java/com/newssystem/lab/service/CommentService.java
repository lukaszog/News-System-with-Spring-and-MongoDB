package com.newssystem.lab.service;

import com.newssystem.lab.model.Comment;
import com.newssystem.lab.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Lukasz on 2016-03-06.
 */
@Service
public class CommentService implements ServiceInterface<Comment>,CustomCommentInterface{

    public CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getObj() {
        List<Comment> commentList = commentRepository.findAll();
        return convertToDTOs(commentList);
    }

    @Override
    public Comment create(Comment obj) {
        return commentRepository.save(obj);
    }

    @Override
    public Comment delete(String id) {
        return null;
    }

    @Override
    public Comment findById(String id) {
        return null;
    }

    @Override
    public Comment update(Comment obj) {
        return null;
    }

    public List<Comment> findByNewsId(String id) {
        List<Comment> commentList = commentRepository.findByNewsId(id);
        return convertToDTOs(commentList);
    }

    private List<Comment> convertToDTOs(List<Comment> models){
        return models.stream().map(this::convertToDTO)
                .collect(toList());
    }

    private Comment convertToDTO(Comment model){

        Comment dto = new Comment();
        dto.setId(model.getId());
        dto.setComment(model.getComment());
        dto.setNewsId(model.getNewsId());
        dto.setData(model.getData());
        dto.setAuthor(model.getAuthor());
        return dto;
    }

}
