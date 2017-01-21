package com.netcracker.services;

import com.netcracker.entities.Label;
import com.netcracker.entities.Tag;

import java.util.List;

/**
 * @author logariett.
 */
public interface TagService {

    Tag add(String tagName);
    Tag getOrAdd(String tagName);

    Tag getById(long id);
    Tag getByName(String tagName);
    List<Tag> getTagsByLabel(long labelId);
    List<Tag> getAll();

    void delete(Tag tag);
    boolean deleteTagIfUnused(Tag tag);

    void manageTags(Label label, List<String> updatedTags);
    void bindLabelAndTag(Label label, Tag tag);
    void unbindLabelAndTag(Label label, Tag tag);
}
