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
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        preOrder(root, map);
        int maxFreq = 0;
        for(Integer key : map.keySet()) {
            maxFreq = Math.max(maxFreq, map.get(key));
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer key : map.keySet()) {
            if(map.get(key) == maxFreq) list.add(key);
        }
        int ans[] = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public void preOrder(TreeNode root, HashMap<Integer, Integer> map) {
        if(root == null) return;
        preOrder(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        preOrder(root.right, map);
    } 
}