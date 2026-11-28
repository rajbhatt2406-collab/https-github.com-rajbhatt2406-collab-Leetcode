class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int max =0;
        
        for(int i=0; i<pairs.length;i++){
            int b = pairs[i][1];
            int count =0;
            for(int j=i+1; j<pairs.length ; j++){
                if(b < pairs[j][0] ){
                    b = pairs[j][1];
                    count +=1;
                }
            }
            max = Math.max(count,max);
        }
        return max +1;
    }
}