class Solution {
   public int shipWithinDays(int[] weights, int days) {
   
        int min = 0;
        int max = 0;

        // Find minimum and maximum capacity
        for (int w : weights) {
            min = Math.max(min, w);
            max += w;
        }

        // Binary Search
        while (min <= max) {

            int mid = min + (max - min) / 2;

            int requiredDays = calculateDays(weights, mid);

            if (requiredDays <= days) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }

    public int calculateDays(int[] weights, int capacity) {

        int days = 1;
        int currentWeight = 0;

        for (int w : weights) {

            if (currentWeight + w > capacity) {
                days++;
                currentWeight = 0;
            }

            currentWeight += w;
        }

        return days;
    }
}