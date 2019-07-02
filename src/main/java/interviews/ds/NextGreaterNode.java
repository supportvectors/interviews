/*
 * Created on Jun 30, 2019 at 1:37:52 PM by Asif Qamar
 * Copyright (C) SupportVectors, Inc - Permission is granted to use it freely, under Apache 2.0 license.
 */
package interviews.ds;

/**
 * Finds the next greater node.
 */
public final class NextGreaterNode {

    public static LinkedList oSquared(final LinkedList list) {
        if (list.head == null || list.head.next == null)
            return list;
        final LinkedList nextGreater = new LinkedList();
        //
        // Let's bring in our turtle and the rabbit

        Node             turtle      = list.head;
        while (turtle.next != null) {

            Node    rabbit = turtle.next;
            boolean found  = false;
            while (rabbit != null) {
                if (rabbit.value > turtle.value) {
                    nextGreater.append(rabbit.value);
                    found = true;
                    break;
                }
                rabbit = rabbit.next;

            }
            // if we reached here, no greater value!
            if (!found)
                nextGreater.append(0);
            turtle = turtle.next;
        }
        nextGreater.append(0);
        return nextGreater;
    }

}
