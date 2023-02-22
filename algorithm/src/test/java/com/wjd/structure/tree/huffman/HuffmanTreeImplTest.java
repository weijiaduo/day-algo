package com.wjd.structure.tree.huffman;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HuffmanTreeImplTest {

    @Test
    void testGetCode() {
        Map<String, Integer> weightMap = new HashMap<>();
        weightMap.put("A", 5);
        weightMap.put("B", 1);
        weightMap.put("C", 6);
        weightMap.put("D", 3);

        HuffmanTree huffmanTree = HuffmanTreeImpl.build(weightMap);
        assertEquals("11", huffmanTree.getCode("A"));
        assertEquals("100", huffmanTree.getCode("B"));
        assertEquals("0", huffmanTree.getCode("C"));
        assertEquals("101", huffmanTree.getCode("D"));
    }
}