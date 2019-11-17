/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0 , nums.length-1);
    }
    
     public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end){
         if(end<start){return null;}
         if(end==start){
             return new TreeNode(nums[start]);
         }
         int idx =start, max = nums[start];
         for(int i=start+1;i<=end;i++){
             if(nums[i]>max){
                 max = nums[i];
                 idx = i;
             }
         }
         TreeNode  node = new TreeNode(nums[idx]);
         node.left = constructMaximumBinaryTree(nums, start, idx-1);
         node.right = constructMaximumBinaryTree(nums, idx+1, end);
         return node;
     }
}