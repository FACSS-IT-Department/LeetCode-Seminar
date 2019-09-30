// 167. Two Sum II - Input array is sorted
class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int lo = 0;
        int hi = numbers.size() - 1;
        
        while(lo < hi)
        {
            if(target == numbers[lo] + numbers[hi])
                return {++lo , ++hi};
            else if(target > numbers[lo] + numbers[hi])
                ++lo;
            else    // target < numbers[lo] + numbers[hi]
                --hi;
        }
        return {};
    }
};
