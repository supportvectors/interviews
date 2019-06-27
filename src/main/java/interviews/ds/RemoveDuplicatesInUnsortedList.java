/*
 * Created on Jun 26, 2019 at 5:57:59 PM by Asif Qamar
 * Copyright (C) SupportVectors, Inc - Permission is granted to use it freely, under Apache 2.0 license.
 */
package interviews.ds;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * Using a hash-set.
 *
 */
public final class RemoveDuplicatesInUnsortedList {

    public static void removeDuplicates(LinkedList list) {
        System.out.printf("Original list: %s%n", list);
        if (list.isEmpty() || list.size() == 1)
            return; // Nothing to do!

        // For non-trivial lists
        var set = new LinkedHashSet<Integer>();
        set.add(list.head.value);
        var rabbit = list.head.next;
        var turtle = list.head;
        while (rabbit != null) {
            if (set.contains(rabbit.value)) {
                // Time to bypass it.
                turtle.next = rabbit.next;

            } else {
                // Just move along.
                turtle = rabbit;

            }

            set.add(rabbit.value);
            rabbit = rabbit.next;
        } // while

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[]      VALUES = { 5, 7, 8, 3, 3, 3, -2, -2, 11, 12, 8, 9, 10, 4, 5, 11, 4, 8, 12 };

        LinkedList list   = new LinkedList();
        Arrays.stream(VALUES)
              .forEach(x -> list.append(x));
        System.out.printf("Original List: %s%n", list);
        removeDuplicates(list);
        System.out.printf("Final List: %s%n", list);

    }

}
