package com.netcracker.services.impl;

import com.google.common.hash.Hashing;
import com.netcracker.entities.Attachment;
import com.netcracker.repositories.impl.AttachmentRepositoryImpl;
import com.netcracker.services.AttachmentService;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.impl.AttachmentByNameAndLabelId;
import com.netcracker.specifications.impl.AttachmentsCountByLabel;
import com.netcracker.specifications.impl.AttachmentsInLabelSpecification;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dima_2 on 18.01.2017.
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {
    private final static Logger LOGGER = LogManager.getLogger(AttachmentServiceImpl.class.getName());

    private static final String ROOT_PATH = "/var/www/resources/uploaded-images/";
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
        File uploadRootDir = new File(ROOT_PATH);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        StringBuilder filePath = new StringBuilder();
        StringBuilder fileName = new StringBuilder();
        String message = attach.getOriginalFilename() + LocalDateTime.now();

        fileName.append(Hashing.sha256()
                .hashString(message, StandardCharsets.UTF_8)
                .toString()
                .substring(0, 10))
                .append(".jpg");

        filePath.append(uploadRootDir.getAbsolutePath())
                .append(File.separator)
                .append(fileName);

        File serverFile = new File(filePath.toString());
        BufferedImage originalImage = ImageIO.read(attach.getInputStream());
        ImageIO.write(originalImage, "jpg", serverFile);
        setPermissions(serverFile);

        doCompression(filePath, originalImage);
        return fileName.toString();
    }

    private void setPermissions(File file) {
        file.setExecutable(true, false);
        file.setReadable(true, false);
        file.setWritable(true, false);
    }

    @Override
    public Attachment getAttachmentByLabelAndName(Long labelId, String name) {
        SqlSpecification specification = new AttachmentByNameAndLabelId(name, labelId);
        List<Attachment> queryResult = repository.query(specification);
        if (queryResult.size() == 0) {
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
        compFilePath.insert(compFilePath.lastIndexOf("."), "_40x40");
        File compressedFile = new File(compFilePath.toString());
        ImageIO.write(resizedImage, "jpg", compressedFile);
        setPermissions(compressedFile);
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

    @Override
    public void removeAttachment(Attachment attachment) {
        File attachmentFile = new File(ROOT_PATH+attachment.getName());
        attachmentFile.delete();
        File compressFile = new File(ROOT_PATH+attachment.getName().replace(".","_40x40."));
        compressFile.delete();
    }

}
