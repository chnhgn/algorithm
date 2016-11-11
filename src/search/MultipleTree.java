package search;

import java.util.ArrayList;

public class MultipleTree {

	private TreeNode root;
	
	public MultipleTree() {
		root = new TreeNode("0", "0");
	}
	
	public void insert(String p, String s){
		root = insert(p, s, root);
	}
	
	private TreeNode insert(String p, String s, TreeNode t){
		
		if (p.equals(t.self)) {
			TreeNode node = new TreeNode(t.self, s);
			t.children.add(node);
			return t;
		} else {
			for (TreeNode child : t.children) {
				t = insert(p, s, child);
			}
		}
		
		return t;
	}
	
	public static class TreeNode
	{
		public String parent;
		public String self;
		public ArrayList<TreeNode> children = new ArrayList<TreeNode>();
		public TreeNode(String p, String s) {
			parent = p;
			self = s;
		}
	}
	
	/**
	 * Root first print
	 * @param node
	 */
	public void preOrder(TreeNode node){
		if (node != null) {
			System.out.println(node.self);
			for (TreeNode child : node.children) {
				preOrder(child);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		
		MultipleTree tree = new MultipleTree();
		tree.insert("0", "EDMT");
		tree.insert("0", "CCD");
		tree.insert("CCD", "John");
		tree.insert("CCD", "Wang");
		tree.insert("EDMT", "Eddy");
		tree.insert("EDMT", "Michael");
		
		tree.preOrder(tree.root);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
