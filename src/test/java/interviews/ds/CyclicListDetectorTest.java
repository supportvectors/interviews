package interviews.ds;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CyclicListDetectorTest {

    @Test
    void testDelectCycle() {
        final Node _1 = new Node(1);
        final Node _2 = new Node(2);
        final Node _3 = new Node(3);
        final Node _4 = new Node(4);
        final Node _5 = new Node(5);
        final Node _6 = new Node(6);
        final Node _7 = new Node(7);
        final Node _8 = new Node(8);
        final Node _9 = new Node(9);

        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;
        _5.next = _6;
        _6.next = _7;
        _7.next = _8;
        _8.next = _9;
        _9.next = _1;

        // Now, see if we can detect the cycle for the positive case.
        System.out.println("DETECTING CYCLE IN POSITIVE CASE");

        final boolean isCyclic = CyclicListDetector.detectCycle(_1);

        Assert.assertTrue("Failed to detect the cycle", isCyclic);
        System.out.println("Was there a cycle? " + isCyclic);
    }

    @Test
    void testDelectCycleDegenerateCase1() {
        final Node _1 = new Node(1);
        _1.next = _1;

        // Now, see if we can detect the cycle for the positive case.
        System.out.println("DETECTING CYCLE IN DEGENERATE CASE 1");

        final boolean isCyclic = CyclicListDetector.detectCycle(_1);

        Assert.assertTrue("Failed to detect the cycle in degenerate case", isCyclic);
        System.out.println("Was there a cycle? " + isCyclic);
    }

    @Test
    void testNonCyclicCase() {
        System.out.println(" DETECTING CYCLE IN NON-CYCLIC LIST ");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.append(value));
        final boolean isCyclic = CyclicListDetector.detectCycle(list.head);
        Assert.assertFalse("This list is not cyclic!", isCyclic);
        System.out.println("Was there a cycle? " + isCyclic);
    }
}
