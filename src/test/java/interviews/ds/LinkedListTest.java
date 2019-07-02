package interviews.ds;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class LinkedListTest {

    public static final int[] VALUES = { 10, 30, 12, 11, 17, 10, 10, 19, 10, 23, 7, 5, 10 };

    @BeforeAll
    static public void setUpBeforeClass() throws Exception {
        System.out.println("Test initialized");
    }

    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Entering a unit-test");
    }

    @Test
    public void testDeleteIfExists() {
        System.out.println(" DELETE IF EXISTS FOR 10 TEST ");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.append(value));

        // finally, test a positive test case.
        System.out.printf("Before deleting: %n%s%n", list);
        boolean deleted = list.deleteIfExists(10);
        Assert.assertTrue(deleted);
        System.out.printf("After deleting: %n%s%n", list);

        // Negative test case:
        deleted = list.deleteIfExists(223);
        Assert.assertFalse(deleted);
    }

    @Test
    public void testDeleteIfExistsWithAllSame() {
        System.out.println(" DELETE IF EXISTS WITH UNIFORM ");
        final LinkedList list = new LinkedList();
        Arrays.stream(new int[] { 10, 10, 10, 10, 10 })
              .forEach(value -> list.append(value));

        // finally, test a positive test case.
        System.out.printf("Before deleting: %n%s%n", list);
        boolean deleted = list.deleteIfExists(10);
        Assert.assertTrue(deleted);
        System.out.printf("After deleting: %n%s%n", list);

        // Negative test case:
        deleted = list.deleteIfExists(223);
        Assert.assertFalse(deleted);
    }

    @Test
    public void testAppend() {
        System.out.println(" APPEND TEST ");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.append(value));

        System.out.println(list);
    }

    @Test
    public void testPrepend() {
        System.out.println("PREPEND TEST");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.prepend(value));

        System.out.println(list);
    }

    @Test
    public void testExists() {
        System.out.println("IF EXISTS 10 TEST");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.prepend(value));
        System.out.println(list);

        boolean exists = list.exists(10);
        Assert.assertTrue(exists);

        System.out.printf("Does 10 Exist? : %s%n", exists);
        exists = list.exists(345);
        Assert.assertFalse(exists);
        System.out.printf("Does 345 Exist? : %s%n", exists);

    }

    @Test
    public void testGetKth() {
        System.out.println("DELETE LAST TEST");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.prepend(value));
        System.out.println(list);
        int size = list.size();
        for (int k = 0; k < size; k++) {
            System.out.printf("The %s-index item is: %s %n",
                              k,
                              list.getKth(k)
                                  .get());
        }

    }

    @Test
    public void testGetKthLast() {
        System.out.println(" Get kth LAST TEST");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.prepend(value));
        System.out.println(list);

        for (int k = 1; k < list.size() + 1; k++) {
            System.out.printf("The (k=%s)-th last element is: %s%n",
                              k,
                              list.getKthLast(k)
                                  .get());
        }

    }

    @Test
    public void testDeleteKthLast() {

        for (int k = 0; k < VALUES.length + 1; k++) {
            System.out.println(" Delete kth LAST TEST");
            final LinkedList list = new LinkedList();
            Arrays.stream(LinkedListTest.VALUES)
                  .forEach(value -> list.prepend(value));
            System.out.println(list);

            System.out.printf("The (k=%s)-th last element is: %s%n",
                              k + 1,
                              list.deleteKthLast(k)
                                  .get());
            System.out.printf("The remaining list: %s%n", list);
        }

    }

    @Test
    public void testDeleteKth() {
        System.out.println("DELETE LAST TEST");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.prepend(value));
        System.out.println(list);
        int               k     = 10;
        Optional<Integer> value = list.deleteKth(k);
        System.out.printf("The %s-index item is: %s %n", k, value.get());

        System.out.printf("After removal, the new list now is: %n%s%n", list);

    }

    @Test
    public void testDeleteLast() {
        System.out.println("DELETE LAST TEST");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.prepend(value));
        System.out.println(list);
        Optional<Integer> last = list.deleteLast();

        Assert.assertFalse(last.isEmpty());
        System.out.printf("The last element is: %s%n", last.get());
        System.out.printf("The remaining list is: %n%s%n", list);
    }

    @Test
    public void testLast() {
        System.out.println("LAST TEST");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.prepend(value));
        System.out.println(list);
        Optional<Integer> last = list.last();

        Assert.assertFalse(last.isEmpty());
        System.out.printf("The last element is: %s%n", last.get());
    }

    @Test
    public void testFind() {
        System.out.println("FIND 10 TEST");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.prepend(value));
        System.out.println(list);
        int[] locations = list.find(10);
        System.out.printf("Locations of 10 in the list: %s%n", Arrays.toString(locations));

        // Test negative case.
        locations = list.find(345);
        System.out.printf("Locations of 345 in the list: %s%n", Arrays.toString(locations));

    }

    @Test
    public void testSize() {
        System.out.println(" SIZE TEST ");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.append(value));
        int size = list.size();
        Assert.assertEquals(size, VALUES.length);
        System.out.printf("The list size is: %s and array used had length: %s%n", size, VALUES.length);
    }

    @Test
    public void testDelete() {
        System.out.println(" DELETING AT LOCATION TEST ");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.append(value));

        // check that it handles the bad input well.
        Optional<Integer> deleted = list.delete(100);
        Assert.assertTrue(deleted.isEmpty());

        // test for the end corner case.
        deleted = list.delete(VALUES.length);
        Assert.assertTrue(deleted.isEmpty());

        // finally, test a positive test case.
        System.out.printf("Before deleting: %n%s%n", list);
        deleted = list.delete(3);
        System.out.printf("After deleting: %n%s%n", list);

        // finally, test deleting the first element.
        System.out.printf("Before deleting from head: %n%s%n", list);
        deleted = list.delete(0);
        System.out.printf("After deleting from head: %n%s%n", list);

    }

    @Test
    public void testInsertAtLocation() {
        System.out.println(" INSERT AT LOCATION TEST ");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.append(value));
        boolean inserted = list.insertAtLocation(100, 0);
        Assert.assertFalse(inserted);

        inserted = list.insertAtLocation(5, 0);

        System.out.println(list);

        // Now, insert at the head.
        inserted = list.insertAtLocation(0, 200);
        System.out.printf("After head insert: %s%n", list);

    }

    @Test
    public void testReverse() {
        System.out.println(" REVERSE LIST TEST ");
        final LinkedList list = new LinkedList();
        Arrays.stream(LinkedListTest.VALUES)
              .forEach(value -> list.append(value));
        System.out.printf("Original list: %s%n", list);
        list.reverse();
        System.out.printf("After reversing: %s%n", list);
    }
}
