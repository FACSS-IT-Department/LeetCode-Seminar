# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Codec:

    def serialize(self, root: TreeNode) -> List[int]:
        """
        Encodes a tree to a single string.
        T(n) = O(n) -- traversed each node exactly once
        S(n) = O(n) -- deque used
        """
        arr = []
        if root is None:
            return arr
        dq = deque([root])
        while dq:
            node = dq.popleft() # TreeNode
            if node is None:
                arr.append(None) # None == null
            else:
                arr.append(node.val)
                dq.append(node.left)
                dq.append(node.right)
        return arr

    def deserialize(self, data: List[int]) -> TreeNode:
        """
        Decodes your encoded data to tree.
        T(n) = O(n) -- traversed each node exactly once
        S(n) = O(n) -- deque used
        """
        if data is None or len(data) == 0:
            return None
        root = TreeNode(data[0])
        dq = deque([root])
        i = 1
        while dq and i < len(data):
            node = dq.popleft()
            if data[i] is not None:
                node.left = TreeNode(data[i])
                dq.append(node.left)
            i += 1
            if data[i] is not None:
                node.right = TreeNode(data[i])
                dq.append(node.right)
            i += 1
        return root

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
