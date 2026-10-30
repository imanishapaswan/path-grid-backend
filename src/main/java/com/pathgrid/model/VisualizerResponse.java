
package com.pathgrid.model;

import java.util.List;

public class VisualizerResponse {

    private String from;
    private String to;
    private List<String> path;
    private List<BFSStep> steps;
    private int nodesVisited;
    private int pathLength;
    private String algorithm;
    private String message;

    public VisualizerResponse() {
    }

    public VisualizerResponse(
            String from,
            String to,
            List<String> path,
            List<BFSStep> steps,
            int nodesVisited,
            int pathLength,
            String algorithm,
            String message) {

        this.from = from;
        this.to = to;
        this.path = path;
        this.steps = steps;
        this.nodesVisited = nodesVisited;
        this.pathLength = pathLength;
        this.algorithm = algorithm;
        this.message = message;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public List<BFSStep> getSteps() {
        return steps;
    }

    public void setSteps(List<BFSStep> steps) {
        this.steps = steps;
    }

    public int getNodesVisited() {
        return nodesVisited;
    }

    public void setNodesVisited(int nodesVisited) {
        this.nodesVisited = nodesVisited;
    }

    public int getPathLength() {
        return pathLength;
    }

    public void setPathLength(int pathLength) {
        this.pathLength = pathLength;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
