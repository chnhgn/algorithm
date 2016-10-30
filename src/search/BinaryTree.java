package search;

public class BinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {12,76,35,22,16,48,90,46,9,40};
		BinaryTree bt = new BinaryTree(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			bt.insert(bt, arr[i]);
		}

		// Print the tree with different orders
		System.out.println("This is the preOrder:");
		bt.preOrder(bt);
		
		System.out.println("This is the midOrder:");
		bt.midOrder(bt);
		
		System.out.println("This is the postOrder:");
		bt.postOrder(bt);
		
		// Find some node
		System.out.println("=======================");
		int result = bt.preOrderSearch(bt, 90);
		System.out.println("The searching node is:" + result);
		
	}

	public BinaryTree left;		// Left branch
	
	public BinaryTree right;	// Right branch
	
	public int value;			// Node value
	
	public BinaryTree(int v) {
		value = v;
	}
	
	/**
	 * Insert the node to construct the binary tree
	 * @param root
	 * @param key
	 */
	public void insert(BinaryTree root, int key) {
		if (root != null) {
			if (key > root.value) {		// Greater than the root value
				if (root.right == null) {
					root.right = new BinaryTree(key);
				} else {
					insert(root.right, key);	// Regards the right node as the root node and continue to construct
				}
			} else {					// Less or equal than the root value
				if (root.left == null) {
					root.left = new BinaryTree(key);
				} else {
					insert(root.left, key);
				}
			}
		}
	}
	
	/**
	 * Root first
	 * @param root
	 */
	public void preOrder(BinaryTree root) {
		if (root != null) {
			System.out.println(root.value);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	/**
	 * Root second
	 * @param root
	 */
	public void midOrder(BinaryTree root) {
		if (root != null) {
			midOrder(root.left);
			System.out.println(root.value);
			midOrder(root.right);
		}
	}

	/**
	 * Root last
	 * @param root
	 */
	public void postOrder(BinaryTree root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.value);
		}
	}

	/**
	 * Search the target value with the preOrder
	 * @param root
	 * @param target
	 */
	public int preOrderSearch(BinaryTree root, int target) {
		int f = -1;
		if (root != null) {
			if (root.value == target) {		// Find the target node
				System.out.println(root.value);
				return root.value;
			}
			f = preOrderSearch(root.left, target);
			f = preOrderSearch(root.right, target);
		}
		
		return f;		// Does not find the target
	}
	
}
