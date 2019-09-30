// 66. Plus One
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int acc = 1;
        int n = digits.size();
        for(int i = n-1; i >= 0; i--)
        {
            digits[i] = digits[i] + acc;
            acc = digits[i] / 10;
            if(acc == 0)
                return digits;
            digits[i] %= 10;
        }
        // if(acc == 1)
            digits.insert(digits.begin(), 1);
        return digits;
    }
};