class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        int n = nums.size();
        unordered_map<int,int>m;
        int sum = 0;
        int ans = INT_MAX;
        m[0]=-1;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            m[sum]=i;
        }
        if(x>sum)return -1;
        if(x==sum)return n;
        sum=0;
        
        if(m.count(x))ans = m[x]+1;

        for(int i=n-1;i>=0;i--){
            int temp = x;
            sum+=nums[i];

            if(sum>temp)break;
            temp-=sum;
            if(m.count(temp))ans = min(ans,m[temp]+(n-i)+1);


        }

        if(ans==INT_MAX)return -1;
        return ans;

    }
};