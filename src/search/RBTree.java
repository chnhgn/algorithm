package search;

/**
 * Importance:
 * The implementation of the Red-Link red/black tree may have
 * a different black height with the implementation of the
 * Red-Point red/black tree
 * @param <T>
 */
public class RBTree<T extends Comparable<T>> {

	public static void main(String[] args) {
		RBTree<String> tree = new RBTree<String>();
		String arr[] = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R"};
		String arr2[] = new String[]{"S", "E", "A", "R", "C", "H", "X", "M", "P", "L"};
		for (String str : arr2) {
			tree.insert(str);
		}
		
		tree.preOrder(tree.root);
	}

	public static final boolean RED = true;
	public static final boolean BLACK = false;
	public RBNode<T> root;
	
	public RBTree() {
		root = null;
	}
	
	public static class RBNode<T>{
		private T key;
		private RBNode<T> left, right;
		private boolean color;		// The color can be regarded as the link color to its parent.
		
		public RBNode(T k, RBNode<T> l, RBNode<T> r, boolean c) {
			this.key = k;
			this.left = l;
			this.right = r;
			this.color = c;
		}
	}
	
	
	public void insert(T key){
		root = insert(root, key);
		root.color = BLACK;		// To make sure the root node color is black.
	}
	
	private RBNode<T> insert(RBNode<T> node, T key){
		
		if (node == null) {
			return new RBNode<T>(key, null, null, RED);
		}
		
		int result = key.compareTo(node.key);
		if (result < 0) {	// The insert key is less than the root value
			node.left = insert(node.left, key);
		} else if (result > 0) {	// The insert key is great than than the root value
			node.right = insert(node.right, key);
		} else {	// The insert key is equal to root value
			// Do nothing
		}
		
		if (!isRed(node.left) && isRed(node.right)) {	// Left is black link and right is red link
			node = leftRotate(node);
		}
		if (isRed(node.left) && isRed(node.left.left)) {	// Left is red and its left child is also red
			node = rightRotate(node);
		}
		if (isRed(node.left) && isRed(node.right)) {	// Both sides are red
			node.left.color = BLACK;
			node.right.color = BLACK;
			node.color = RED;
		}
		
		return node;
	}
	
	private RBNode<T> rightRotate(RBNode<T> node) {
		RBNode<T> x = node.left;
		x.color = node.color;
		node.left = x.right;
		node.color = RED;
		x.right = node;
		return x;
	}

	private RBNode<T> leftRotate(RBNode<T> node) {
		RBNode<T> x = node.right;
		x.color = node.color;
		node.right = x.left;
		node.color = RED;
		x.left = node;
		return x;
	}

	public boolean isRed(RBNode<T> node){
		if (node == null) {
			return false;
		}
		return node.color == RED;
	}
	
	
	public void preOrder(RBNode<T> node){
		if (node != null) {
			preOrder(node.left);
			System.out.println("["+node.key+" : "+node.color+"]");
			preOrder(node.right);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
