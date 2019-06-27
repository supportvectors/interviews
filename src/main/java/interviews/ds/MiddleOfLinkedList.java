/*
 * Created on Jun 26, 2019 at 6:46:16 PM by Asif Qamar
 * Copyright (C) SupportVectors, Inc - Permission is granted to use it freely, under Apache 2.0 license.
 */
package interviews.ds;

import java.util.Arrays;

/**
 * TODO: Enter class-level documentation here.
 *
 */
public final class MiddleOfLinkedList {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final int[]      VALUES = { 5, 7, 8, 3, 3, 3, -2, -2, 11, 12, 8, 9, 10, 4, 5, 11, 4, 8, 12, 99 };

        final LinkedList list   = new LinkedList();
        Arrays.stream(VALUES)
              .forEach(x -> list.append(x));
        System.out.printf("List: %s of size %s%n", list, list.size());

        final int middle = middle(list);
        System.out.printf("Middle of the  List: %s%n", middle);
    }

    /**
     * We use the simplifying assumption that if the list has even elements, and the middle-most elements are a -> b, we select a.
     *
     * @param list
     * @return
     */
    public static int middle(final LinkedList list) {

        if (list.size() == 1)
            return list.first()
                       .get();
        var turtle = list.head;
        var rabbit = list.head;

        int steps  = 0;
        while (rabbit.next != null) {
            rabbit = rabbit.next;
            if (steps % 2 == 1)
                turtle = turtle.next;
            steps++;
        }

        final int middle = turtle.next.value;
        return middle;

    }

}
