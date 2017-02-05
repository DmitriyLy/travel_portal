package com.netcracker.specifications.utils;

import com.netcracker.entities.Category;
import com.netcracker.entities.Label;
import com.netcracker.entities.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logariett.
 */
public final class SpecificationUtils {

    public static String convertNumberArrayToString(List numbers) {
        if (numbers == null)
            return null;

        StringBuilder sb = new StringBuilder();
        numbers.stream()
                .filter(number -> number != null)
                .forEach(number -> sb.append(number).append(", "));

        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public static String extractIdsAsString(List items) {
        if (items == null)
            return null;

        List<Long> ids = new ArrayList<>(items.size());

        /* this piece of garbage assumes that list consists of the same-class-elements */
        /* no more mr. garbage */

        /* this piece of garbage doesn't */
        for (Object item : items) {
            if(item != null) {
                switch (item.getClass().getSimpleName()) {
                    case "Label":
                        ids.add(((Label) item).getId());
                        break;
                    case "Tag":
                        ids.add(((Tag) item).getId());
                        break;
                    case "Category":
                        ids.add(((Category) item).getId());
                        break;
                }
            }
        }

        return convertNumberArrayToString(ids);
    }
}
