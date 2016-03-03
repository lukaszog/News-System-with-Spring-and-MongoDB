package com.newssystem.lab.dao;

import com.newssystem.lab.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Lukasz on 2016-03-02.
 */
@Service("DaoService")
@Qualifier("DaoService")
public class DaoService<T> extends AbstractService<T, Long> {


    @Autowired
    public DaoService(Dao<T, Long> dao) {
        super(dao);
    }
}