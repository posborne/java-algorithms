package net.posborne.algorithms.sorting;

import java.util.List;

/**
 * Container for generic bubble sort on a list.
 * 
 * @author Paul Osborne
 * @version December 18, 2008
 */
public class BubbleSort {

    /**
     * First off, BUBBLE SORT RUNS IN O(N^2) AND IS A 'BAD ALGORITHM'.  It is included
     * in this collection for completeness reasons and should not be used in practice.
     * 
     * Perform a bubble sort on the provided list of comparable data items provided.
     * The bubble sort is a simple sort that operates by swapping elements, moving the
     * largest element to the end of the list.  Each time through the algorithm needs to
     * check against one less item since it is guaranteed that the last element in the
     * list is the largest (and thus in sorted order).  The list is completely sorted when
     * algorithm has an unsorted list remaining of size 1.
     * 
     * The Big-O running time of the bubble sort is O(n^2) at worst (though on average it
     * will be less, depending on how many swaps need to be performed).  The algorithm does
     * not lend itself to parallelization.
     * 
     * @param <T> The comparable type contained in the list
     * @param list The list of data items that should be sorted
     */
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) < 0) {
                    // swap j and j + 1
                    T tmp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, tmp);
                }
            }
        }
    }

}
