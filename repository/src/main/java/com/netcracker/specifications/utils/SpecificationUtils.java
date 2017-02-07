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

        List<Long> ids = extractIds(items);
        return convertNumberArrayToString(ids);
    }

    public static List<Long> extractIds(List items) {
        if (items == null)
            return null;

        List<Long> ids = new ArrayList<>(items.size());

        /* this piece of garbage assumes that list consists of the same-class-elements */
        /* no more mr. garbage */

        /* this piece of garbage doesn't */
        for (Object item : items) {
            if (item != null) {
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
        return ids;
    }

    public static String constructQueryLabelGetterByTagsOrCategories(String entityType, List<Long> ids, String labelIds) {
        String entityTypeSingle = "";
        String entityTypePlural = "";
        String entityIdAsForeignKey = "";
        switch (entityType) {
            case "tag":
                entityTypeSingle = "TAG";
                entityTypePlural = "TAGS";
                entityIdAsForeignKey = "TAG_ID";
                break;
            case "category":
                entityTypeSingle = "CATEGORY";
                entityTypePlural = "CATEGORIES";
                entityIdAsForeignKey = "CATEGORY_ID";
                break;
            default:
                return "";
        }

        StringBuilder sb = new StringBuilder("WITH TAB_REQUEST AS ( ");

        int size = ids.size();
        for (int index = 0; index < size; index++) {
            sb.append(singleTagOrCategoryLabelGetterTemplate(ids.get(index), index, size,
                    entityTypeSingle, entityTypePlural, entityIdAsForeignKey, labelIds));
            sb.append(" UNION ALL ");
        }
        // remove excess " UNION ALL "
        sb.delete(sb.length() - 11, sb.length());

        sb.append(" ), TAB_LABELS AS ( SELECT LABEL_ID, ");

        for (int index = 0; index < size; index++) {
            sb.append("SUM(").append(entityTypeSingle).append(index + 1);
            sb.append(") AS ").append(entityTypeSingle).append(index + 1).append("_SUM, ");
        }
        // remove excess ","
        sb.deleteCharAt(sb.length() - 2);

        sb.append("FROM TAB_REQUEST GROUP BY LABEL_ID HAVING ");

        for (int index = 0; index < size; index++)
            sb.append("SUM(").append(entityTypeSingle).append(index+1).append(") > 0 AND ");
        // remove excess "AND"
        sb.delete(sb.length() - 5, sb.length());

        sb.append(" ) ");
        sb.append("SELECT * FROM LABELS L, TAB_LABELS  WHERE L.ID = TAB_LABELS.LABEL_ID");

        return sb.toString();
    }

    private static String singleTagOrCategoryLabelGetterTemplate(long itemId,
                                                                int index,
                                                                int size,
                                                                String entityTypeSingle,
                                                                String entityTypePlural,
                                                                String entityIdAsForeignKey) {
        StringBuilder sb = new StringBuilder("SELECT LABEL_ID, ");

        for (int i = 0; i < index; i++)
            sb.append("0 AS ").append(entityTypeSingle).append(i + 1).append(", ");

        sb.append(entityIdAsForeignKey).append(" AS ").append(entityTypeSingle).append(index+1).append(", ");

        for (int i = index + 1; i < size; i++)
            sb.append("0 AS ").append(entityTypeSingle).append(i + 1).append(", ");

        // remove spare ","
        sb.deleteCharAt(sb.length() - 2);

        sb.append("FROM ").append(entityTypePlural).append("_LABELS ");
        sb.append("WHERE ").append(entityIdAsForeignKey).append(" = ").append(itemId);

        return sb.toString();
    }

    private static String singleTagOrCategoryLabelGetterTemplate(long itemId,
                                                                 int index,
                                                                 int size,
                                                                 String entityTypeSingle,
                                                                 String entityTypePlural,
                                                                 String entityIdAsForeignKey,
                                                                 String labelIds) {
        String base = singleTagOrCategoryLabelGetterTemplate(itemId, index, size,
                entityTypeSingle, entityTypePlural, entityIdAsForeignKey);
        if (labelIds == null)
            return base;

        /*StringBuilder sb = new StringBuilder(base);
        sb.append(" AND LABEL_ID IN (").append(labelIds).append(")");*/
        return base + " AND LABEL_ID IN (" + labelIds + ")";
    }
}
