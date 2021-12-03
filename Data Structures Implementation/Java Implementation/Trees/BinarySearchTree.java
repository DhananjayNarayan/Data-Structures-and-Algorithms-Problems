public class BinarySearchTree {

	TreeNode root;
	
	private class TreeNode{
		private int data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(int data) {
			this.data = data;
		}

		public TreeNode() {
			data = 0;
		}
		
		
		
	}
	
	public void insert(int data) {
		TreeNode temp,ptr;
		temp = new TreeNode();
		temp.data = data;
		
		if(root == null) {
			root = temp;
		}
		else {
			ptr = root;
			while(ptr!=null) {
				if(data>ptr.data) {
					if(ptr.right==null) {
						ptr.right = temp;
						break;
					}
					else {
						ptr = ptr.right;
					}
				}
				else if(data<ptr.data) {
					if(ptr.left==null) {
						ptr.left = temp;
						break;
					}
					else {
						ptr=ptr.left;
					}
				}
				else {
					System.out.println("No Duplicates Allowed");
				}
			}
		}
		
	}
	
	public void traverse() {
		System.out.println("Inorder:");
		inOrder(root);
		System.out.println("\nPreOrder:");
		preOrder(root);
		System.out.println("\nPostOrder:");
        postOrder(root);
	}
	
	private void postOrder(TreeNode node) {
		// TODO Auto-generated method stub
		if(node==null)
			return;
		else
		{
			postOrder(node.left);			
			postOrder(node.right);
			System.out.print(node.data+" ");
		}
	}

	private void preOrder(TreeNode node) {
		// TODO Auto-generated method stub
		if(node==null)
			return;
		else
		{   System.out.print(node.data+" ");
			preOrder(node.left);
			
			preOrder(node.right);
		}
	}

	private void inOrder(TreeNode node) {
		// TODO Auto-generated method stub
		if(node==null)
			return;
		else
		{
			inOrder(node.left);
			System.out.print(node.data+" ");
			inOrder(node.right);
		}
	  
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(60);
		bst.insert(25);
		bst.insert(90);
		bst.insert(50);
		
		bst.traverse();

	}

}
