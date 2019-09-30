// 414. Third Maximum Number
class Solution {
public:
    int thirdMax(vector<int>& nums) {
        long big = LONG_MIN;
        long mid = LONG_MIN;
        long sml = LONG_MIN;
        
        for(int i = 0; i < nums.size(); i++)
        {
            if(nums[i] > big) {
                sml = mid;
                mid = big;
                big = nums[i];
            }
            else if(nums[i] > mid && nums[i] < big) {
                sml = mid;
                mid = nums[i];
            }
            else if(nums[i] > sml && nums[i] < mid) {
                sml = nums[i];
            }
        }
        
        if(sml == LONG_MIN)
            return big;
        return sml;
    }
};
