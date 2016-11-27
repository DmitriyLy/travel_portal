package com.netcracker.services;

/**
 * Service class, that works with {@link com.netcracker.repositories.impl.BasicRepositoryImpl} and
 * treats {@link com.netcracker.entities.BasicEntity}
 *
 * @author Oveian Egor
 */

public interface BasicService {

    /**
     * Simple service method.
     *
     * @return String field of {@link com.netcracker.entities.BasicEntity}
     */
    public String basicMethod();

}
