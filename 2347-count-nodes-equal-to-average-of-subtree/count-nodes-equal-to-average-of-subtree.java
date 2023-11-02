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
    class Pair {
        int sum;
        int count;
        Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        int ans[] = new int[1];
        postorder(root, ans);
        return ans[0];
    }

    public Pair postorder(TreeNode root, int ans[]) {
        if(root == null) return new Pair(0, 0);
        Pair p1 = postorder(root.left, ans);
        Pair p2 = postorder(root.right, ans);
        int count = p1.count + p2.count + 1;
        int sum = p1.sum + p2.sum + root.val;
        int avg = sum / count;
        ans[0] += root.val == avg ? 1 : 0;
        return new Pair(sum, count);
        
    }
}