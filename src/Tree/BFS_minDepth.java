package Tree;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Qian
 * @create 2021-04-2012:33 下午
 */
public class BFS_minDepth {
    static int minDepth(TreeNode root) {
        //DFS
        // if(root == null){return 0;}
        // if(root.left == null && root.right == null){
        //     return 1;
        // }
        // int min = Integer.MAX_VALUE;
        // if(root.left != null){
        //     min =  Math.min(minDepth(root.left)+1,min);
        // }
        // if(root.right != null){
        //     min = Math.min(minDepth(root.right)+1,min);
        // }
        // return min;

        //BFS
        if(root == null){return 0;}
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while(!queue.isEmpty()){
            QueueNode queueNode = queue.poll();
            TreeNode treeNode = queueNode.treeNode;
            if(treeNode.left == null && treeNode.right==null){
                return queueNode.depth;
            }

            if(treeNode.left != null){queue.offer(new QueueNode(treeNode.left, queueNode.depth + 1));}
            if(treeNode.right != null){queue.offer(new QueueNode(treeNode.right, queueNode.depth + 1));}
        }
        return 0;
    }

    static class QueueNode{
        TreeNode treeNode;
        int depth;

        public QueueNode(TreeNode treeNode,int depth){
            this.treeNode = treeNode;
            this.depth = depth;
        }
    }
}
