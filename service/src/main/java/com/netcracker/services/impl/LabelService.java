package com.netcracker.services.impl;

import com.netcracker.entities.Label;
import com.netcracker.repositories.impl.LabelRepositoryImpl;
import com.netcracker.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dima_2 on 11.12.2016.
 */
@Service
@Transactional
public class LabelService implements IService<Label> {

    @Autowired
    private LabelRepositoryImpl labelRepository;

    @Override
    public void save(Label item) {

    }

    @Override
    public void update(Label item) {

    }

    @Override
    public void delete(Label item) {

    }


}
