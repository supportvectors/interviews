/*
 * Created on Jun 30, 2019 at 1:37:52 PM by Asif Qamar
 * Copyright (C) SupportVectors, Inc - Permission is granted to use it freely, under Apache 2.0 license.
 */
package interviews.ds;

/**
 * Finds the next greater node.
 */
public final class NextGreaterNode {

    public static LinkedList nextGreaterNode(final LinkedList list) {
        // Nothing to do if the list is either empty or had only one element
        if (list.head == null || list.head.next == null)
            return list;
        final LinkedList nextGreater = new LinkedList();

        // Let's bring in our turtle and the rabbit

        Node             turtle      = list.head;
        Node             rabbit      = list.head;

        while (rabbit != null && turtle != null) {

            if (rabbit.value <= turtle.value) {
                rabbit = rabbit.next; // rabbit keeps hopping ahead.
                continue;
            }
            // Let the turtle catch up with the rabbit
            while (turtle.value != rabbit.value) {
                nextGreater.append(rabbit.value);
                turtle = turtle.next;
            }

        }
        // Now, the turtle may still not be at the end.
        while (turtle != null) {
            nextGreater.append(-1);
            turtle = turtle.next;
        }
        return nextGreater;
    }

}
