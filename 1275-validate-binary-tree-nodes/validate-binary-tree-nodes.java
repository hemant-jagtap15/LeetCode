class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if(root == -1) return false;
        HashSet<Integer> vis = new HashSet<>();
        Stack<Integer> s = new Stack<>();
        vis.add(root);
        s.push(root);

        while(!s.isEmpty()) {
            int node = s.pop();
            int children[] = {leftChild[node], rightChild[node]};

            for(int child : children) {
                if(child != -1) {
                    if(vis.contains(child)) {
                        return false;
                    }
                    s.push(child);
                    vis.add(child);
                }
            }
        }
        return vis.size() == n;
    }

    public int findRoot(int n, int left[], int right[]) {
        HashSet<Integer> children = new HashSet<>();
        for (int node : left) {
            children.add(node);
        }
        
        for (int node : right) {
            children.add(node);
        }
        
        for (int i = 0; i < n; i++) {
            if (!children.contains(i)) {
                return i;
            }
        }
        
        return -1;
    }
}