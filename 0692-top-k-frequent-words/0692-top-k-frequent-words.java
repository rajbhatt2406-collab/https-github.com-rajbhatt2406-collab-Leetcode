class Solution {
   public List<String> topKFrequent(String[] words, int k) {

  
    HashMap<String, Integer> map = new HashMap<>();

    for (String w : words)
        map.put(w, map.getOrDefault(w, 0) + 1);

    PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
        if (!map.get(a).equals(map.get(b)))
            return map.get(a) - map.get(b);
        return b.compareTo(a);
    });

    for (String w : map.keySet()) {
        pq.add(w);
        if (pq.size() > k)
            pq.poll();
    }

    List<String> ans = new ArrayList<>();

    while (!pq.isEmpty())
        ans.add(pq.poll());

    Collections.reverse(ans);
    return ans;
}
}