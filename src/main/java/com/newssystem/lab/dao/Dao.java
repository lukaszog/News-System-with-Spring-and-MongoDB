package com.newssystem.lab.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Lukasz on 2016-03-02.
 */
@Repository
public interface Dao<T, ID extends Serializable> extends MongoRepository<T, ID>{


}
