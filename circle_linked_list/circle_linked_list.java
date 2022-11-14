package circle_linked_list;

import java.util.Scanner;

public class circle_linked_list {
	static class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	Node head=null;
	Node tail=null;
	Scanner sc=new Scanner(System.in);
	public void insertAtStart()
	{
		int data,n;
		do
		{
			System.out.print("Enter Data ");
			data=sc.nextInt();
			Node new_node=new Node(data);
			if(head==null)
			{
				head=new_node;
				tail=new_node;
				new_node.next=head;
			}
			else
			{
				new_node.next=head;
				tail.next=new_node;
				head=new_node;
			}
			System.out.print("Press 1 For Insert ");
			n=sc.nextInt();
		}while(n==1);
	}
	public void insertAtEnd()
	{
		int data,n;
		do
		{
			System.out.print("Enter Data ");
			data=sc.nextInt();
			Node new_node=new Node(data);
			tail.next=new_node;
			new_node.next=head;
			tail=new_node;
			System.out.print("1 For Insert ");
			n=sc.nextInt();
		}while(n==1);
	}
	public void insertAtIndex()
	{
		int data,index,n,length=0;
		do
		{
			System.out.print("Enter Data ");
			data=sc.nextInt();
			System.out.print("Enter Index ");
			index=sc.nextInt();
			Node temp=head;
			while(length!=index-1)
			{
				temp=temp.next;
				length++;
			}
			Node new_node=new Node(data);
			new_node.next=temp.next;
			temp.next=new_node;
			if(new_node.next==head)
			{
				tail=new_node;
			}
			System.out.print("1 For Insert ");
			n=sc.nextInt();
		}while(n==1);
	}
	public void deleteAtStart()
	{
		if(head==null)
		{
			System.out.print("List Null ");
		}
		else
		{
			System.out.print("Deleted Item "+head.data);
			if(head==tail)
			{
				head=tail=null;
			}
			else
			{
				head=head.next;
				tail.next=head;
			}
		}
	}
	public void deleteAtEnd()
	{
		if(head==null)
		{
			System.out.print("List Null");
		}
		else
		{
			if(head==tail)
			{
				deleteAtStart();
			}
			else
			{
				Node temp=head;
				while(temp.next!=tail)
				{
					temp=temp.next;
				}
				System.out.print("Deleted Item "+tail.data);
				temp.next=tail.next;
				tail=temp;
			}
		}
	}
	public void deleteAtIndex()
	{
		int index,length=0;
		System.out.print("Enter Index");
		index=sc.nextInt();
		if(head==tail || index==1)
		{
			deleteAtStart();
		}
		else
		{
			Node temp=head;
			Node prev=null;
			while(length!=index-1)
			{
				prev=temp;
				temp=temp.next;
				length++;
			}
			System.out.print("Deleted Item "+temp.data);
			if(temp==tail)
			{
				tail=prev;
			}
			prev.next=temp.next;
		}
	}
	public void traversal()
	{
		if(head==null)
		{
			System.out.print("List Null");
		}
		else
		{
			Node temp=head;
			do
			{
				System.out.print(temp.data+" ");
				temp=temp.next;
			}while(temp!=tail.next);
		}
	}
	public static void main(String args[])
	{
		circle_linked_list cl=new circle_linked_list();
		Scanner sc=new Scanner(System.in);
		int c;
		cl.insertAtStart();
		while(true)
		{
			System.out.print("\n1 For Insert At Start \n");
			System.out.print("2 For Insert At End \n");
			System.out.print("3 For Insert At Index \n");
			System.out.print("4 For Display \n");
			System.out.print("5 For Delete At Start \n");
			System.out.print("6 For Delete At End \n");
			System.out.print("7 For Delete At Index \n");
			c=sc.nextInt();
			if(c==1)
			{
				cl.insertAtStart();
			}
			else if(c==2)
			{
				cl.insertAtEnd();
			}
			else if(c==3)
			{
				cl.insertAtIndex();
			}
			else if(c==4)
			{
				cl.traversal();
			}
			else if(c==5)
			{
				cl.deleteAtStart();
			}
			else if(c==6)
			{
				cl.deleteAtEnd();
			}
			else if(c==7)
			{
				cl.deleteAtIndex();
			}
			else
			{
				break;
			}
		}
	}
}
