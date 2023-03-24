package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        int counter = 1;
        List<Integer> remainingDishes = IntStream.range(1, numberOfDishes + 1)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> eatenDishes = new ArrayList<>();

        while (remainingDishes.size() > 0) {
            for (int i = 0; i < remainingDishes.size(); i++, counter++) {
                if (counter == everyDishNumberToEat) {
                    eatenDishes.add(remainingDishes.get(i));
                    remainingDishes.remove(i);
                    i--;
                    counter = 0;
                }
            }
        }
        return eatenDishes;
    }
}
