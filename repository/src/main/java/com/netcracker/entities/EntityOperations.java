package com.netcracker.entities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima_2 on 19.12.2016.
 */
public class EntityOperations {

    private final static Logger LOGGER = LogManager.getLogger(EntityOperations.class.getName());

    public static String getEntityName(Object entity) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = entity.getClass().getMethods();

        for (Method item : methods) {
            if (item.getName().equals("getName")) {
                return (String) item.invoke(entity, null);
            }
        }

        return null;
    }

    public static List<String> getEntityNameList(List list) {

        List<String> result = new ArrayList<>();

        for (Object item : list) {
            String entityName = null;
            try {
                entityName = getEntityName(item);
            } catch (IllegalAccessException | InvocationTargetException e ) {
                LOGGER.warn("Cannot get entity name. EntityOperations.getEntityNameList " + e.getMessage());
            }
            if (entityName != null) {
                result.add(entityName);
            }
        }

        return result;
    }
}
