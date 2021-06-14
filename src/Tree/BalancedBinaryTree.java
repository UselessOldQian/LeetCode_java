package Tree;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Qian
 * @create 2021-05-317:50 下午
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(3,null,null);
        TreeNode treeNode4_1 = new TreeNode(3,null,null);
        TreeNode treeNode3 = new TreeNode(2,treeNode4,treeNode4_1);
        TreeNode treeNode3_1 = new TreeNode(2,null,null);
        TreeNode treeNode2 = new TreeNode(1,treeNode3,treeNode3_1);
        TreeNode treeNode2_1 = new TreeNode(1,null,null);
        TreeNode treeNode1 = new TreeNode(0,treeNode2,treeNode2_1);
        isBalanced(treeNode1);
    }

    public static boolean isBalanced(TreeNode root) {
        if(root ==null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        queue.offer(root);
        depthQueue.offer(0);
        int min = Integer.MAX_VALUE;
        int max = 0;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            int depth = depthQueue.poll();
            if(cur.left == null & cur.right == null){
                min = Math.min(min,depth);
                max = Math.max(max,depth);
                continue;
            }
            if(cur.left != null){
                queue.offer(cur.left);
                depthQueue.offer(depth+1);
            }else{
                min = Math.min(min,depth);
                max = Math.max(max,depth);
            }

            if(cur.right != null){
                queue.offer(cur.left);
                depthQueue.offer(depth+1);
            }else{
                min = Math.min(min,depth);
                max = Math.max(max,depth);
            }
        }
        return max-min<=1;
    }
}
