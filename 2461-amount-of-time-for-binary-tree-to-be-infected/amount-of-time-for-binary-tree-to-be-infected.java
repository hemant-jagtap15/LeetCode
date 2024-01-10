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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, HashSet<Integer>> adj = new HashMap<>();
        preOrder(root, adj);
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        q.add(start);
        vis.add(start);
        int minutes = 0;
        while(!q.isEmpty()) {
            int unvisited = 0;
            int size = q.size();
            while(size > 0) {
                int node = q.remove();
                HashSet<Integer> childs = adj.get(node);
                for(int child : childs) {
                    if(!vis.contains(child)) {
                        q.add(child);
                        vis.add(child);
                        unvisited++;
                    }
                }
                size--;
            }
            if(unvisited > 0) minutes++;
        }
        
        return minutes;
    }

    public void preOrder(TreeNode root, HashMap<Integer, HashSet<Integer>> adj) {
        if(root == null) return;
        if(!adj.containsKey(root.val)) {
            adj.put(root.val, new HashSet<>());
        }
        if(root.left != null) {
            adj.get(root.val).add(root.left.val);
            if(!adj.containsKey(root.left.val)) {
                adj.put(root.left.val, new HashSet<>());
            }
            adj.get(root.left.val).add(root.val);
        }
        if(root.right != null) {
            adj.get(root.val).add(root.right.val);
            if(!adj.containsKey(root.right.val)) {
                adj.put(root.right.val, new HashSet<>());
            }
            adj.get(root.right.val).add(root.val);
        }

        preOrder(root.left, adj);
        preOrder(root.right, adj);
    }
}