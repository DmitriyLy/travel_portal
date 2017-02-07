package com.netcracker.services.impl;

import com.netcracker.entities.Configuration;
import com.netcracker.exception.ConfigurationOptionNotFoundException;
import com.netcracker.repositories.impl.ConfigurationRepositoryImpl;
import com.netcracker.services.ConfigurationService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dima_2 on 05.02.2017.
 */

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    private final static Logger LOGGER = LogManager.getLogger(ConfigurationServiceImpl.class.getName());

    @Autowired
    private ConfigurationRepositoryImpl repository;

    @Override
    public String getOptionValueByKey(String key) {

        List<Configuration> list = repository.getOptionByKey(key);

        if (list.isEmpty()) {
            ConfigurationOptionNotFoundException exception = new ConfigurationOptionNotFoundException("Key: " + key);
            LOGGER.warn("Option with specified key not found." , exception);
            throw exception;
        }

        return list.get(0).getConfigValue();
    }

    @Override
    public String getUploadedImageDir() {
        return getOptionValueByKey("uploaded_images_dir");
    }
}
