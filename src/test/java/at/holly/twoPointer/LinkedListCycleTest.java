package at.holly.twoPointer;

import at.holly.twoPointer.easy.LinkedListCycle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleTest {

    private LinkedListCycle linkedListCycle;
    private LinkedListCycle.ListNode createNode(int val) {
        linkedListCycle = new LinkedListCycle();
        return linkedListCycle.new ListNode(val);
    }

    @Test
    void hasCycle_nullHead_returnsFalse() {
        linkedListCycle = new LinkedListCycle();
        assertFalse(linkedListCycle.hasCycle(null));
    }

    @Test
    void hasCycle_singleNodeNoCycle_returnsFalse() {
        LinkedListCycle.ListNode head = createNode(1);
        assertFalse(linkedListCycle.hasCycle(head));
    }

    @Test
    void hasCycle_singleNodeWithCycle_returnsTrue() {
        LinkedListCycle.ListNode head = createNode(1);
        head.next = head;
        assertTrue(linkedListCycle.hasCycle(head));
    }

    @Test
    void hasCycle_multipleNodesNoCycle_returnsFalse() {
        LinkedListCycle.ListNode head = createNode(1);
        head.next = createNode(2);
        head.next.next = createNode(3);
        head.next.next.next = createNode(4);
        assertFalse(linkedListCycle.hasCycle(head));
    }

    @Test
    void hasCycle_multipleNodesWithCycleAtEnd_returnsTrue() {
        LinkedListCycle.ListNode head = createNode(3);
        LinkedListCycle.ListNode second = createNode(2);
        LinkedListCycle.ListNode third = createNode(0);
        LinkedListCycle.ListNode fourth = createNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // cycle back to second node

        assertTrue(linkedListCycle.hasCycle(head));
    }

    @Test
    void hasCycle_multipleNodesWithCycleAtHead_returnsTrue() {
        LinkedListCycle.ListNode head = createNode(1);
        LinkedListCycle.ListNode second = createNode(2);

        head.next = second;
        second.next = head; // cycle back to head

        assertTrue(linkedListCycle.hasCycle(head));
    }

    @Test
    void hasCycleFloyd_nullHead_returnsFalse() {
        linkedListCycle = new LinkedListCycle();
        assertFalse(linkedListCycle.hasCycleFloyd(null));
    }

    @Test
    void hasCycleFloyd_singleNodeNoCycle_returnsFalse() {
        LinkedListCycle.ListNode head = createNode(1);
        assertFalse(linkedListCycle.hasCycleFloyd(head));
    }

    @Test
    void hasCycleFloyd_singleNodeWithCycle_returnsTrue() {
        LinkedListCycle.ListNode head = createNode(1);
        head.next = head;
        assertTrue(linkedListCycle.hasCycleFloyd(head));
    }

    @Test
    void hasCycleFloyd_multipleNodesNoCycle_returnsFalse() {
        LinkedListCycle.ListNode head = createNode(1);
        head.next = createNode(2);
        head.next.next = createNode(3);
        head.next.next.next = createNode(4);
        assertFalse(linkedListCycle.hasCycleFloyd(head));
    }

    @Test
    void hasCycleFloyd_multipleNodesWithCycleAtEnd_returnsTrue() {
        LinkedListCycle.ListNode head = createNode(3);
        LinkedListCycle.ListNode second = createNode(2);
        LinkedListCycle.ListNode third = createNode(0);
        LinkedListCycle.ListNode fourth = createNode(-4);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second; // cycle back to second node

        assertTrue(linkedListCycle.hasCycleFloyd(head));
    }

    @Test
    void hasCycleFloyd_multipleNodesWithCycleAtHead_returnsTrue() {
        LinkedListCycle.ListNode head = createNode(1);
        LinkedListCycle.ListNode second = createNode(2);

        head.next = second;
        second.next = head; // cycle back to head

        assertTrue(linkedListCycle.hasCycleFloyd(head));
    }
}
