package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Qian
 * @create 2021-06-193:46 下午
 */
public class LeverOrderTraverse {
        public static void main(String[] args) {
            TreeNode t7 = new TreeNode(7);
            TreeNode t15 = new TreeNode(15);
            TreeNode t20 = new TreeNode(20,t15,t7);
            TreeNode t9 = new TreeNode(9);
            TreeNode t3 = new TreeNode(3,t9,t20);
            System.out.println(levelOrder(t3));
        }
        public static List<Integer> rawAns = new ArrayList();

        static public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            if(root == null)
                return res;
            Queue<TreeNode> queue = new LinkedList<>();
            Queue<Integer> depth = new LinkedList();
            queue.offer(root);
            depth.offer(0);
            while(!queue.isEmpty()){
                root = queue.poll();
                int d = depth.poll();
                while(res.size()<=d){
                    res.add(new ArrayList());
                }
                res.get(d).add(root.val);
                if(root.left != null){
                    queue.offer(root.left);
                    depth.offer(d);
                }
                if(root.right != null){
                    queue.offer(root.right);
                    depth.offer(d);
                }
            }
            return res;
//            traversal(root, 1);
//            List<List<Integer>> ans = new ArrayList<List<Integer>>();
//            int depth = 0;
//             while(true){
//                 List<Integer> depthAns = new ArrayList<Integer>();
//                 for(int i = (int)Math.pow(2,depth);i<(int)Math.pow(2,depth+1)-1;i++){
//                     if(i>=rawAns.size()){
//                         ans.add(depthAns);
//                         return ans;
//                     }
//                     depthAns.add(rawAns.get(i-1));
//                 }
//                 ans.add(depthAns);
//                 depth++;
//             }
        }

        static public void traversal(TreeNode root, int index) {
            if (root == null)
                return;
            while (rawAns.size() < index) {
                rawAns.add(rawAns.size(), null);
            }
            rawAns.set(index - 1, root.val);
            traversal(root.left, index * 2);
            traversal(root.right, index * 2 + 1);
        }
}
