class Solution {
    public String reorganizeString(String s) {

    HashMap<Character, Integer> map = new HashMap<>();
    String ans = "";

    for (char ch : s.toCharArray()) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> pq =
        new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );

    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        pq.offer(entry);
    }

    while (!pq.isEmpty()) {

        Map.Entry<Character, Integer> current = pq.poll();

        char ch = current.getKey();
        int freq = current.getValue();

        if (ans.length() > 0 &&
            ans.charAt(ans.length() - 1) == ch) {

            if (pq.isEmpty()) {
                return "";
            }

            Map.Entry<Character, Integer> next = pq.poll();

            char c = next.getKey();
            int fre = next.getValue();

            ans += c;
            fre--;

            if (fre > 0) {
                next.setValue(fre);
                pq.offer(next);
            }

            pq.offer(current);

        } else {

            ans += ch;
            freq--;

            if (freq > 0) {
                current.setValue(freq);
                pq.offer(current);
            }
        }
    }

    return ans;
}
}