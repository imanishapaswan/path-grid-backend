
package com.pathgrid.model;

import java.util.List;

public class Location {

    private String name;
    private List<String> neighbours;

    public Location() {
    }

    public Location(String name, List<String> neighbours) {
        this.name = name;
        this.neighbours = neighbours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<String> neighbours) {
        this.neighbours = neighbours;
    }
}
