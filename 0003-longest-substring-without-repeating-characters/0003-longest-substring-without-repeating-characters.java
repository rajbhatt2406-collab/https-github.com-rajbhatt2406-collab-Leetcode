class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max = 1;
        int n = s.length();
        if(n == 0){
            return 0;
        }
        int i =0; 
        for(int j =i+1 ; j<n; j++){
            for(int k = i; k<j; k++){
                if(s.charAt(k) == s.charAt(j)){
                    i = k+1;
                    break;
                }
            }
            max = Math.max( max , j-i +1);

        }
        return max;
    }
}