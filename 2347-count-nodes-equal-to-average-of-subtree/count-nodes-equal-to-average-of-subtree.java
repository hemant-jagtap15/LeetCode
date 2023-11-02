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
    public int averageOfSubtree(TreeNode root) {
        int ans[] = new int[1];
        inorder(root, ans);
        return ans[0];
    }

    public void inorder(TreeNode root, int ans[]) {
        if(root == null) return;
        inorder(root.left, ans);
        int count = countNodes(root);
        int sum = sumNodes(root);
        int avg = sum / count;
        ans[0] += root.val == avg ? 1 : 0;
        inorder(root.right, ans);
    }

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftCount = countNodes(root.left);
        int rightCount = countNodes(root.right);
        return leftCount + rightCount + 1;
    }

    public int sumNodes(TreeNode root) {
        if(root == null) return 0;
        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);
        return leftSum + rightSum + root.val;
    }
}