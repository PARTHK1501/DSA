/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode mergeLists(ListNode L1, ListNode L2) {
        if (L1 == null) {
            return L2;
        }

        if (L2 == null) {
            return L1;
        }

        if (L1.val <= L2.val) {
            L1.next = mergeLists(L1.next, L2);
            return L1;
        } else {
            L2.next = mergeLists(L1, L2.next);
            return L2;
        }
    }

    public ListNode partitionAndMerge(int s, int e, ListNode[] lists) {
        if (s == e) {
            return lists[s];
        }

        if (s > e) {
            return null;
        }

        int mid = s + (e - s) / 2;
        ListNode L1 = partitionAndMerge(s, mid, lists);
        ListNode L2 = partitionAndMerge(mid + 1, e, lists);

        return mergeLists(L1, L2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return partitionAndMerge(0, lists.length - 1, lists);
    }
}