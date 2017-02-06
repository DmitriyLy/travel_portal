package com.netcracker.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dima_2 on 06.02.2017.
 */
public class AddressPartsDto {

    private List<String> phrases = new ArrayList<>();

    public List<String> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<String> phrases) {

        this.phrases.clear();

        for (String item : phrases) {
            this.phrases.add(item);
        }
    }
}
