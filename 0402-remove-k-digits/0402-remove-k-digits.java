
class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();

        for (char ch : num.toCharArray()) {

            while (!st.isEmpty() && k > 0 && st.peek() > ch) {
                st.pop();
                k--;
            }

            st.push(ch);
        }

        
        while (k > 0) {
            st.pop();
            k--;
        }

        
        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.remove(0));
        }

        int i = 0;
        while (i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }

        String result = ans.substring(i);

        return result.isEmpty() ? "0" : result;
    }
}
