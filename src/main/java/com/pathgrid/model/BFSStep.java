
package com.pathgrid.model;

import java.util.List;

/**
 * One snapshot of the BFS traversal, used by the visualizer so the
 * frontend can animate the queue and visited set step by step.
 */
public class BFSStep {

    private int step;
    private String current;       // node dequeued this step (null on the initial step)
    private List<String> queue;   // queue contents, front -> rear, after this step
    private List<String> visited; // nodes visited so far, in order
    private String description;

    public BFSStep() {
    }

    public BFSStep(
            int step,
            String current,
            List<String> queue,
            List<String> visited,
            String description) {

        this.step = step;
        this.current = current;
        this.queue = queue;
        this.visited = visited;
        this.description = description;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public List<String> getQueue() {
        return queue;
    }

    public void setQueue(List<String> queue) {
        this.queue = queue;
    }

    public List<String> getVisited() {
        return visited;
    }

    public void setVisited(List<String> visited) {
        this.visited = visited;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
