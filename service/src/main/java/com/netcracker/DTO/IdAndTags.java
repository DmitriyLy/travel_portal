package com.netcracker.DTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by blaze159 on 10.01.17.
 */
public class IdAndTags {
    private long id;
    private List<String> tags = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
