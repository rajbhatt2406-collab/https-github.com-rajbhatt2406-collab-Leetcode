class Solution {
    public int findMinArrowShots(int[][] points) {
         int n = points.length;
        int count = 0;

        Arrays.sort(points, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        int end = points[0][1];

        for (int i = 1; i < n; i++) {

            if (points[i][0] <= end) {
                count++;
            } 
            else {
                end = points[i][1];
            }
        }
        int ans = n-count;
        return ans ;
    }
}