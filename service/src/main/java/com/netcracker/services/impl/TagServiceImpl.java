package com.netcracker.services.impl;

import com.netcracker.entities.Label;
import com.netcracker.entities.Tag;
import com.netcracker.repositories.impl.TagRepositoryImpl;
import com.netcracker.services.TagService;
import com.netcracker.specifications.SqlSpecification;
import com.netcracker.specifications.impl.LabelTagsSpecification;
import com.netcracker.specifications.impl.TagByName;
import com.netcracker.specifications.impl.TagsAll;
import com.netcracker.specifications.impl.TagsUsageCount;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author logariett.
 */
@Service
public class TagServiceImpl implements TagService {
    private final static Logger LOGGER = LogManager.getLogger(TagServiceImpl.class.getName());

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TagRepositoryImpl tagRepository;


    @Override
    public Tag add(String tagName) {
        Tag tag = new Tag();
        tag.setName(tagName);
        return tagRepository.add(tag);
    }

    @Override
    public Tag getOrAdd(String tagName) {

        Tag tag = getByName(tagName);
        if (tag == null)
            return add(tagName);
        else
            return tag;
    }

    @Override
    public Tag getById(long id) {
        return tagRepository.getById(id);
    }

    @Override
    public Tag getByName(String tagName) {
        List<Tag> tags = tagRepository.query(new TagByName(tagName));

        if (tags.size() == 0)
            return null;
        else if (tags.size() == 1)
            return tags.get(0);
        else {
            //throw smth
        }

        return null;
    }

    @Override
    public List<Tag> getTagsByLabel(long labelId) {
        return tagRepository.query(new LabelTagsSpecification(labelId));
    }

    @Override
    public List<Tag> getAll() {
        return tagRepository.query(new TagsAll());
    }

    @Override
    public void delete(Tag tag) {
        tagRepository.remove(tag);
    }

    @Override
    public boolean deleteTagIfUnused(Tag tag) {
        long tagUsageCount = getTagUsageCount(tag);
        if (tagUsageCount == 0) {
            delete(tag);
            return true;
        }
        return false;
    }

    public void manageTags(Label label, List<String> updatedTags) {
        if (label == null) {
            //throw smth
            return;
        }

        List<Tag> labelTags = getTagsByLabel(label.getId());

        if (labelTags.size() == 0) {
            for (String tagName : updatedTags) {
                addTagByNameToLabel(label, tagName);
            }

        } else if (updatedTags == null || updatedTags.size() == 0) {
            for (Tag tag : labelTags) {
                unbindLabelAndTag(label, tag);
                deleteTagIfUnused(tag);
            }

        } else {
            for (Tag tag : labelTags)
                if(updatedTags.contains(tag.getName())) {
                    updatedTags.remove(tag.getName());
                } else {
                    unbindLabelAndTag(label, tag);
                    deleteTagIfUnused(tag);
                }

            for (String tagName : updatedTags) {
                addTagByNameToLabel(label, tagName);
            }
        }
    }

    @Override
    public void bindLabelAndTag(Label label, Tag tag) {
        tagRepository.bindLabelAndTag(label, tag);
    }

    @Override
    public void unbindLabelAndTag(Label label, Tag tag) {
        tagRepository.unbindLabelAndTag(label, tag);
    }

    private long getTagUsageCount(Tag tag) {
        SqlSpecification specification = new TagsUsageCount(tag.getId());
        return jdbcTemplate.queryForObject(specification.toSqlQuery(), Long.class);
    }

    private void addTagByNameToLabel(Label label, String tagName) {
        Tag tag = getOrAdd(tagName);
        bindLabelAndTag(label, tag);
    }
}
