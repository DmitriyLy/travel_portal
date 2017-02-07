package com.netcracker.scheduler;

import com.netcracker.entities.Tag;
import com.netcracker.services.TagService;
import com.netcracker.services.impl.ConfigurationServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.List;

/**
 * Created by Yuksi on 07.02.2017.
 */
@Component
public class WriteToFile {
    @Autowired
    private ConfigurationServiceImpl configurationService;
    @Autowired
    private TagService tagService;

    private final static Logger LOGGER = LogManager.getLogger(WriteToFile.class.getName());

    private String filename; // "/var/www/resources/tags.json";

    @Scheduled(cron = "*/5 * * * *")
    public void savePopularTags() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filename);
            List<Tag> tags = tagService.getPopularTags();

            fileWriter.write("[");

            for (int i = 0; i < tags.size(); i++) {
                fileWriter.write("\"" + tags.get(i).getName() + "\"");
                if (i < tags.size()-1) {
                    fileWriter.write(",");
                }
            }

            fileWriter.write("]");

        } catch (IOException e) {
            LOGGER.warn("Could not create or read file = " + filename);
        }
    }

    @PostConstruct
    private void initFieName() {
        filename = configurationService.getOptionValueByKey("tags");
    }
}
