/*
 * Created on Jun 26, 2019 at 5:47:38 PM by Asif Qamar
 * Copyright (C) SupportVectors, Inc - Permission is granted to use it freely, under Apache 2.0 license.
 */
package interviews.ds;

import java.util.Arrays;

/**
 * TODO: Enter class-level documentation here.
 *
 */
public class RemoveDuplicatesInSortedList {

    public static final void removeDuplicates(LinkedList list) {

        // Base case handling
        if (list.isEmpty() || list.size() == 1)
            return;

        // Next actually move forward.
        Node current = list.head;

        while (current.next != null) {
            int value     = current.value;
            int nextValue = current.next.value;
            if (value == nextValue) {
                // time to delete the next node.
                Node tmp = current.next;
                current.next = tmp.next;
                tmp.next     = null;    // not really necessary...
            } else
                current = current.next;
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[]      VALUES = { 1, 1, 3, 4, 5, 5, 5, 7, 9, 10, 10, 10, 10, 10, 11, 12, 12, 12, 12, 12 };
        LinkedList list   = new LinkedList();
        Arrays.stream(VALUES)
              .forEach(x -> list.append(x));
        System.out.printf("Original List: %s%n", list);
        removeDuplicates(list);
        System.out.printf("Final List: %s%n", list);

    }

}
