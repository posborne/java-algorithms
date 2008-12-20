package net.posborne.algorithms.sorting;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class InsertionSortTest {

    @Test
    public void testSort() {
        List<Integer> list = TestingSetupUtility.getRandomIntegerList(10, -392012, 39281003);
        List<Integer> listCopy = TestingSetupUtility.copyOfList(list);
        
        // sort the lists
        Collections.sort(listCopy);
        InsertionSort.sort(list);
        
        // test
        assertEquals(listCopy, list);
    }

}
