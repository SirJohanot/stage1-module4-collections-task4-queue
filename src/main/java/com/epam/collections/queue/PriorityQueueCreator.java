package com.epam.collections.queue;

import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueCreator {
    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {
        PriorityQueue<String> wholeList = new PriorityQueue<>(this::compareStrings);
        wholeList.addAll(firstList);
        wholeList.addAll(secondList);
        return wholeList;
    }

    private int compareStrings(String a, String b) {
        return -a.compareTo(b);
    }
}
