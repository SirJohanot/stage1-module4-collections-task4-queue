package com.epam.collections.queue;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> sharedDeck = new ArrayDeque<>();

        sharedDeck.add(Objects.requireNonNull(firstQueue.poll()));
        sharedDeck.add(Objects.requireNonNull(firstQueue.poll()));

        sharedDeck.add(Objects.requireNonNull(secondQueue.poll()));
        sharedDeck.add(Objects.requireNonNull(secondQueue.poll()));

        while (firstQueue.size() > 0 || secondQueue.size() > 0) {
            Integer element;

            if (firstQueue.size() > 0) {
                element = sharedDeck.removeLast();
                firstQueue.add(element);

                element = firstQueue.poll();
                if (element != null) {
                    sharedDeck.add(element);
                }
                element = firstQueue.poll();
                if (element != null) {
                    sharedDeck.add(element);
                }
            }

            if (secondQueue.size() > 0) {
                element = sharedDeck.removeLast();
                secondQueue.add(element);
                
                element = secondQueue.poll();
                if (element != null) {
                    sharedDeck.add(element);
                }
                element = secondQueue.poll();
                if (element != null) {
                    sharedDeck.add(element);
                }
            }
        }

        return sharedDeck;
    }
}
