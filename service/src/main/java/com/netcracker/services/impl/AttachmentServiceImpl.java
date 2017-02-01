package com.netcracker.services.impl;

import com.netcracker.dto.AttachmentDtoInfo;
import com.netcracker.entities.Attachment;
import com.netcracker.repositories.impl.AttachmentRepositoryImpl;
import com.netcracker.services.AttachmentService;
import com.netcracker.services.Converter;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.impl.AttachmentByNameAndLabelId;
import com.netcracker.specifications.impl.AttachmentsCountByLabel;
import com.netcracker.specifications.impl.AttachmentsInLabelSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima_2 on 18.01.2017.
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {
    private final static Logger LOGGER = LogManager.getLogger(AttachmentServiceImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private AttachmentRepositoryImpl repository;



    @Override
    public Attachment addAttachment(long labelId, String userId, String name) {
        Attachment attachment = new Attachment();
        attachment.setLabelId(labelId);
        attachment.setUserId(userId);
        attachment.setName(name);
        return repository.add(attachment);
    }

    @Override
    public String saveAttachment(Long labelId, MultipartFile attach) throws IOException {
        String uploadRootPath = "/var/www/resources/uploaded-images/" + labelId;
        File uploadRootDir = new File(uploadRootPath);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        StringBuilder filePath = new StringBuilder();
        StringBuilder fileName = new StringBuilder();
        fileName.append(attach.getOriginalFilename())
                .replace(fileName.lastIndexOf(".")+1,fileName.length(),"jpg");
        filePath.append(uploadRootDir.getAbsolutePath())
                .append(File.separator)
                .append(fileName);

        File serverFile = new File(filePath.toString());
        BufferedImage originalImage = ImageIO.read(attach.getInputStream());
        ImageIO.write(originalImage, "jpg", serverFile);

        doCompression(filePath, originalImage);
        return fileName.toString();
    }

    @Override
    public Attachment getAttachmentByLabelAndName(Long labelId, String name) {
        SqlSpecification specification = new AttachmentByNameAndLabelId(name,labelId);
        List<Attachment> queryResult = repository.query(specification);
        if(queryResult.size()==0) {
            return null;
        }
        return queryResult.get(0);
    }

    private void doCompression(StringBuilder fileName, BufferedImage originalImage) throws IOException {
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

        BufferedImage resizedImage = new BufferedImage(40, 40, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, 40, 40, null);
        g.dispose();

        StringBuilder compFilePath = new StringBuilder(fileName);
        compFilePath.insert(compFilePath.lastIndexOf("."),"_40x40");
        File compressedFile = new File(compFilePath.toString());

        ImageIO.write(resizedImage, "jpg", compressedFile);
    }

    @Override
    public List<Attachment> getAttachmentsByLabel(Long labelId) {

        ArrayList<Attachment> list = new ArrayList<>();

        SqlSpecification specification = new AttachmentsInLabelSpecification(labelId);


        List<Attachment> queryResult = repository.query(specification);

        for (Attachment item : queryResult) {
            if (item != null) {
                list.add(item);
            }
        }

        return list;
    }

    @Override
    public int getAttachmentCountByLabel(long labelId) {
        SqlSpecification specification = new AttachmentsCountByLabel(labelId);
        return jdbcTemplate.queryForObject(specification.toSqlQuery(), Integer.class);
    }

    @Override
    public void deleteAttachment(Attachment attachment) {
        repository.remove(attachment);
    }

    @Override
    public Attachment getAttachmentById(Long id) {
        return repository.getById(id);
    }

}
