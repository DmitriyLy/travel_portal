package com.netcracker.repositories;

import com.netcracker.entities.Label;
import com.netcracker.entities.Tag;

/**
 * @author logariett.
 */
public interface TagRepository extends IRepository<Tag> {

    void bindLabelAndTag(Label label, Tag tag);
    void unbindLabelAndTag(Label label, Tag tag);

}
