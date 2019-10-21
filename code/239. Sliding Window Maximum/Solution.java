package com.LeetCodeProblems;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 1) {
            return nums;
        }

        // initialize
        int len = nums.length;
        int[] result = new int[len - k + 1];
        int[] deque = new int[len];
        int head = 0, tail = -1;
        deque[++tail] = 0;

        // build deque
        for (int i = 1; i < len; i++) {
            while (head <= tail && nums[deque[tail]] < nums[i]) {
                tail--;
            }
            deque[++tail] = i;
            if (deque[head] < i - k + 1) {
                head++;
            }
            if (i >= k - 1) {
                result[i - k + 1] = deque[head];
            }
        }

        // convert index to value
        for (int i = 0; i < len - k + 1; i++) {
            result[i] = nums[result[i]];
        }

        return result;
    }
}
