/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans;
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < levelSize; i++) {
                TreeNode curr = q.peek();
                q.remove();
                max = Math.max(max, curr.val);

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            ans.add(max);
        }
        return ans;
    }
}
