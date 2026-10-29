
package com.pathgrid.model;

public class PriorityItem {

    private String name;
    private int priority;

    public PriorityItem() {
    }

    public PriorityItem(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
