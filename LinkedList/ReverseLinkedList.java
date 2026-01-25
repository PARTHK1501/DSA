class Solution{
    public ListNode reverseList(ListNode head)
    if(head == null || head.next == null) return head;

    int length = 0;
    ListNode temp = head;

    while(temp != null){
        length++;
        temp = temp.next;
    }

    ListNode prevNode = null;

    while(length>0){
        ListNode nextNode = head.next;
        head.next = prevNode;
        prevNode = head;
        head = nextNode;
        length--;
    }

    return head;
}