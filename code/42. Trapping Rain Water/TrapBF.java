import java.lang.Math;

class Solution {
    
    /**
    * T(n) = O(n^2) -- n*(n/2+n/2)
    * S(n) = O(1) -- no extra sapce used
    */
    public int trapBruteForce(int[] height) {
        if (height.length <= 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = i; j >= 0; j--)
                leftMax = Math.max(leftMax, height[j]);
            for (int j = i; j < height.length; j++)
                rightMax = Math.max(rightMax, height[j]);
            ans += Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }
}