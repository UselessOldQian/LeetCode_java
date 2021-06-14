package LinkedList;

/**
 * @author Qian
 * @create 2021-04-284:51 下午
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode n22 = new ListNode(2,null);
        ListNode n5 = new ListNode(5,n22);
        ListNode n2 = new ListNode(2,n5);
        ListNode n3 = new ListNode(3,n2);
        ListNode n4 = new ListNode(4,n3);
        ListNode n1 = new ListNode(1,n4);
        partition(n1,3);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode prevHead = new ListNode();
        prevHead.next = head;
        recur(prevHead,prevHead,head,x);
        return prevHead.next;
    }

    public static void recur(ListNode head, ListNode prev, ListNode cur, int x){
        if(cur==null){return;}
        ListNode headNext = head.next;
        ListNode next = cur.next;
        if(cur.val <x){
            switchHead(prev,cur,head);
        }
        if(headNext == head.next){
            recur(head, prev.next, next, x);
        }else {
            recur(head, prev, next, x);
        }
    }

    public static void switchHead(ListNode prev, ListNode cur, ListNode head){
        prev.next = cur.next;
        cur.next = head.next;
        head.next = cur;
    }
}
