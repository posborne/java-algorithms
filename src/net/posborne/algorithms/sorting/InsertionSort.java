package net.posborne.algorithms.sorting;

import java.util.List;

/**
 * Container for an implementation of insertion sort.
 * 
 * @author Paul Osborne
 * @version December 20, 2008
 */
public class InsertionSort {

    /**
     * The insertion sort is one of the less complicated sorts. Like the
     * selection sort the sort works well for lists that are almost completely
     * sorted to start with.
     * 
     * The works from the start toward the end. It linearly searches the list to
     * the right of the current element, finding the smallest element. After the
     * search is complete the smallest element is swapped with the beginning
     * element of the search list. This creates a sorted list from 0 to the
     * current index. When the search list is only the last element, the search
     * is complete.
     * 
     * The algorithm has O(n^2) performance for a reverse sorted list but can be
     * much better for mostly sorted lists.
     * 
     * @param <T>
     *            The parameterized type of the list.
     * @param list
     *            The list that should be sorted.
     */
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            // find the min in the search list
            int minIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            // swap leftmost and min
            T tmp = list.get(i);
            list.set(i, list.get(minIndex));
            list.set(minIndex, tmp);
        }
    }

}
