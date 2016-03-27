package com.newssystem.lab.service;

import com.newssystem.lab.model.News;
import com.newssystem.lab.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * Created by Lukasz on 2016-03-03.
 */
@Service
public class NewsService implements ServiceInterface<News>{


    private NewsRepository newsRepository;


    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }


    @Override
    public List<News> getObj(){
        List<News> newsEntity = newsRepository.findAll();
        return convertToDTOs(newsEntity);
    }

    private List<News> convertToDTOs(List<News> models){
        return models.stream().map(this::convertToDTO)
                .collect(toList());
    }

    private News convertToDTO(News model){

        News dto = new News();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setData(model.getData());
        dto.setText(model.getText());
        dto.setAuthor(model.getAuthor());
        return dto;

    }

    public News create(News obj){
        return newsRepository.save(obj);
    }

    @Override
    public News delete(String id) {
        return null;
    }

    @Override
    public News findById(String id) {

        News news = newsRepository.findOne(id);

        return news;
    }

    @Override
    public News update(News obj) {
        return null;
    }

}
