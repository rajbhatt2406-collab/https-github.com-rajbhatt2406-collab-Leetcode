class Solution {
    public int minInsertions(String s) {
    int open = 0;
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
        char a = s.charAt(i);

        if (a == '(') {
            open++;

            if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                if (i + 2 < s.length() && s.charAt(i + 2) == ')') {
                    open--;
                    i += 2;
                } else {
                    count++;
                    open--;
                    i++;
                }
            }
        } else {
            if (open > 0) {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    open--;
                    i++;
                } else {
                    count++;
                    open--;
                }
            } else {
                count++;

                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    count++;
                }
            }
        }
    }

    count += open * 2;
    return count;
}
}