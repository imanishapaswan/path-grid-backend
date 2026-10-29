
package com.pathgrid.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BFS {

    public static class Result {
        private final List<String> path;
        private final List<String> visited;

        public Result(List<String> path, List<String> visited) {
            this.path = path;
            this.visited = visited;
        }

        public List<String> getPath() {
            return path;
        }

        public List<String> getVisited() {
            return visited;
        }

        public int getNodesVisited() {
            return visited.size();
        }

        public int getPathLength() {
            return path.isEmpty() ? 0 : path.size() - 1;
        }
    }

    public Result findPath(Graph graph, String source, String destination) {

        List<String> visited = new ArrayList<>();
        List<String> path = new ArrayList<>();

        // Check whether both locations exist.
        if (!graph.getLocations().contains(source)
                || !graph.getLocations().contains(destination)) {
            throw new IllegalArgumentException("Invalid campus location");
        }

        // Queue stores locations waiting to be explored.
        CustomQueue<String> queue = new CustomQueue<>();

        // Track explored locations and their parents.
        Set<String> discovered = new HashSet<>();
        Map<String, String> parent = new HashMap<>();

        queue.enqueue(source);
        discovered.add(source);

        while (!queue.isEmpty()) {

            String current = queue.dequeue();
            visited.add(current);

            // Stop when the destination is reached.
            if (current.equals(destination)) {
                break;
            }

            // Explore all directly connected locations.
            for (String neighbour : graph.getNeighbours(current)) {

                if (!discovered.contains(neighbour)) {
                    discovered.add(neighbour);
                    parent.put(neighbour, current);
                    queue.enqueue(neighbour);
                }
            }
        }

        // If destination was never discovered, no route exists.
        if (!discovered.contains(destination)) {
            return new Result(path, visited);
        }

        // Reconstruct the path by following parent references.
        String current = destination;

        while (current != null) {
            path.add(current);

            if (current.equals(source)) {
                break;
            }

            current = parent.get(current);
        }

        Collections.reverse(path);

        return new Result(path, visited);
    }
}
