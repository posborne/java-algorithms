package net.posborne.algorithms.sorting;

import java.util.List;

/**
 * Container for the insertion sort.
 * 
 * @author Paul Osborne
 * @version December 19, 2008
 */
public class SelectionSort {
    
    /**
     * The insertion sort is not the most optimal sort for largely unsorted lists of
     * data but is very close to being the best for list that are almost completely sorted.
     * For such lists the efficiency is O(n + d) where d is the number of inversions that
     * must be performed.
     * 
     * The insertion sort works by working through the data items and 
     * 
     * @param <T> The comparable type in the list to be sorted.
     * @param list The list of items that should be sorted.
     */
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T value = list.get(i);
            int j;
            for (j = i -1; j >= 0 && list.get(j).compareTo(value) > 0; j--) {
                list.set(j + 1, list.get(j));
            }
            list.set(j + 1, value);
        }
    }
    
}
