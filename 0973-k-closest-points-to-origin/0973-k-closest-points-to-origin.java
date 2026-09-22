class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[2], a[2])
        );

        for (int[] point : points) {

            int x = point[0];
            int y = point[1];

            int distance = x * x + y * y;

            pq.offer(new int[]{x, y, distance});

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {

            int[] point = pq.poll();

            ans[i][0] = point[0];
            ans[i][1] = point[1];
        }

        return ans;
    }
}