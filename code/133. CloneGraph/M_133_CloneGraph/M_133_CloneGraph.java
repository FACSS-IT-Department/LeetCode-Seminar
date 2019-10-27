package leetcode.M_133_CloneGraph;

import java.util.*;

/**
 *Time: O(V+E)
 *Space: O(V)
 */
public class M_133_CloneGraph {

    //我们需要复制，HashMap比较好，完全可以当HashSet来用，其值存复制的点(Node, Copy)
    public Node cloneGraph1(Node node) {
        if(node == null) {
            return null;
        }
        return helper(node, new HashMap<>());
    }

    public Node helper(Node node, HashMap<Node, Node> map) {
        List<Node> neighbors = new ArrayList<>();
        Node copy = new Node(node.val, neighbors);
        map.put(node,copy);
        for(Node neighbor : node.neighbors) {
            if(!map.containsKey(neighbor)) {
                neighbors.add(helper(neighbor, map));
            } else {
                //边是双向的,所以需要1---2 和2----1
                neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    public Node cloneGraph2(Node node) {
        if(node == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            //初始化
            map.get(cur).neighbors = new ArrayList<>();
            for (Node neighbor : cur.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    public static void main(String[] args) {

    }
}
