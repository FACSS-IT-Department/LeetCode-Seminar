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
    public TreeNode bstToGst(TreeNode root) {
        inOrder(root, 0);
        return root;
    }
    
    private int inOrder(TreeNode node, int sum){
        if(node==null){return sum;}
        node.val+=(inOrder(node.right, sum));
        return inOrder(node.left, node.val);
    }
    
}