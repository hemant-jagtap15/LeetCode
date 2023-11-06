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
    public int longestZigZag(TreeNode root) {
        int maxSteps[] = new int[1];
        dfs(root, true, 0, maxSteps);
        dfs(root, false, 0, maxSteps);
        return maxSteps[0];
    }

    public void dfs(TreeNode root, boolean left, int steps, int maxSteps[]) {
        if(root == null) return;
        maxSteps[0] = Math.max(maxSteps[0], steps);
        if(left) {
            dfs(root.left, false, steps+1, maxSteps);
            dfs(root.right, true, 1, maxSteps);
        } else {
            dfs(root.left, false, 1, maxSteps);
            dfs(root.right, true, steps+1, maxSteps);
        }
    }
}