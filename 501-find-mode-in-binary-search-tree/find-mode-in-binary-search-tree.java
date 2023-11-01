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
    ArrayList<Integer> list = new ArrayList<>();
    int maxLen = 0;
    int currLen = 0;
    int currNum = 0;

    public int[] findMode(TreeNode root) {
        inOrder(root);

        int ans[] = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
 
    public void inOrder(TreeNode root) {
        if(root == null) return;
        inOrder(root.left);

        int num = root.val;
        if(num == currNum) {
            currLen++;
        } else {
            currNum = num;
            currLen = 1;
        }

        if(maxLen < currLen) {
            list = new ArrayList<>();
            maxLen = currLen;
        }

        if(maxLen == currLen) {
            list.add(num);
        }

        inOrder(root.right);
    } 
}