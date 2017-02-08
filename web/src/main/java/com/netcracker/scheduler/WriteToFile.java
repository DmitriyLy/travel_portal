package com.netcracker.scheduler;

import com.netcracker.entities.Tag;
import com.netcracker.services.TagService;
import com.netcracker.services.impl.ConfigurationServiceImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

    private String filename;

    @Scheduled(cron = "0 0 */2 * * *")
    public void savePopularTags() {
        initFileName();
        File file = new File(filename);
        setAllPermissions(file);

        try {
            FileWriter fileWriter = new FileWriter(file);
            List<Tag> tags = tagService.getPopularTags();

            fileWriter.write("[");

            for (int i = 0; i < tags.size(); i++) {
                fileWriter.write("\"" + tags.get(i).getName() + "\"");
                if (i < tags.size()-1) {
                    fileWriter.write(",");
                }
            }

            fileWriter.write("]");

            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            LOGGER.warn("Could not create or read file = " + filename);
        }
    }

    private void setAllPermissions(File file) {
        file.setReadable(true, false);
        file.setWritable(true, false);
        file.setExecutable(true, false);
    }

    private void initFileName() {
        filename = configurationService.getOptionValueByKey("tags");
    }
}
