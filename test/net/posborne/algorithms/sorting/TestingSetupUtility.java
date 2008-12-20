package net.posborne.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class TestingSetupUtility {
    public static List<Integer> getRandomIntegerList(int numItems, int lower, int upper) {
        ArrayList<Integer> list = new ArrayList<Integer>(numItems);
        int range = upper - lower;
        for (int i = 0; i < numItems; i++) {
            list.add(Integer.valueOf((int)(Math.random() * range) - lower));
        }
        return list;
    }

    public static List<Integer> copyOfList(List<Integer> list) {
        ArrayList<Integer> copy = new ArrayList<Integer>(list.size());
        for (Integer i : list) {
            copy.add(i);
        }
        return copy;
    }
}
