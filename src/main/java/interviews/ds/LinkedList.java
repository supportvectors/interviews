/*
 * Created on Jun 19, 2019 at 6:03:35 PM by Asif Qamar
 * Copyright (C) SupportVectors, Inc - Permission is granted to use it freely, under Apache 2.0 license.
 */
package interviews.ds;

import java.util.Optional;

/**
 * In order to keep the code readable, we have deliberately not used OOP-features and encapsulation. Also, generics have not been used.
 *
 */
public class LinkedList {
    Node head;

    /**
     * Append a value to the linked-list.
     *
     * @param value
     */
    public void append(final int value) {
        final Node node = new Node(value);

        // If it is an empty list, no need to traverse.
        if (this.head == null) {
            this.head = node;
        } else {
            // Else traverse the list and find the last node
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            // Now, append to it.
            current.next = node;

        } // else

    }

    public boolean delete(final int index) {
        if (index < 0 || this.size() <= index)
            // List is too short, and index is not a valid location
            return false;

        if (index == 0)
            return this.deleteFirst();

        int  idx     = 0;
        Node current = this.head;

        while (idx < index - 1) {
            current = current.next;
            idx++;
        }

        // Now do the deleting.
        final Node tmp = current.next;
        current.next = tmp.next;
        tmp.next     = null;    // Leave node to be garbage-collected.
        return true;
    }

    public boolean deleteFirst() {
        if (this.isEmpty())
            return false;
        this.head = this.head.next;
        return true;
    }

    public boolean deleteIfExists(final int value) {
        if (this.isEmpty())
            return false;

        boolean found = false;
        if (this.head.value == value) {
            found = true;
            this.deleteFirst();
        }

        Node current = this.head;

        while (current.next != null) {
            if (current.next.value == value) {
                found = true;
                // bypass the node in the list.
                final Node toDelete = current.next;
                current.next  = toDelete.next;
                toDelete.next = null;
            } else {
                current = current.next; // continue the search.
            }
        }

        return found;
    }

    /**
     * Here we do a one-pass solution.
     *
     *
     * Another way, but using two-pass, could have been to find the (size-k-1)th element, and return that.
     *
     *
     * @param k
     * @return
     */
    public Optional<Integer> deleteKthLast(final int k) {
        Node turtle = null;     // but the turtle will not move forward.
        Node rabbit = this.head;

        int  steps  = 0;

        // First let the rabbit hit the end, and the turtle follow.
        while (rabbit.next != null) {
            rabbit = rabbit.next;
            steps++;

            if (steps > k) {
                if (turtle == null)
                    turtle = this.head;
                else
                    turtle = turtle.next;
            }
        }

        // Special case: if we are at the beginning, and the turtle never moved

        if (turtle == null) {
            final Optional<Integer> value = Optional.of(this.head.value);
            this.head = this.head.next;
            return value;
        }

        final Node              toDelete = turtle.next;
        final Optional<Integer> value    = Optional.of(toDelete.value);

        turtle.next   = toDelete.next;
        toDelete.next = null;
        return value;
    }

    public Optional<Integer> deleteLast() {
        if (this.isEmpty())
            return Optional.empty();

        if (this.size() == 1) {
            final Optional<Integer> optional = Optional.of(this.head.value);
            this.head = null;
            return optional;
        }

        Node previous = this.head;
        while (previous.next != null) {
            final Node current = previous.next;
            if (current.next == null) {
                // time to break, since we want to delete this node.
                break;
            }
            previous = current;

        } //

        // Let us now delete the last element
        final Node last = previous.next;
        previous.next = null;
        // Finally, return its value
        return Optional.of(last.value);

    }

    public boolean exists(final int value) {
        if (this.isEmpty())
            return false;

        for (Node current = this.head; current != null; current = current.next) {
            if (current.value == value)
                return true;
        }
        // if we reached the end, it means we did not find it.
        return false;
    }

    /**
     * Find the locations where a value exists.
     *
     * @param value
     * @return
     */
    public int[] find(final int value) {
        if (this.isEmpty())
            return new int[] {};

        int              idx     = 0;
        final LinkedList idxList = new LinkedList();
        Node             current = this.head;

        // Prepare the location list (using this linked-list class itself!)
        while (current != null) {
            if (current.value == value) {
                idxList.append(idx);
            }
            idx++;
            current = current.next;
        } // while

        final int[] locations = new int[idxList.size()];

        // Now, iterate over the idxList
        Node        location  = idxList.head;
        idx = 0;
        while (location != null) {
            locations[idx++] = location.value;
            location         = location.next;
        }

        return locations;

    }

    /**
     * Get the first element.
     *
     * @return
     */
    public Optional<Integer> first() {

        return this.isEmpty() ? Optional.empty() : Optional.of(this.head.value);

    }

    public Optional<Integer> getKth(final int k) {
        if (this.size() < k - 1)
            return Optional.empty();

        if (k == 0)
            return this.first();

        int  idx      = 0;
        Node previous = this.head;

        while (idx < k - 1) {
            previous = previous.next;
            idx++;
        }

        return Optional.of(previous.next.value);

    }

    /**
     * Here we do a one-pass solution.
     *
     *
     * Another way, but using two-pass, could have been to find the (size-k-1)th element, and return that.
     *
     *
     * @param k
     * @return
     */
    public Optional<Integer> getKthLast(final int k) {
        Node turtle = this.head; // but the turtle will not move forward.
        Node rabbit = this.head;

        int  steps  = 0;

        // First let the rabbit hit the end, and the turtle follow.
        while (rabbit.next != null) {
            rabbit = rabbit.next;
            steps++;

            if (steps >= k) {
                turtle = turtle.next;
            }
        }

        // Next, just read what the turtle is sitting on.
        return Optional.of(turtle.value);
    }

    public boolean insertAtLocation(final int index,
                                    final int value) {
        if (index < 0 || this.size() < index)
            return false; // List is too short to insert at index

        // First move the cursor to the right location in the list
        Node current = this.head;
        int  idx     = 0;
        while (idx < index - 1) {
            current = current.next;
            idx++;
        }

        // Next do the inserting.
        final Node node = new Node(value);
        node.next    = current.next;
        current.next = node;
        return true;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public Optional<Integer> last() {
        if (this.isEmpty())
            return Optional.empty();

        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }

        return Optional.of(current.value);
    }

    /**
     * Prepend a value to the linked-list.
     *
     * @param value
     *                  value to add.
     */
    public void prepend(final int value) {
        final Node node = new Node(value);

        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;

        } // else

    }

    public Optional<Integer> deleteKth(final int k) {
        if (this.size() < k - 1)
            return Optional.empty();

        if (k == 0)
            return this.first();

        int  idx      = 0;
        Node previous = this.head;

        while (idx < k - 1) {
            previous = previous.next;
            idx++;
        }

        // Remove and return.
        final Node kth = previous.next;
        previous.next = kth.next;
        return Optional.of(kth.value);

    }

    /**
     * Finds and returns the size of the linked-list.
     *
     * @return the number of elements in the list.
     */
    public int size() {
        int  size    = 0;
        Node current = this.head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder builder  = new StringBuilder();
        final String        template = "%s ";
        Node                current  = this.head;
        int                 i        = 0;
        while (current != null) {
            builder.append(String.format(template, current.value));
            current = current.next;
            i++;
        }
        return builder.toString();
    }

}

class Node {
    Node next;

    int  value;

    Node(final int value) {
        this.value = value;
    }

    Node(final int value, final Node next) {
        this.value = value;
        this.next  = next;
    }
}
