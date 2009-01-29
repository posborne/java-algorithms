package net.posborne.algorithms.sorting;

import java.util.List;

public class ShellSort {

	/**
	 * The shell sort operates in O(n^2 log(n)) time. In concept it is a
	 * modified selection sort that uses steps that allow for movement of values
	 * faster than one position at a time.
	 * 
	 * There are a few intricacies that make the Shell sort most effective.
	 * First, choosing an appropriate increment interval is important. This
	 * implementation decreases the increment value by a factor of 2.2 each time
	 * around, until the increment is 2 (which we bump done to one).
	 * 
	 * The idea behind the shell sort is to organize the data into a
	 * two-dimensional array and then sort the columns of the array. The
	 * increment size at any given time is the number of rows in each column of
	 * the array. We start with and nx1 array that is completely unsorted and
	 * then sort those. Then we combine and sort some more, getting to the point
	 * where we have only one column. This plays on the strength of the
	 * underlying selection sort of performing less swaps for smaller data
	 * lists.
	 * 
	 * @param <T>
	 *            The parameterized type contained in the list.
	 * @param list
	 *            The list to be sorted.
	 */
	public static <T extends Comparable<? super T>> void sort(List<T> list) {
		// set the initial increment to be half the list
		int increment = list.size() / 2;
		for (; increment > 0; increment = nextIncrement(increment)) {
			// go from increment to end of list
			for (int i = increment; i < list.size(); i++) {
				// go down from i value until a value greater than the current
				// value is
				// found or we hit the beginning (increment)
				T temp = list.get(i);
				int j;
				for (j = i; j >= increment
						&& list.get(j - increment).compareTo(temp) > 0; j -= increment) {
					list.set(j, list.get(j - increment));
				}
				// we want to swap the j value (greater than temp) with the
				// temporary value
				list.set(j, temp);
			}
		}
	}

	/**
	 * Calculate the next increment level (they get smaller). This is separated
	 * out for easier modification.
	 * 
	 * @param increment
	 *            The current increment value
	 * @return The next increment that should be used for performing the shell
	 *         sort.
	 */
	private static int nextIncrement(int increment) {
		if (increment == 2) {
			return 1;
		} else {
			return (int) Math.round(increment / 2.2);
		}
	}

}
