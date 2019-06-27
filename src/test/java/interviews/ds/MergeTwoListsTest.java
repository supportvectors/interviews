/*
 * Created on Jun 26, 2019 at 5:40:01 PM by Asif Qamar
 * Copyright (C) SupportVectors, Inc - Permission is granted to use it freely, under Apache 2.0 license.
 */
package interviews.ds;

import java.util.Arrays;

import org.junit.Test;

/**
 * Test cases for merged-list
 *
 */
public class MergeTwoListsTest {

    @Test
    public void testMergeDestructively() {
        int[]      LEFT  = { 1, 3, 5, 7, 9, 9, 10, 11 };
        int[]      RIGHT = { 1, 2, 4, 6, 7, 8, 10, 12 };

        LinkedList left  = new LinkedList();
        Arrays.stream(LEFT)
              .forEach(x -> left.append(x));

        LinkedList right = new LinkedList();
        Arrays.stream(RIGHT)
              .forEach(x -> right.append(x));

        LinkedList merged = MergeTwoLists.mergeDestructive(left, right);

        System.out.printf("The merged list is: %n%s%n", merged);

    }

}
