# 18. 四数之和

## Java

```Java
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        return nSumTarget(nums, 4, 0, target);
    }

    vector<vector<int>> nSumTarget(vector<int>& nums, int n, int start, long long int target){
        int sz = nums.size();
        vector<vector<int>> res;
        if(n < 2 || sz < n) return res;
        // 如果n==2，那么就是2sum的那一套
        if(n == 2){
            int lo = start, hi = sz - 1;
            while(lo < hi){
                long long int sum = nums[lo] + nums[hi];
                int left = nums[lo], right = nums[hi];
                if(sum > target) {
                    while(lo < hi && nums[hi] == right) hi --;
                } else if(sum < target) {
                    while(lo < hi && nums[lo] == left) lo ++;
                } else if(sum == target){
                    res.push_back({left, right});
                    while(lo < hi && nums[hi] == right) hi --;
                    while(lo < hi && nums[lo] == left) lo ++;
                }
            }
        } else {
            // n > 2时，递归计算(n-1)Sum的结果
            for(int i = start ; i < sz ; i ++){
                vector<vector<int>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for(vector<int>& arr : sub){
                    arr.push_back(nums[i]);
                    res.push_back(arr);
                }
                while(i < sz - 1 && nums[i] == nums[i + 1]) i++;
            }
        }

        return res;
    }
};
```