package com.newssystem.lab.dao;

import com.newssystem.lab.model.News;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Lukasz on 2016-03-02.
 */

public interface Service<T, ID extends Serializable> {

     T save(T entity);

}
