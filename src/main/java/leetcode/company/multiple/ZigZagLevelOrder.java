package leetcode.company.multiple;

import java.util.*;

/**
 * LeetCode - 103 - Binary Tree Zigzag level order traversal
 */
public class ZigZagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);
        boolean reverseFlag = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelRecords = new ArrayList<>();
            Stack<Integer> reverseRecords = new Stack<>();
            for(int i = 0; i<size; i++) {
                TreeNode node = queue.poll();
                if(!reverseFlag) {
                    levelRecords.add(node.val);
                } else {
                    reverseRecords.add(node.val);
                }
                if(node.left != null ) queue.add(node.left);
                if(node.right != null ) queue.add(node.right);
            }
            while(!reverseRecords.isEmpty()) {
                levelRecords.add(reverseRecords.pop());
            }
            reverseFlag = !reverseFlag;
            result.add(levelRecords);
        }
        return result;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
