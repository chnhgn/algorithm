package search;

public class BinaryTree<T extends Comparable<T>> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr [] = {15,5,3,12,10,6,7,13,16,20,18,23};
		BinaryTree<Integer> bt = new BinaryTree<Integer>(arr[0]);
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
		
		// Delete node
		System.out.println("[DELETE]");
		bt.preOrder(bt);
		System.out.println("-----------------------");
		bt.remove(5, bt);
		bt.preOrder(bt);
		
	}

	public BinaryTree<T> left;		// Left branch
	
	public BinaryTree<T> right;	// Right branch
	
	public T value;			// Node value
	
	public BinaryTree(T v) {
		value = v;
	}
	
	/**
	 * Insert the node to construct the binary tree
	 * @param root
	 * @param key
	 */
	public void insert(BinaryTree<T> root, T key) {
		if (root != null) {
			int result = key.compareTo(root.value);
			if (result > 0) {		// Greater than the root value
				if (root.right == null) {
					root.right = new BinaryTree<T>(key);
				} else {
					insert(root.right, key);	// Regards the right node as the root node and continue to construct
				}
			} else {					// Less or equal than the root value
				if (root.left == null) {
					root.left = new BinaryTree<T>(key);
				} else {
					insert(root.left, key);
				}
			}
		}
	}
	
	/**
	 * Search the minimum value from the given tree branch
	 * @param node
	 * @return
	 */
	public T findMin(BinaryTree<T> node) {
		if (node.left == null) return node.value;		// If the left branch is empty, the node value should be the smallest.
		return findMin(node.left);						// Else continue to search in the left branch as the recursive way.
	}
	
	/**
	 * Delete the specified tree element from the given node
	 * <p> Search the element from the tree recursively
	 * <p> If the deleting element has one or none child, if the left child is empty then replace the element with
	 * the right child. If the right child is empty then replace the element with the left child. 
	 * <p> For deleting element has two children, the left branch should be kept there
	 * and should use the minimum value in right branch to replace the element's value.
	 * Then recursively delete the minimum element.
	 * @param t
	 * @param node
	 * @return
	 */
	public BinaryTree<T> remove(T t, BinaryTree<T> node) {
		if (node == null) return null;
		
		// Find the element to be deleting
		int result = t.compareTo(node.value);
		if (result > 0) {	// Search in the right branch
			node.right = remove(t, node.right);
		} else if(result < 0) {		// Search in the left branch
			node.left = remove(t, node.left);
		} else if (node.left != null && node.right != null) {	// Found the element and the element has two children
			node.value = findMin(node.right);	// Find the minimum value of the right branch to make the value as the replacement value
			node.right = remove(node.value, node.right); // Delete the replacement element recursively
												// The left branch does not need to be changed
		} else {	// The element only has one child
			node = node.left == null?node.right : node.left;
		}
		
		return node;	// Return the whole tree structure in the memory
		
	}
	
	
	/**
	 * Root first
	 * @param root
	 */
	public void preOrder(BinaryTree<T> root) {
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
	public void midOrder(BinaryTree<T> root) {
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
	public void postOrder(BinaryTree<T> root) {
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
	public int preOrderSearch(BinaryTree<T> root, T target) {
		int f = -1;
		if (root != null) {
			if (root.value == target) {		// Find the target node
				System.out.println(root.value);
				return (int) root.value;
			}
			f = preOrderSearch(root.left, target);
			f = preOrderSearch(root.right, target);
		}
		
		return f;		// Does not find the target
	}
	
}
