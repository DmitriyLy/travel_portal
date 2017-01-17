package com.netcracker.services.impl;

import com.netcracker.dto.LabelDtoNew;
import com.netcracker.dto.LabelDtoUpdate;
import com.netcracker.entities.Label;
import com.netcracker.repositories.impl.LabelRepositoryImpl;
import com.netcracker.services.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author logariett.
 */
@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelRepositoryImpl labelRepository;


    @Override
    public long getNewLabelId() {
        return labelRepository.getNewLabelId();
    }

    @Override
    public Label add(LabelDtoNew labelDto) {
        return null;
    }

    @Override
    public Label getById(long id) {
        return null;
    }

    @Override
    public Label update(LabelDtoUpdate labelDto) {
        return null;
    }

    @Override
    public void delete(Label label) {

    }
}
