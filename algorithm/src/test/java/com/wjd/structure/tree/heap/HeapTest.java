package com.wjd.structure.tree.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeapTest {

    @Test
    void testBuild() {
        Integer[] values = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Heap<Integer> heap = new HeapImpl<>(values);
        assertEquals("[null, 7, 5, 6, 4, 2, 1, 3]", heap.toString());
    }

    @Test
    void testRemoveFirst() {
        Integer[] values = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Heap<Integer> heap = new HeapImpl<>(values);
        assertEquals("[null, 7, 5, 6, 4, 2, 1, 3]", heap.toString());

        assertEquals(7, heap.removeFirst());
        assertEquals("[null, 6, 5, 3, 4, 2, 1]", heap.toString());
        assertEquals(6, heap.removeFirst());
        assertEquals("[null, 5, 4, 3, 1, 2]", heap.toString());
        assertEquals(5, heap.removeFirst());
        assertEquals("[null, 4, 2, 3, 1]", heap.toString());
        assertEquals(4, heap.removeFirst());
        assertEquals("[null, 3, 2, 1]", heap.toString());
        assertEquals(3, heap.removeFirst());
        assertEquals("[null, 2, 1]", heap.toString());
        assertEquals(2, heap.removeFirst());
        assertEquals("[null, 1]", heap.toString());
    }

    @Test
    void testInsert() {
        Heap<Integer> heap = new HeapImpl<>(20);
        Integer[] values = new Integer[]{7, 5, 6, 4, 2, 1, 3};
        for (int val : values) {
            heap.insert(val);
        }
        assertEquals("[null, 7, 5, 6, 4, 2, 1, 3]", heap.toString());

        heap.insert(12);
        assertEquals("[null, 12, 7, 6, 5, 2, 1, 3, 4]", heap.toString());
        heap.insert(10);
        assertEquals("[null, 12, 10, 6, 7, 2, 1, 3, 4, 5]", heap.toString());
        heap.insert(11);
        assertEquals("[null, 12, 11, 6, 7, 10, 1, 3, 4, 5, 2]", heap.toString());
        heap.insert(9);
        assertEquals("[null, 12, 11, 6, 7, 10, 1, 3, 4, 5, 2, 9]", heap.toString());
        heap.insert(16);
        assertEquals("[null, 16, 11, 12, 7, 10, 6, 3, 4, 5, 2, 9, 1]", heap.toString());
        heap.insert(14);
        assertEquals("[null, 16, 11, 14, 7, 10, 12, 3, 4, 5, 2, 9, 1, 6]", heap.toString());

    }

}