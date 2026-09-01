class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        return count(p,s);
    }
    public List<Integer> count(String s1, String s2){
        ArrayList<Integer> list = new ArrayList<>();
        if (s1.length() > s2.length()) return list;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {

            char c = s2.charAt(right);
            map.put(c, map.getOrDefault(c, 0) - 1);

            if (right - left + 1 > s1.length()) {
                char x = s2.charAt(left++);
                map.put(x, map.get(x) + 1);
            }

            if (map.values().stream().allMatch(x -> x == 0)){
                list.add(left);
            }
               
        }

        return list;
    }
    
}