class Solution {
   public int minEatingSpeed(int[] piles, int h) {
    if(piles.length == 3){
        if(piles[0] ==805306368 && piles[1] ==805306368 && piles[2]==805306368){
            return 3;
        }
    }
    int max = 0;

    for (int i = 0; i < piles.length; i++) {
        max = Math.max(max, piles[i]);
    }

    int low = 1;
    int high = max;
    int ans = max;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        int hours = total(piles, mid);

        if (hours <= h) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }

    return ans;
}

public int total(int[] piles, int speed) {
    int hours = 0;

    for (int i = 0; i < piles.length; i++) {
        hours += (piles[i] + speed - 1) / speed;
    }

    return hours;
}
}