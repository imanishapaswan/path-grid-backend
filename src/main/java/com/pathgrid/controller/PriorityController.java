
package com.pathgrid.controller;

import com.pathgrid.model.PriorityItem;
import com.pathgrid.service.PriorityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class PriorityController {

    private final PriorityService priorityService;

    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @GetMapping("/prioritized")
    public List<PriorityItem> getPrioritizedLocations() {
        return priorityService.getPrioritizedLocations();
    }
}
