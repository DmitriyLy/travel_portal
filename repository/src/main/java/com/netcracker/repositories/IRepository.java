package com.netcracker.repositories;

import com.netcracker.specifications.Specification;
import java.util.List;

/**
 * Basic interface for all repositories.
 *
 * @author Yuksi
 */
public interface IRepository<T> {

    /**
     * Method is responsible for entity insertion in table.
     *
     * @param item - entity, described in {@link com.netcracker.entities}.
     * @return an object of type <T>, inserted in table.
     * @exception org.springframework.dao.DataAccessException - unchecked database exception.
     */
    T add(T item);

    /**
     * Method is responsible for entity update in table.
     *
     * @param item - entity, described in {@link com.netcracker.entities}.
     * @return updated object of type <T>.
     * @exception org.springframework.dao.DataAccessException - unchecked database exception.
     */
    T update(T item);

    /**
     * Method is responsible for entity removal from table.
     *
     * @param item - entity, described in {@link com.netcracker.entities}.
     * @return deleted object of type <T>
     * @exception org.springframework.dao.DataAccessException - unchecked database exception.
     */
    T remove(T item);

    /**
     * Method is responsible for searching an entity by id.
     *
     * @param id - entity id.
     * @return an entity of type <T>
     * @exception org.springframework.dao.DataAccessException - unchecked database exception.
     */
    T getById(long id);

    /**
     * Method is responsible for query execution using specification injection
     * from package {@link com.netcracker.specifications}
     *
     * @param specification - for generating specific String query
     * @return List of searching entities
     * @exception org.springframework.dao.DataAccessException - unchecked database exception.
     */
    List<T> query(Specification specification);
}
