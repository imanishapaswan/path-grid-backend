
package com.pathgrid.controller;

import com.pathgrid.dsa.BFS;
import com.pathgrid.model.RouteRequest;
import com.pathgrid.model.RouteResponse;
import com.pathgrid.service.RouteService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/find")
    public ResponseEntity<RouteResponse> findRoute(
            @RequestBody RouteRequest request) {

        try {
            BFS.Result result = routeService.findRoute(
                    request.getFrom(),
                    request.getTo()
            );

            String message = result.getPath().isEmpty()
                    ? "No route found"
                    : "Route found successfully";

            RouteResponse response = new RouteResponse(
                    request.getFrom(),
                    request.getTo(),
                    result.getPath(),
                    result.getVisited(),
                    result.getNodesVisited(),
                    result.getPathLength(),
                    "BFS",
                    message
            );

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException ex) {

            RouteResponse response = new RouteResponse(
                    request.getFrom(),
                    request.getTo(),
                    List.of(),
                    List.of(),
                    0,
                    0,
                    "BFS",
                    ex.getMessage()
            );

            return ResponseEntity.badRequest().body(response);
        }
    }
}
