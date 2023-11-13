class Solution {
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    } 

    public String sortVowels(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        Queue<Character> q = new LinkedList<>();
        ArrayList<Character> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(isVowel(s.charAt(i))) {
                arr.add(s.charAt(i));
            }
        }
        Collections.sort(arr);

        for(int i = 0; i < arr.size(); i++) {
            q.add(arr.get(i));
        }

        for(int i = 0; i < n; i++) {
            if(isVowel(s.charAt(i))) {
                sb.setCharAt(i, q.peek());
                q.remove(); 
            }
        }
        return sb.toString();
        
    }
}