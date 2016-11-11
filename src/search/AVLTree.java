package search;

public class AVLTree<T extends Comparable<T>> {

	private AVLNode<T> root;	// The tree root node
	
	public AVLTree() {
		root = null;	// An empty tree
	}
	
	private static class AVLNode<T>{	// Tree node
		
		public AVLNode(T element) {
			this(element, null, null);
		}
		
		private AVLNode(T element, AVLNode<T> lt, AVLNode<T> rt) {
			theElement = element;
			left = lt;
			right = rt;
			height = 0;
		}
		
		public T theElement;		// Data
		public AVLNode<T> left;		// Left child		
		public AVLNode<T> right;	// Right child
		public int height;			// Node height
	}
	
	public void insert(T x){		// Insert the element on the specified root tree
		root = insert(x, root);
	}
	
	private int height(AVLNode<T> t)  
    {  
        return t == null ? -1 : t.height;  
    }
	
	private AVLNode<T> insert(T x, AVLNode<T> t){
		if (t == null) return new AVLNode<T>(x);
		
		int result = x.compareTo(t.theElement);
		if (result < 0) {				// The element will be in the left branch
			t.left = insert(x, t.left);	
			if (height(t.left) - height(t.right) == 2) {		// Balance factor(deviation) is 2 will trigger the re-order
				if (x.compareTo(t.left.theElement) < 0) {		// LL
					t = rotateWithLeftChild(t);
				} else {										// LR
					t = doubleRotateWithLeftChild(t);
				}
			}
		} else if (result > 0) {		// The element will be in the right branch
			t.right = insert(x, t.right);
			if (height(t.left) - height(t.right) == 2) {		// Balance factor(deviation) is 2 will trigger the re-order
				if (x.compareTo(t.left.theElement) > 0) {		// RR
					t = rotateWithRightChild(t);
				} else {										// RL
					t = doubleRotateWithRightChild(t);
				}
			}
		} else {						// The element equals the root node
			// Do thing for now
		}
		
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		
		return t;
	}
	
	
	/**
	 * LL
	 * @param t
	 * @return
	 */
	private AVLNode<T> rotateWithLeftChild(AVLNode<T> t) {
		AVLNode<T> latest = t.left;
		t.left = latest.right;
		latest.right = t;
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		latest.height = Math.max(height(latest.left), height(t)) + 1;
		return latest;
	}

	/**
	 * RR
	 * @param t
	 * @return
	 */
	private AVLNode<T> rotateWithRightChild(AVLNode<T> t) {
		AVLNode<T> latest = t.right;
		t.right = latest.left;
		latest.left = t;
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		latest.height = Math.max(height(latest.right), height(t)) + 1;
		return latest;
	}

	/**
	 * LR
	 * @param t
	 * @return
	 */
	private AVLNode<T> doubleRotateWithLeftChild(AVLNode<T> t) {
		// The long side should be rotated firstly
		t.left = rotateWithRightChild(t.left);
		t = rotateWithLeftChild(t);
		return t;
	}
	
	/**
	 * RL
	 * @param t
	 * @return
	 */
	private AVLNode<T> doubleRotateWithRightChild(AVLNode<T> t) {
		// The long side should be rotated firstly
		t.right = rotateWithLeftChild(t.right);
		t = rotateWithRightChild(t);
		return t;
	}

	/**
	 * Root first print
	 * @param node
	 */
	public void preOrder(AVLNode<T> node) {
		if (node != null) {
			System.out.println(node.theElement);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	

	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<Integer>();
		for (int i = 20; i > 0; i--) {
			tree.insert(i);
		}
		
		tree.preOrder(tree.root);
	}

	
	
	
	
	
	
	
}
