package leetcode.M_133_CloneGraph;

import java.util.List;

public class Node {

    public int val;

    public List<Node> neighbors;

    public Node(int val){};

    public Node(int _val, List<Node> _neighbors) {

        val = _val;
        neighbors = _neighbors;

    }

}
