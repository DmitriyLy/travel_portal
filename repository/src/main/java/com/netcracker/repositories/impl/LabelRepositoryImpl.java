package com.netcracker.repositories.impl;

import com.netcracker.entities.Label;
import com.netcracker.repositories.IRepository;
import com.netcracker.specifications.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dima_2 on 30.11.2016.
 */
@Repository
public class LabelRepositoryImpl implements IRepository<Label> {
    @Override
    public void add(Label item) {

    }

    @Override
    public void update(Label item) {

    }

    @Override
    public void remove(Label item) {

    }

    @Override
    public Label getById(long id) {
        return null;
    }

    @Override
    public List<Label> query(Specification specification) {
        return null;
    }
}
