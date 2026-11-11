class Solution {
    
    public int nthUglyNumber(int n) {
    PriorityQueue<Long> pq = new PriorityQueue<>();
    HashSet<Long> set = new HashSet<>();

    pq.add(1L);
    set.add(1L);

    long num = 1;

    for (int i = 0; i < n; i++) {
        num = pq.poll();

        if (set.add(num * 2)) {
            pq.add(num * 2);
        }

        if (set.add(num * 3)) {
            pq.add(num * 3);
        }

        if (set.add(num * 5)) {
            pq.add(num * 5);
        }
    }

    return (int) num;
}
}