
package com.pathgrid.controller;

import com.pathgrid.dsa.BFS;
import com.pathgrid.model.RouteRequest;
import com.pathgrid.model.VisualizerResponse;
import com.pathgrid.service.RouteService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visualizer")
public class VisualizerController {

    private final RouteService routeService;

    public VisualizerController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/bfs")
    public ResponseEntity<VisualizerResponse> visualizeBfs(
            @RequestBody RouteRequest request) {

        try {
            BFS.Result result = routeService.findRoute(
                    request.getFrom(),
                    request.getTo()
            );

            String message = result.getPath().isEmpty()
                    ? "No route found"
                    : "Route found successfully";

            VisualizerResponse response = new VisualizerResponse(
                    request.getFrom(),
                    request.getTo(),
                    result.getPath(),
                    result.getSteps(),
                    result.getNodesVisited(),
                    result.getPathLength(),
                    "BFS",
                    message
            );

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException ex) {

            VisualizerResponse response = new VisualizerResponse(
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
