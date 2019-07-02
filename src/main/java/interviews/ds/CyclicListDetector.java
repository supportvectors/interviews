/*
 * Created on Jun 30, 2019 at 12:41:28 PM by Asif Qamar
 * Copyright (C) SupportVectors, Inc - Permission is granted to use it freely, under Apache 2.0 license.
 */
package interviews.ds;

/**
 * TODO: Enter class-level documentation here.
 *
 */
public final class CyclicListDetector {

    public static boolean detectCycle(final Node aNode) {

        if (aNode.next == null)
            return false;
        var rabbit = aNode.next;
        var turtle = aNode;

        while (rabbit.next != null && rabbit.next.next != null) {
            if (turtle == rabbit)
                return true; // found a cycle
            turtle = turtle.next;      // turtle moves a step
            rabbit = rabbit.next.next; // hop two steps ahead.
        }
        return false;
    }

}
