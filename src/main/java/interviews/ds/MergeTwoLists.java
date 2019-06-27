/*
 * Created on Jun 26, 2019 at 5:16:51 PM by Asif Qamar
 * Copyright (C) SupportVectors, Inc - Permission is granted to use it freely, under Apache 2.0 license.
 */
package interviews.ds;

import java.util.Arrays;

/**
 * Merges two given sorted LinkedLists
 *
 */
public class MergeTwoLists {

    public static final LinkedList mergeDestructive(LinkedList left,
                                                    LinkedList right) {

        if (left.isEmpty())
            return right;
        else if (right.isEmpty())
            return left;

        LinkedList merged = new LinkedList();

        while (left.isEmpty() == false || right.isEmpty() == false) {

            // Simple case where one list gets empty
            if (left.isEmpty()) {
                while (right.isEmpty() == false) {
                    int value = right.deleteFirst()
                                     .get();
                    merged.append(value);
                }

            } // left-empty
            else if (right.isEmpty()) {
                while (left.isEmpty() == false) {
                    int value = left.deleteFirst()
                                    .get();
                    merged.append(value);
                }

            } // right-empty
            else { // Both non-empty lists

                // Now, pluck the right one of the lists
                int leftCandidate  = left.first()
                                         .get();
                int rightCandidate = right.first()
                                          .get();

                if (leftCandidate < rightCandidate) {
                    merged.append(leftCandidate);
                    left.deleteFirst();
                } else {
                    merged.append(rightCandidate);
                    right.deleteFirst();
                }
            }
        } // while
        return merged;
    }

    public static void main(String[] args) {
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
