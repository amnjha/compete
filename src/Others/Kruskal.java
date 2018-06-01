package Others;

import java.util.*;

public class Kruskal
{
	public static class IDTree
	{
		public IDTree parent = this;
		public int index;

		public IDTree getId()
		{
			if(this.parent == this)
				return this;

			this.parent = this.parent.getId();

			return this.parent;
		}

		public void setId(IDTree node)
		{
			this.parent = node.getId();
		}
	}

	public static class Edge
	{
		public int from;
		public int to;
	}

	public static List<Edge> path = new ArrayList<Edge>();
	public static int[][] A;
	public static int infinity = 9999999;
	public static IDTree[] ID;
	public static int count = 0;

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the number of vertices: ");
		int n = in.nextInt();
		A = new int[n][n];
		ID = new IDTree[n];

		for(int i = 0;i < n;i++)
		{
			ID[i] = new IDTree();
			ID[i].index = i;
			for(int j = 0;j < n;j++)
			{
				//System.out.println("Enter the distance from vertex "+i+" to vertex "+j);
				A[i][j] = in.nextInt();
			}
		}	
		System.out.println("The minimum cost of a spanning tree in this is ");
		System.out.println(Krskal());

	}

	public static int Krskal()
	{
		findpath();
		int answ = 0;
		for(int i = 0;i < path.size();i++)
		{
			System.out.println(path.get(i).from+" >> "+path.get(i).to+" "+ID[path.get(i).from].getId()+" "+ID[path.get(i).to].getId());
			answ += A[path.get(i).from][path.get(i).to];
		}
		return answ;	
	}
	
	public static void findpath()
	{
		Edge temp=new Edge();
		if(path.size() > 0)
		{ 
			int tempval;
			tempval = path.get(path.size() - 1).from;
			temp.from = tempval;
			tempval = path.get(path.size() - 1).to;
			temp.to = tempval;

			tempval = 99999;
			for(int i = 0;i < A.length;i++)
				for(int j = 0;j < A.length;j++)
				{
					System.out.println(path.get(path.size() - 1).from+" "+path.get(path.size() - 1).to);
					System.out.println("("+A[i][j]+" < "+tempval+") && ("+A[i][j]+" >= "+A[temp.from][temp.to]+") && ("+ID[i].getId()+" != "+ID[j].getId()+")");
					if((A[i][j] < tempval) && (A[i][j] >= A[temp.from][temp.to]) && (ID[i].getId() != ID[j].getId()))
					{
						temp.from = i;
						temp.to = j;
						tempval = A[i][j];
					} 
				}

			if(temp.from > temp.to)
			{
				ID[temp.from].setId(ID[temp.to]);
			}	
			else
				ID[temp.to].setId(ID[temp.from]);

			System.out.println("adding vertices "+temp.from+" and "+temp.to);
			path.add(temp);
			System.out.println(path.get(path.size() - 1).from+" >> "+path.get(path.size() - 1).to+" "+ID[path.get(path.size() - 1).from].getId()+" "+ID[path.get(path.size() - 1).to].getId());
			count++;
			if(count != (A.length - 1))
				findpath();
		}
		else
		{
			System.out.println(" for first time ");
			temp.from = 0;
			temp.to = 0;
			int tempval = 99999;
			for(int i = 0;i < A.length;i++)
				for(int j = 0;j < A.length;j++)
				{
					System.out.println("("+A[i][j]+" < "+tempval+") && ("+A[i][j]+" <= "+A[temp.from][temp.to]+") && ("+ID[i].getId()+" != "+ID[j].getId()+")");
					if((A[i][j] < tempval) && (A[i][j] <= A[temp.from][temp.to]) && (ID[i].getId() != ID[j].getId()))
					{
						temp.from = i;
						temp.to = j;
						tempval = A[i][j];
					} 
				}

			if(temp.from > temp.to)
			{
				ID[temp.from].setId(ID[temp.to]);
			}	
			else
				ID[temp.to].setId(ID[temp.from]);

			System.out.println("adding vertices "+temp.from+" and "+temp.to);
			path.add(temp);
			System.out.println(path.get(path.size() - 1).from+" >> "+path.get(path.size() - 1).to+" "+ID[path.get(path.size() - 1).from].getId()+" "+ID[path.get(path.size() - 1).to].getId());
			count++;
			if(count != (A.length - 1))
				findpath();
		}
	}
}