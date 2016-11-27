package com.netcracker.repositories;

import com.netcracker.entities.BasicEntity;

/**
 * Simple repository class that describes how to interact with database.
 *
 * @author Oveian Egor
 */

public interface BasicRepository {

    /**
     * Simple repository method.
     *
     * @return {@link com.netcracker.entities.BasicEntity}
     */
    public BasicEntity getBasicEntity();

}
