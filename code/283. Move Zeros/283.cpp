// 283. Move Zeroes

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int i;
        int j;
        
        // method 1
        for (i = 0; i < nums.size(); i++)
        {
            if(nums[i] != 0)
            {
                nums[j] = nums[i];
                j++;
            }
        }
        while(j < nums.size())
        {
            nums[j] = 0;
            j++;
        }
        
        // method 2
        /*  // since we won't use i'th number in the array, we can just put that place to "0"
        for(int i = 0; i < nums.size(); i++)
        {
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        */
    }
};
