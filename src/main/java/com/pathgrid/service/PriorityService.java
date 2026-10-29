
package com.pathgrid.service;

import com.pathgrid.dsa.CustomPriorityQueue;
import com.pathgrid.dsa.Graph;
import com.pathgrid.model.PriorityItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriorityService {

    private final GraphService graphService;

    public PriorityService(GraphService graphService) {
        this.graphService = graphService;
    }

    public List<PriorityItem> getPrioritizedLocations() {
        Graph graph = graphService.getGraph();
        CustomPriorityQueue queue = new CustomPriorityQueue();

        for (String location : graph.getLocations()) {
            int priority = graph.getNeighbours(location).size();

            queue.enqueue(new PriorityItem(location, priority));
        }

        List<PriorityItem> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            result.add(queue.dequeue());
        }

        return result;
    }
}
