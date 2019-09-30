// 415. Add Strings
class Solution {
public:
    string addStrings(string num1, string num2) {
        string res = "";
        int acc = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        while(i >= 0 || j >= 0 || acc != 0)
        {
            if(i >= 0)
                acc += num1[i--] - '0';
            if(j >= 0)
                acc += num2[j--] - '0';
            res = to_string(acc % 10) + res;
            acc /= 10;
        }
        return res;
    }
};