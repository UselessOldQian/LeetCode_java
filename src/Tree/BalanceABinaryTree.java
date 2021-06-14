package Tree;

import sun.applet.Main;

import java.util.*;

/**
 * @author Qian
 * @create 2021-05-064:33 下午
 */
public class BalanceABinaryTree {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node16 = new TreeNode(16, null, null);
        TreeNode node9 = new TreeNode(9, node2, node3);
        TreeNode node14 = new TreeNode(14, node9, node16);
        //balanceBST(node14);
        System.out.println(Math.floorMod(-1,3));
        System.out.println((4&1));
        int[] arr = {6,2,3,4};
        Arrays.sort(arr);
        System.out.println(arr);
    }

    public static TreeNode balanceBST(TreeNode root) {
        List<TreeNode> inorderArr = new ArrayList<>();
        inOrder(root,inorderArr);
        int n = inorderArr.size();
        TreeNode head = helper(0, n, inorderArr);
        return head;
    }

    public static void inOrder(TreeNode root, List<TreeNode> arr){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            arr.add(cur);
            cur = cur.right;
        }
    }

    public static TreeNode helper(int start, int end, List<TreeNode> arr){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode cur = arr.get(mid);
        cur.left = helper(start, mid-1, arr);
        cur.right = helper(mid+1, end, arr);
        return cur;
    }
}
