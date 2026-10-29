
package com.pathgrid.dsa;

import com.pathgrid.model.PriorityItem;

import java.util.ArrayList;
import java.util.List;

public class CustomPriorityQueue {

    private final List<PriorityItem> items = new ArrayList<>();

    public void enqueue(PriorityItem item) {
        items.add(item);
    }

    public PriorityItem dequeue() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }

        int highestIndex = 0;

        for (int i = 1; i < items.size(); i++) {
            if (items.get(i).getPriority()
                    > items.get(highestIndex).getPriority()) {
                highestIndex = i;
            }
        }

        return items.remove(highestIndex);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }
}
