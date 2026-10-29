
package com.pathgrid.controller;

import com.pathgrid.model.Location;
import com.pathgrid.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<String> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getLocationDetails(
            @PathVariable String name) {

        try {
            Map<String, Object> details =
                    locationService.getLocationDetails(name);

            return ResponseEntity.ok(
                    new Location(
                            (String) details.get("name"),
                            (List<String>) details.get("neighbours")
                    )
            );

        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest()
                    .body(Map.of("message", ex.getMessage()));
        }
    }
}
