class Solution {
    public String smallestSubsequence(String s) {
        int n = s.length();
        int lastApper[] = new int[26];
        boolean vis[] = new boolean[26];
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            lastApper[ch - 'a'] = i;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(s.charAt(0) - 'a');
        vis[s.charAt(0) - 'a'] = true;

        for(int i = 1; i < n; i++) {
            int curr = s.charAt(i) - 'a';
            if(vis[curr]) continue;

            while(!stack.isEmpty() && stack.peek() > curr && i < lastApper[stack.peek()]) {
                vis[stack.peek()] = false;
                stack.pop();
            }

            stack.push(curr);
            vis[curr] = true;
        }

        StringBuilder sb = new StringBuilder("");
        while(!stack.isEmpty()) {
            sb.append((char) (stack.peek() + 'a'));
            stack.pop();
        }

        return sb.reverse().toString();
    }
}