package com.netcracker.controllers;

import com.netcracker.entities.Tag;
import com.netcracker.services.LabelService;
import com.netcracker.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logariett.
 */
@RestController
public class RenameMeController {
    @Autowired
    private LabelService labelService;
    @Autowired
    private TagService tagService;

    @GetMapping("/test")
    public List<Object> test() {
        List<Object> response = new ArrayList();

        return response;
    }

    /**
     * Method returns id, reserved for new label
     *
     * @return id.
     */
    @GetMapping("/reserveLabelId")
    public long reserveLabelId() {
        return labelService.getNewLabelId();
    }
}
