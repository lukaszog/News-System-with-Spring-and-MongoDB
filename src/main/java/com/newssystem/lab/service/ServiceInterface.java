package com.newssystem.lab.service;

import com.newssystem.lab.model.News;

import java.util.List;

/**
 * Created by Lukasz on 2016-03-03.
 */
public interface ServiceInterface<T> {

    List<T> getObj();
    T create(T obj);
    T delete(String id);
    T findById(String id);
    T update(T obj);
}
