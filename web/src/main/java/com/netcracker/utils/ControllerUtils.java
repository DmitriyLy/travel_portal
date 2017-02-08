package com.netcracker.utils;

import com.netcracker.entities.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by KTBFFH on 08.02.2017.
 */
public abstract class ControllerUtils {

    public static User getUserFromContext(){
        return  (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
