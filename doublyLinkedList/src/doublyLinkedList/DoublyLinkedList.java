package doublyLinkedList;
import java.util.Scanner;

public class DoublyLinkedList {
	
	private class Node {
		private int data;
		private Node prev,next;
		
		public Node(int val){
			data = val;
		}
	}
	

	private Node head;
	
	
	public DoublyLinkedList(Node head){
		this.head = head;
	}
	public DoublyLinkedList(){}
	
	
	public void push(int newData){
		Node newNode = new Node(newData);
		newNode.next = head;
		newNode.prev = null;
		 if (head != null)
	            head.prev = newNode;
	        head = newNode;
	}
	
	public void append(int newData){
		Node newNode = new Node(newData);
		Node last = head;
		newNode.next = null;
		
		if(head == null){
			newNode.prev =null;
			head = newNode;
			return;
		}
		
		while(last.next !=null)	last = last.next;
		last.next = newNode;
		newNode.prev = last;
	}
	
	public void insertAfter(Node prevNode, int newData){
		if(prevNode==null){
			System.out.println("Previous node cannot be null");
			return;
		}
		Node newNode = new Node(newData);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
		newNode.prev = prevNode;
		
		if(newNode.next != null){
			newNode.next.prev = newNode;
		}
	}
	
	public void printListForward(Node node){
		
		if(node == null){
			System.out.println("List is empty");
			return;
			}
		System.out.println("Traversal in forward Direction");
		while(node !=null){
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	public void printListBackward(Node node){
		if(node == null){
			System.out.println("List is empty");
			return;
		}
		Node last = null;
		while(node !=null){
			last=node;
			node = node.next;
		}
        System.out.println("Traversal in reverse direction");
        while(last != null){
        	 System.out.print(last.data + " ");
             last = last.prev;
        }
        System.out.println();
	}
	
	 void deleteNode(Node del){
	        if (head == null || del == null)	return;
	        
	        if (head == del)	head = del.next;
	       
	        if (del.next != null) {
	            del.next.prev = del.prev;
	        }
	        if (del.prev != null) {
	            del.prev.next = del.next;
	        }
	 
	        return;
	    }
	
	public static void main(String[] args)
    {
        
		DoublyLinkedList dll = new DoublyLinkedList();
		Scanner sc = new Scanner(System.in);
		
		while(true){
			int choice,value;
			Node n,temp;
			System.out.println("What do you want to do?");
			System.out.println("1. Insert at the beginning");
			System.out.println("2. Insert at the end");
			//System.out.println("3. Insert after element");
			/*System.out.println("Enter the Element");
				int p = sc.nextInt();
				System.out.println("Enter the Value");
				value = sc.nextInt();
				n = dll.head;
				while(n.data !=p || n.next !=null){
					n=n.next;
					//Getting null pointer exception here
				}
				dll.insertAfter(n, value);
				break;*/
			System.out.println("4. Print list forward");
			System.out.println("5. Print list backward");
			System.out.println("6. Delete Element");
			System.out.println("7. Find Element");
			System.out.println("8. Exit");
			//try{
			//	choice = sc.nextInt();
			//}catch(Exception e){
			//	System.out.println("Enter only a number");
			//}
			choice = sc.nextInt();
			
			switch(choice){
			case 1:
				System.out.println("Enter the Value");
				value = sc.nextInt();
				dll.push(value);
				break;
			case 2:
				System.out.println("Enter the Value");
				value = sc.nextInt();
				dll.append(value);
				break;
			case 3:
				
			case 4:
				dll.printListForward(dll.head);
				break;
			case 5:
				dll.printListBackward(dll.head);
				break;
			case 6:
				System.out.println("Enter the Value");
				value = sc.nextInt();
				n = dll.new Node(value);
				temp = dll.head;
				while(n.data != temp.data){
					temp=temp.next;
				}
				dll.deleteNode(temp);
				break;
			case 7:
				System.out.println("Enter the Value");
				value = sc.nextInt();
				System.out.println("Element is at positon: ");
				n = dll.new Node(value);
				temp = dll.head;
				int position =1;
				if(n.data == dll.head.data)	System.out.print("1\n");
				else{
					while(n.data !=temp.data){
						temp=temp.next;
						position++;
					}
					System.out.print(position+'\n');
				}
				break;
			case 8:
				sc.close();
				return;
			default:
				System.out.println("Incorrect input. Try again!");
			}
		}
    }

}
