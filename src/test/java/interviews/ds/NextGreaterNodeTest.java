package interviews.ds;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class NextGreaterNodeTest {

    @Test
    void testOSquared() {
        System.out.println(" NEXT GREATER TEST ");
        final LinkedList list = new LinkedList();
        Arrays.stream(new int[] { 1, 7, 5, 1, 9, 2, 5, 1 })
              .forEach(value -> list.append(value));
        System.out.printf("Original List: %n%s%n", list);
        LinkedList greaterNodeList = NextGreaterNode.oSquared(list);

        System.out.printf("Greater Node List: %n%s%n", greaterNodeList);
    }

}
