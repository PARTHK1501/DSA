class Solution{

    public int len(ListNode head){
        int count = 0;

        while(head != null){
            count++;
            head = head.next;
        }

        return count;
    }

    public ListNode reverseKGroup(ListNode head,int k){
        int N = len(head);
        int groups = N/k;

        ListNode currHead = head;
        ListNode prevHead = null;
        ListNode ansNode = null;

        for(int i=0;i<groups;i++){
            ListNode prev = null;
            ListNode curr = currHead;
            ListNode nextNode = null;

            for(int j=0;j<k;j++){
                nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            if(prevHead == null){
                ansNode = prev;
            }else{
                prevHead.next = prev;
            }
            prevHead = currHead;
            currHead = curr;
        }

        prevHead.next = currHead;

        return ansNode;
    }
}