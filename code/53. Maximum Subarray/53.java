class Solution {
    public int maxSubArray(int[] nums) {
        int currMax = nums[0];
        int maxValue = nums[0];
        
        for(int n = 1; n < nums.length; n++){
            currMax = Math.max(nums[i], nums[i]+currMax);
            maxValue = Math.max(currMax, maxValue);
        }
        
        
        return maxValue;
        
    }
}

