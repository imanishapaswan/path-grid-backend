
package com.pathgrid.service;

import com.pathgrid.dsa.BFS;
import com.pathgrid.dsa.Graph;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    private final GraphService graphService;
    private final BFS bfs;

    // Get the graph service and create the BFS algorithm.
    public RouteService(GraphService graphService) {
        this.graphService = graphService;
        this.bfs = new BFS();
    }

    // Find a route between two campus locations.
    public BFS.Result findRoute(String from, String to) {

        Graph graph = graphService.getGraph();

        return bfs.findPath(graph, from, to);
    }
}
