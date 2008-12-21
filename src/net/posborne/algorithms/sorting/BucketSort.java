package net.posborne.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Container for bucket sort implementation
 * 
 * @author Paul Osborne
 * @version December 20, 2008
 */
public class BucketSort {

    /**
     * Bucket sort where nothing is known about the data items other than that they
     * are all Integers.  This will create buckets between the minimum and maximum
     * allowable Integer values.
     * 
     * The bucket sort (or bin sort) is a non-comparison sort in the same family
     * as the radix sort, counting sort, pigeonhole sort, and burstsort.
     * 
     * The bucket sort has four main steps:
     *   1. Setup a list of empty buckets
     *   2. Scatter: go over original list, placing items in appropriate bucket
     *   3. Sort each non-empty bucket (recursively)
     *   4. Gather: visit the buckets in order and place into original.
     * 
     * The number of buckets can be predetermined or it can be a function of the
     * number of data items in a list.  Each bucket has a fraction of the domain
     * of the data items.  The problem is that it is impossible to predict the
     * domain and distribution of the data items contained in the provided list.
     * Due to this problem, this sort is limited to a list containing Integer
     * values.  The sort method is overloaded to allow for the explicit specifying
     * of minimum and maximum value of items in the list.  Providing this will
     * improve performance, decreasing the sparseness of buckets.
     * 
     * <a href="http://en.wikipedia.org/wiki/Bucket_sort">Bucket Sort on Wikipedia</a>.
     * 
     * @param list The list of Integers to be sorted (in place).
     */
    public static void sort(List<Integer> list) {
        sort(list, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    /**
     * Overloaded sort method that allows for explicit specification of the minimum
     * and maximum values contained in the list.  The algorithm will sort no matter
     * what, placing outlying values in the end containers.  So, it is better to
     * use this method than the generic sort if a majority of data items are between
     * some range with outliers.  This will result in more even bucket distributions 
     * (which is the main determining factor in how efficient the sort will be).
     * 
     * @param list The list to sort.
     * @param listMin The lower end of the bucket spectrum
     * @param listMax The upper end of the bucket spectrum
     */
    public static void sort(List<Integer> list, Integer listMin,  Integer listMax) {
        int numBuckets = (int) Math.ceil(list.size() / 30); // ~ 30 items/bucket
        
        // initialize the buckets
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
        	buckets.add(new ArrayList<Integer>());
        }
        
        // go through the list and put each item in the correct bucket
        for (int i = 0; i < list.size(); i++) {
        	int bucket = bucketForNumber(list.get(i), listMin, listMax, numBuckets);
        	buckets.get(bucket).add(list.get(i));
        }
        
        // sort each of the buckets using insertion sort
        int listIndex = 0;
        for (ArrayList<Integer> bucket : buckets) {
        	InsertionSort.sort(bucket);
        	for (Integer item : bucket) {
        		list.set(listIndex++, item);
        	}
        }
    }

    /**
     * Determine what bucket a number should be in based on the parameters given.  There
     * are some tricky conditions in here that need to be dealt with as this is not
     * a simple pigeonholable implementation of bucket sort.
     * 
     * @param number
     * @param listMin
     * @param listMax
     * @param numBuckets
     * @return
     */
	private static int bucketForNumber(Integer number, Integer listMin, Integer listMax, Integer numBuckets) {
		Long difference = (long)listMax - listMin;
		int increment = (int)Math.ceil(difference / numBuckets);
		increment = increment <= 0 ? 1 : increment;
		int bucket = number / increment;
		if (bucket >= numBuckets) {
			bucket = numBuckets - 1;
		} else if (bucket < 0) {
			bucket = 0;
		}
		return bucket;
	}
    
}
