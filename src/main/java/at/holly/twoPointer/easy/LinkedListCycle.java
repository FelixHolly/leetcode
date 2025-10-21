package at.holly.twoPointer.easy;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/linked-list-cycle/?envType=problem-list-v2&envId=two-pointers
public class LinkedListCycle {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    // Uses O(n) extra space
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        Set<ListNode> occurringNotes = new HashSet<>();

        while (head != null){
            if (occurringNotes.contains(head)){
                return true;
            }
            occurringNotes.add(head);
            head = head.next;
        }

        return false;
    }

    //Floyd’s Cycle Detection - Uses two pointers, runs in O(n) time, O(1) space.
    public boolean hasCycleFloyd(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;               //moves 1 step
            fast = fast.next.next;          //moves 2 steps

            //we compare the reference of the objects
            if (slow == fast) return true;  // pointers meet → cycle
        }

        return false;
    }
}
