package solutions15;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = null;
        ListNode prev = null;

        while (true) {
            int count = 0;
            ListNode min = null;
            int minIndex = -1;
            for (int i = 0; i < lists.length; i++) {
                ListNode curr = lists[i];
                if (curr == null) {
                    count++;
                    continue;
                }
                if(min == null){
                    min = curr;
                    minIndex = i;

                } else {
                    if(curr.val < min.val){
                        min = curr;
                        minIndex = i;
                    }
                }


            }
            if(min != null){
                lists[minIndex] = min.next;
            }

            if(count == lists.length){
                break;
            }
            if(head == null){
                head = min;
                prev = min;
            } else if(min != null && prev != null){
                prev.next = min;
                prev = prev.next;
            }
        }

        return head;

    }
}

 class ListNode {
    int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
