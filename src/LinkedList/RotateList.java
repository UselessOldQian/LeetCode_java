package LinkedList;

/**
 * @author Qian
 * @create 2021-04-234:24 下午
 */
public class RotateList {
    public static void main(String[] args) {
//        ListNode n5 = new ListNode(1,null);
//        ListNode n4 = new ListNode(1,n5);
//        ListNode n3 = new ListNode(1,n4);
        ListNode n2 = new ListNode(2,null);
        ListNode n1 = new ListNode(1,n2);
        rotateRight(n1,0);

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null){return null;}
        int n = getLength(head,head,1);
        k %= n;
        if(k==0){k=n-1;}
        ListNode res = breakLink(head, 0, k);
        return res;
    }

    public static int getLength(ListNode head, ListNode curr,int length){
        if(curr.next == null){
            curr.next = head;
            return length;
        }
        return getLength(head, curr.next,++length);
    }

    public static ListNode breakLink(ListNode curr, int curLen, int end){
        if(curLen>=end){
            ListNode temp = curr.next;
            curr.next = null;
            return temp;
        }
        return breakLink(curr.next, ++curLen, end);
    }
}
