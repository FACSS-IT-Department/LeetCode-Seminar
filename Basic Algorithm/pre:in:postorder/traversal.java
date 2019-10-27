package data_structure;

import java.util.LinkedList;
import java.util.Queue;

public class traversal {
	public class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int v){
			this.value=v;
			this.left=null;
			this.right=null;
		}

	}
	
	void preOrder(Node root) {
		if(root != null) {
			System.out.print(root.value);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	void inOrder(Node root) {
		if(root != null) {
			inOrder(root.left);
			System.out.print(root.value);
			inOrder(root.right);
		}
	}
	
	void postOrder(Node root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.value);
		}
	}
	
	void levelOrder(Node root) {
		if(root == null) {
			return;
		}
		Queue <Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			Node a = q.poll();
			System.out.print(a.value);
			if(a.left!=null)q.add(a.left);
			if(a.right!=null)q.add(a.right);
		}
		
	}
	Node init() {
		Node root = new Node(0);
		root.value = 5;
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.right.left = new Node(6);
		root.right.right = new Node(9);
		return root;
	}
	public static void main(String[] args) {
		traversal T = new traversal();
		Node root = T.init();
		System.out.println("preorder");
		T.preOrder(root);
		System.out.println('\n'+"inorder");
		T.inOrder(root);
		System.out.println('\n'+"postorder");
		T.postOrder(root);
		System.out.println('\n'+"levelorder");
		T.levelOrder(root);
		
	}
}
