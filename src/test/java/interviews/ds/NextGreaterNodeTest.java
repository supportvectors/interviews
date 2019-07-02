package interviews.ds;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class NextGreaterNodeTest {

    @Test
    void test() {
        System.out.println(" NEXT GREATER TEST ");
        final LinkedList list = new LinkedList();
        Arrays.stream(new int[] { 1, 4, 2, 3, 5, 2, 3, 6, 8, 9, 10, 1, 2, 3, 4, 12 })
              .forEach(value -> list.append(value));
        System.out.printf("Original List: %n%s%n", list);
        LinkedList greaterNodeList = NextGreaterNode.nextGreaterNode(list);

        System.out.printf("Greater Node List: %n%s%n", greaterNodeList);
    }

}
