package linkedlist;

class Linked{
	
	private class Node{
		int data;
		Node next;
		
		public Node() {
			this.data = 0;
			this.next = null;
		}
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	Node head;
	
	public void insertBeg(int data) {
		Node node = new Node(data);
		
		node.next = head;
		head = node;
	}
	
	public void insert(int data) {
		Node node = new Node(data);
		if(head==null) {
			head = node;
		}
		else {
			Node n = head;
			while(n.next!=null) {
				n = n.next;
			}
			n.next = node;
		}
	}
	
	public void insertAt(int index,int data) {
		Node node = new Node(data);
		
		if(index==0) {
			insertBeg(data);
		}
		else
		{
			Node n = head;
			for(int i=0;i<index-1;i++) {
				n=n.next;
			}
			node.next = n.next;
			n.next = node;
		}
	}
	
	public void show() {
		if(head == null) {
			System.out.println("Empty");
		}
		else {
			Node n = head;
			while(n!=null) {
				System.out.print(n.data+" --> ");
				n = n.next;
			}
			System.out.print("null");
			System.out.println();
		}
	}
	
	public void deleteAt(int index) {
		if(index==0) {
			head=head.next;
		}
		else {
			Node n = head;
			for(int i=0;i<index-1;i++) {
				n=n.next;
			}
			Node n1 = n.next;
			n.next = n1.next;
			n1=null;
		}
	}
	
	public int size() {
		int count =0;
		if(head == null) {
			return 0;
		}
		else {
			Node n = head;
			while(n!=null) {
				count++;
				n=n.next;
			}
		}
		return count;
	}
	
	public boolean contains(int search) {
		
			Node n = head;
			while(n!=null) {
				if(n.data==search) {
					System.out.println("Found");
					return true;
				}
				n=n.next ;
			}
		
		System.out.println("Not Found");
		return false;
	}
}
public class SingleLinkedList {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linked ll = new Linked();
		ll.insert(10);
		ll.insert(25);
		ll.insert(35);
		ll.insertBeg(100);
		
		ll.show();
		System.out.println(ll.size());
		ll.insertAt(1, 5);
		ll.show();
		System.out.println(ll.size());
		ll.deleteAt(1);
		ll.show();
		System.out.println(ll.size());
		
		ll.contains(10);
		ll.contains(600);

	}

}
