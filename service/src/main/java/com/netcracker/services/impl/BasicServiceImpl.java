package com.netcracker.services.impl;

import com.netcracker.repositories.impl.BasicRepositoryImpl;
import com.netcracker.services.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicServiceImpl implements BasicService {

    @Autowired
    BasicRepositoryImpl basicRepository;

    @Override
    public String basicMethod() {
        return basicRepository.getBasicEntity().getBasicField();
    }
}
