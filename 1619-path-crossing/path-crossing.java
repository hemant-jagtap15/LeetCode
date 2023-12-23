class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0; // for E and W
        int y = 0; // for N and S
        int n = path.length();
        HashSet<String> set = new HashSet<>();
        set.add("0,0");

        for (int i = 0; i < n; i++) {
            char ch = path.charAt(i);

            if (ch == 'N') {
                y += 1;
            } else if (ch == 'S') {
                y -= 1;
            } else if (ch == 'E') {
                x += 1;
            } else if (ch == 'W') {
                x -= 1;
            }

            String curr = x + "," + y;

            if (set.contains(curr)) {
                return true;
            }

            set.add(curr);
        }

        return false;
    }
}
