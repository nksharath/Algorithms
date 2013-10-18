/*
 * Sharath Navalpakkam Krishnan sxn9447@rit.edu
 * Rahul Nuggehalli Gopinathan  rnn4511@rit.edu
 * 
 */

import java.util.Scanner;

class Node
{
	Node next;
	Node previous;
	int data;	
	
}

class LinkedList 
{
	Node head=null;
	Node tail=null;
	Node temp=null;
	int counter=0;
	
	public int size()
	{
		return counter;
	}
	
	public void add(int element)
	{
		if(head==null)
		{
			head=new Node();
			tail=new Node();
			head.data=element;
			head.next=tail;
			tail=head;
		}
		
		else
		{
			tail.next=new Node();
			tail=tail.next;
			tail.data=element;
			
		}
		counter++;
	}
	
	public void add(int element,int index)
	{
		if(index==size())
		{
			add(element);
			return;
		}
		else
		{
			if(index==0)
			{
				Node temp=new Node();
				temp.data=element;
				temp.next=head;
				head.previous=temp;
				head=temp;
				counter++;
				return;
			}
			
			temp=head;
			
			for(int i=0;i<index;i++)
				temp=temp.next;
			
			Node insert=new Node();
			insert.data=element;
			insert.next=temp.next;
			temp.next=insert;
			counter++;
		}
		
	}
	
	public int get(int index)
	{
		if(index<0 || index>size())
			return -1;
		else
		{
			temp=head;
			for(int i=0;i<index;i++)
				temp=temp.next;
			
			return temp.data;
		}
	}
	
	
	public int remove(int index)
	{
		assert((index>=0 && index<size()));
		
		temp=head;
		
		if(index==0)
		{
			int element=head.data;
			head=head.next;
			counter--;
			return element;
		}
		
		else if(index==size())
		{
			int element=tail.data;
			tail=tail.previous;
			counter--;
			return element;
		}
		else
		{
			for(int i=0;i<index-1;i++)
			{
				temp=temp.next;
			}
			int element=temp.next.data;
			temp.next=temp.next.next;
			counter--;
			return element;
			
		}
		
		
	}
	
	void printList()
	{
		Node n=head;
		while(n!=null)
		{
			System.out.print(n.data+"  ");
			n=n.next;
		}
	}
	
			
	
	void reverse()
	{
		Node left=head;
		Node current=head.next;
		Node right=head.next.next;
		
		left.next=null;
		while(right!=null)
		{
			current.next=left;
			left=current;
			current=right;
			right=right.next;
		}		
		current.next = left;
		head = current;
	}
}

public class Cycle 
{

	static boolean status[];
	static LinkedList[] adjacency;
	//static Stack stack=new Stack();
	static int color[];
	static int parent[];
	static int depth=0;
	
	public static void cycledetect()
	{
		for(int i=0;i<adjacency.length;i++)
		{
			color[i]=1;
			parent[i]=-1;
			
		}
		
		depth=0;
		
		for(int i=0;i<adjacency.length;i++)
		{
			if(color[i]==1)
				visit(i);
			
		}
	}
	
	public static void visit(int u)
	{
		color[u]=2;
		for(int v=0;v<adjacency[u].size();v++)
		{
			int val=adjacency[u].get(v);
			if(color[val]==2 && val!=parent[u])
			{
				parent[val]=u;
				print(val);
			}
			if(color[val]==1)
			{
				parent[val]=u;
				visit(val);
			}
		}
		color[u]=3;
	}
	
	public static void print(int v)
	{
		System.out.println("YES");
		int w=v;
		do
		{
			w=parent[w];
			System.out.print(w+" ");
			
		}while(w!=v);
		System.exit(1);
	}
	
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		int nvertex=input.nextInt();
		int nedge=input.nextInt();
		int root;
		//System.out.println(nvertex+" "+nedge);
		int max=(nvertex>nedge)?nvertex:nedge;
		adjacency=new LinkedList[nvertex+nedge];
		color=new int[adjacency.length];
		parent=new int[adjacency.length];
		
		
		for(int i=0;i<nvertex+nedge;i++)
		{
			adjacency[i]=new LinkedList();
		}
		
		for(int i=0;i<nedge;i++)
		{
			int vertex=input.nextInt();
			if(i==0)
				root=vertex;
			int edge=input.nextInt();
			//System.out.println(vertex+" "+edge);
			adjacency[vertex].add(edge);
			
			adjacency[edge].add(vertex);
			
		}
		
		//adjacency[1].printList();
		
		/*for(int i=0;i<nvertex;i++)
		{
			adjacency[i].printList();
			System.out.println();
		}*/
		
		cycledetect();
		
		System.out.println("NO");
		
		input.close();
		
		
	}

}
