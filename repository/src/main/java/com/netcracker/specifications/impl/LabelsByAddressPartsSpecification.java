package com.netcracker.specifications.impl;

import com.netcracker.specifications.SqlSpecification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima_2 on 06.02.2017.
 */
public class LabelsByAddressPartsSpecification implements SqlSpecification {

    private List<String> addressParts;

    public LabelsByAddressPartsSpecification(List<String> addressPartsIncome) {
        this.addressParts = new ArrayList<>();

        for (String item : addressPartsIncome) {
            this.addressParts.add(item);
        }
    }

    @Override
    public String toSqlQuery() {
        return generateQueryText();
    }

    private String generateQueryText() {

        String finalQuery = null;

        String queryPart = "SELECT * FROM LABELS WHERE LOCATION_ID IN (SELECT ID FROM LOCATIONS WHERE #COND_PART#)";
        String conditionPart = "STREET LIKE '%#PART#%'";
        StringBuilder conditionResult = new StringBuilder();

        for (String item : addressParts) {
            if (conditionResult.length() != 0) {
                conditionResult.append(" AND ");
            }
            conditionResult.append(conditionPart.replace("#PART#", item));
        }

        if (conditionResult.length() != 0) {
            finalQuery = queryPart.replace("#COND_PART#", conditionResult.toString());
        }

        return finalQuery;
    }
}
