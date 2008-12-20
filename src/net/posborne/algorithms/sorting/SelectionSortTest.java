package net.posborne.algorithms.sorting;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class SelectionSortTest {

    @Test
    public void testSort() {
        List<Integer> list = TestingSetupUtility.getRandomIntegerList(25000, -38921023, 9349920);
        List<Integer> listCopy = TestingSetupUtility.copyOfList(list);
        SelectionSort.sort(list);
        Collections.sort(listCopy);
        assertEquals(listCopy, list);
    }

}
