package net.posborne.algorithms.sorting;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.Test;


public class BucketSortTest {

    @Test
    public void testSort() {
        List<Integer> list = TestingSetupUtility.getRandomIntegerList(25000, -392023, 3049293);
        List<Integer> listCopy = TestingSetupUtility.copyOfList(list);
        
        assertEquals(listCopy, list);
        Collections.sort(listCopy);
        BucketSort.sort(list, -392023, 3049293);
        assertEquals(listCopy, list);
    }
	
}
