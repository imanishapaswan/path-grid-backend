package com.pathgrid;

import com.pathgrid.dsa.CustomPriorityQueue;
import com.pathgrid.model.PriorityItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomPriorityQueueTest {

    @Test
    void dequeueReturnsHighestPriorityFirst() {
        CustomPriorityQueue q = new CustomPriorityQueue();
        q.enqueue(new PriorityItem("low", 1));
        q.enqueue(new PriorityItem("high", 5));
        q.enqueue(new PriorityItem("mid", 3));

        assertEquals("high", q.dequeue().getName());
        assertEquals("mid", q.dequeue().getName());
        assertEquals("low", q.dequeue().getName());
        assertTrue(q.isEmpty());
    }

    @Test
    void dequeueOnEmptyThrows() {
        CustomPriorityQueue q = new CustomPriorityQueue();
        assertThrows(IllegalStateException.class, q::dequeue);
    }
}
