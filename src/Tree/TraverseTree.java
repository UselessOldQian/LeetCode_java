package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Qian
 * @create 2021-04-304:35 下午
 */
public class TraverseTree {
    List<Integer> ans = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            ans.add(cur.val);
            cur = cur.right;

        }
        return ans;
    }
}
