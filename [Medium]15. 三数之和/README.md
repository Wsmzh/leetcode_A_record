# 15. 三数之和

## Java

```Java
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        // 数组排序
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<vector<int>> res;
        for(int i = 0 ; i < n ; i ++){
            // 对target - nums[i]计算twosum
            vector<vector<int>> tuples = twoSumTarget(nums, i + 1, -nums[i]);
            // 如果存在满足条件的二元组，再加上nums[i]就是结果三元组
            for(vector<int>& tuple : tuples){
                tuple.push_back(nums[i]);
                res.push_back(tuple);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while(i < n - 1 && nums[i] == nums[i + 1]) i ++;
        }
        return res;
    }

    //从nums[start]开始，找所有和为target的二元组
    vector<vector<int>> twoSumTarget(vector<int>& nums, int start, int target){
        vector<vector<int>> res;
        //左指针从start开始，其他不变
        int lo = start, hi = nums.size() - 1;
        while(lo < hi){
            int sum = nums[lo] + nums[hi];
            int left = nums[lo];
            int right = nums[hi];
            if(sum < target){
                while(lo < hi && nums[lo] == left) lo ++;
            } else if(sum > target){
                while(lo < hi && nums[hi] == right) hi --;
            } else if(sum == target){
                res.push_back({left, right});
                while(lo < hi && nums[lo] == left) lo ++;
                while(lo < hi && nums[hi] == right) hi --;
            }
        }
        return res;
    }
};
```