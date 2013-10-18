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

public class Prereq 
{

	static boolean[] status;
	static LinkedList[] adjacency;
	static int time=0;
	static int fin[];
	static int nvertex;
	public static void dfs(int v)
	{
		status[v]=true;
		
		for(int i=0;i<adjacency[v].size();i++)
		{
			int u=adjacency[v].get(i);
			if(status[u]==false)
			{
				dfs(u);
			}
		}
		time++;
		fin[nvertex-time+1]=v;
		//System.out.println(v);
	}
	
	public static void topsort()
	{
		for(int i=0;i<adjacency.length;i++)
		{
			status[i]=false;
			fin[i]=-99;
		}
		time=0;
		
		for(int i=0;i<adjacency.length;i++)
		{
			if(status[i]==false)
				dfs(i);
		}
	}
	
	/*public static int[] getindegree()
	{
		int []indegree=new int[adjacency.length];
		
		for(int i=0;i<indegree.length;i++)
			indegree[i]=0;
		
		for(int i=0;i<adjacency.length;i++)
		{	
			//indegree[i]+=1;
			for(int j=0;j<adjacency[i].size();j++)
			{
				int temp=adjacency[i].get(j);
				indegree[temp]+=1;
			}
				
		}
		
		for(int i=0;i<indegree.length;i++)
			System.out.println("Vertex "+i+" "+indegree[i]);
		
		return indegree;
	}*/
	
	public static int longestchain()
	{
		int n=adjacency.length;
		int max=0;
		int length[]=new int[n];
		for(int i=0;i<length.length;i++)
		{
		
			length[i]=0;
		}
			
		
		
		for(int v:fin)
		{
			for(int i=0;i<adjacency[v].size();i++)
			{
				if(adjacency[v].get(0)==0)
					length[v]=1;
				int incoming=adjacency[v].get(i);
				if (length[incoming] < length[v] + 1) {
					length[incoming] = length[v] + 1;
					max = Math.max(max, length[incoming]);
				}
			}
		}
		
		return max;		
	}
	
	
	public static void main(String args[])
		{
			Scanner input=new Scanner(System.in);
			nvertex=input.nextInt();
			
			int nedges=0;
			adjacency=new LinkedList[nvertex+1];
			status=new boolean[nvertex+1];
			fin=new int[nvertex+1];
			
			for(int i=0;i<nvertex+1;i++)
			{
				adjacency[i]=new LinkedList();
			}		
			
			for(int i=0;i<nvertex;i++)
			{
				int vertex=input.nextInt();
				adjacency[i].add(vertex);
				if(vertex==0)
					{
					continue;
					}
				int edge=input.nextInt();
				while(edge!=0)
				{
					nedges++;
					adjacency[i].add(edge);
					edge=input.nextInt();
				}
			
			}
			
			/*for(int i=0;i<adjacency.length;i++)
			
				{
				adjacency[i].printList();
				System.out.println();
				}*/
			
			topsort();
			System.out.println(longestchain());

	}

}
