package net.posborne.algorithms.sorting;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class BubbleSortTest {

    @Test
    public void testSort() {
        List<Integer> list = TestingSetupUtility.getRandomIntegerList(25000, -12033, 394892);
        List<Integer> listCopy = TestingSetupUtility.copyOfList(list);
        
        assertEquals(listCopy, list);
        Collections.sort(listCopy);
        BubbleSort.sort(list);
        assertEquals(listCopy, list);
    }

}
