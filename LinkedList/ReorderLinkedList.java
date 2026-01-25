class Solution{

    public ListNode reversLinkedList(ListNode head){

        if(head.next == null || head == null){
            return head;
        }

        ListNode reverseL = reversLinkedList(head.next);
        head.next.next = head;
        head.next = null;

        return reverseL;
    }

    public void reorderList(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        While(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reversLinkedList(slow);
        ListNode curr = head;

        while(rev.next != null){
            ListNode tempcurr = curr.next;
            curr.next = rev;

            ListNode temprev = rev.next;
            rev.next = tempcurr;

            curr= tempcurr;
            rev = temprev;
        }
    }
}