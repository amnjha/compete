package hackerearth;

import java.util.*;

public class Segment {

	static int n,Q;

	static long[] seg_tree;
	static long[] prefix_seg_tree;
	static long[] suf_seg_tree;
	static int[] A,B,C;


	static void buildTree(int i,int l,int r,long[] tree, int[] arr)
	{
		if(l == r)
			tree[i] = arr[l];
		else{
			int mid = (l+r)/2;

			buildTree(2*i+1,l,mid,tree,arr);
			buildTree(2*i+2,mid+1,r,tree,arr);

			tree[i] = tree[2*i+1] + tree[2*i+2];
		}
	}

	static long querySum(int curr,int curr_l,int curr_r,int query_l,int query_r,long[] tree)
	{
		if(query_l > curr_r || query_r < curr_l)
			return 0;
		if(curr_l >= query_l && curr_r <= query_r)
			return tree[curr];
		int mid = (curr_l + curr_r)/2;

		long ans_l = querySum(2*curr+1, curr_l, mid, query_l, query_r,tree);
		long ans_r = querySum(2*curr+2, mid+1, curr_r, query_l, query_r,tree);

		return ans_l +ans_r;
	}

	static void updateTree(int curr,int curr_l,int curr_r,int pos,int val,long[] tree)
	{
		if(curr_l == curr_r){
			tree[curr] = val;
			// System.out.println("\tchaning at position pos = "+pos+" to "+val+"curr = "+curr);
		}
		else
		{
			int mid = (curr_l + curr_r)/2;
			if(pos <= mid)
				updateTree(2*curr+1, curr_l, mid, pos, val,tree);
			else
				updateTree(2*curr+2, mid+1, curr_r, pos, val,tree);

			tree[curr]  = tree[2*curr +1] + tree[2*curr+2];
		}
	}


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		Q = in.nextInt();
		A = new int[n];
		B = new int[n];
		C = new int[n];

		for(int i = 0;i < n;i++){
			A[i] = in.nextInt();
			B[i] = A[i]*(i+1);
			C[i] = A[i] * (n-i);
		}

		seg_tree = new long[4*n];
		prefix_seg_tree = new long[4*n];
		suf_seg_tree = new long[4*n];

		buildTree(0, 0, n-1,prefix_seg_tree,A);
		buildTree(0, 0, n-1,seg_tree,B);
		buildTree(0, 0, n-1, suf_seg_tree,C);


		while(Q -- > 0)
		{
			int type = in.nextInt();
			int L = in.nextInt()-1;
			int R = in.nextInt()-1;
			if(type == 3)
			{
				updateTree(0, 0, n-1, L, (R+1),prefix_seg_tree);
				updateTree(0, 0, n-1, L, (L+1)*(R+1),seg_tree);
				updateTree(0, 0, n-1, L, (n-L)*(R+1),suf_seg_tree);
				// System.out.print("prefix_seg_tree --> "); printTree(prefix_seg_tree);
				// System.out.print("seg_tree --> "); printTree(seg_tree);
			}
			else if (type == 1){
				long prefix_sum = querySum(0, 0, n-1, L, R, prefix_seg_tree);
				long prefix_increm = querySum(0, 0, n-1, L, R, seg_tree);
				long ans = prefix_increm - (L * prefix_sum);
				System.out.println(ans);
			}
			else
			{
				long prefix_sum = querySum(0, 0, n-1, L, R, prefix_seg_tree);
				long prefix_decrem = querySum(0, 0, n-1, L, R, suf_seg_tree);
				long ans = prefix_decrem - ((n-R-1) * prefix_sum);
				System.out.println(ans);
			}
		}


	}

	static void printTree(long[] tree)
	{
		for(int i = 0;i < tree.length;i++)
			System.out.print(tree[i]+" ");
		System.out.println();
	}



}