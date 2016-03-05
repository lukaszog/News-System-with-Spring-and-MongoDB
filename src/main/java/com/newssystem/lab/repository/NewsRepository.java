package com.newssystem.lab.repository;

import com.newssystem.lab.model.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Lukasz on 2016-03-02.
*/
@Repository
public interface NewsRepository  extends MongoRepository<News, String>  {

}
