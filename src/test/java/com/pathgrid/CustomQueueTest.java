package com.pathgrid;

import com.pathgrid.dsa.CustomQueue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {

    @Test
    void dequeueFollowsFifoOrder() {
        CustomQueue<String> q = new CustomQueue<>();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");

        assertEquals("a", q.dequeue());
        assertEquals("b", q.dequeue());
        assertEquals("c", q.dequeue());
        assertTrue(q.isEmpty());
    }

    @Test
    void peekReturnsFrontWithoutRemoving() {
        CustomQueue<String> q = new CustomQueue<>();
        q.enqueue("a");
        q.enqueue("b");

        assertEquals("a", q.peek());
        assertEquals(2, q.size());
    }

    @Test
    void toListReturnsFrontToRearOrder() {
        CustomQueue<String> q = new CustomQueue<>();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");

        assertEquals(List.of("a", "b", "c"), q.toList());
    }

    @Test
    void dequeueOnEmptyThrows() {
        CustomQueue<String> q = new CustomQueue<>();
        assertThrows(IllegalStateException.class, q::dequeue);
    }
}
