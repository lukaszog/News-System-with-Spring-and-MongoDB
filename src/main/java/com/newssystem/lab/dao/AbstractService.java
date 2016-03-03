package com.newssystem.lab.dao;

import com.newssystem.lab.model.News;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by Lukasz on 2016-03-02.
 */
public abstract class AbstractService<T, ID extends Serializable> implements
        Service<T, ID> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected Dao<T, ID> dao;

    public AbstractService(Dao<T, ID> dao) {
        this.dao = dao;
    }

    @Override
    public T save(T entity) {
        this.logger.debug("Create a new {} with information: {}", entity.getClass(),
                entity.toString());
        return this.dao.save(entity);
    }

}

