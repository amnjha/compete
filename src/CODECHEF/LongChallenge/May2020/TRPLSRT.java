package CODECHEF.LongChallenge.May2020;

import java.util.*;
import java.io.*;

class TRPLSRT {
	static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(new
					InputStreamReader(System.in));
		}

		String next()
		{
			while (st == null || !st.hasMoreElements())
			{
				try
				{
					st = new StringTokenizer(br.readLine());
				}
				catch (IOException  e)
				{
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt()
		{
			return Integer.parseInt(next());
		}
	}

	private static FastReader fastReader = new FastReader();

	public static void main(String[] args) {
		int T = fastReader.nextInt();
		while (T-- > 0) {
			solve();
		}
	}

	private static void solve() {
		int N = fastReader.nextInt();
		fastReader.nextInt();

		Map<Integer, Integer> valueMap = new HashMap<>();
		Map<Integer, Integer> sortedMap = new HashMap<>();

		List<Integer> position = new ArrayList();
		boolean[] visited = new boolean[N];

		List<List<Integer>> even = new ArrayList<>();
		List<List<Integer>> odd = new ArrayList<>();
		List<List<Integer>> both = new ArrayList<>();

		List<Integer> i1 = new ArrayList<>();
		List<Integer> i2 = new ArrayList<>();
		List<Integer> i3 = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int k = fastReader.nextInt();
			position.add(k);
			valueMap.put(k, i);
		}
		List<Integer> sortedPosition = new ArrayList<>(position);
		Collections.sort(sortedPosition);

		for (int i = 0; i < N; i++) {
			sortedMap.put(sortedPosition.get(i), i);
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i])
				findParent(i, sortedMap, position, visited, even, odd, both);
		}
		if (!((even.size() + both.size()) % 2 == 0)) {
			System.out.println(-1);
			return;
		}

		for (List<Integer> list : odd) {
			find(list, i1, i2, i3, both);
		}

		for (List<Integer> list : even) {
			find(list, i1, i2, i3, both);
		}
		for (int i = 0; i < both.size(); i += 2) {
			int a = both.get(i).get(0);
			int b = both.get(i).get(1);

			int c = both.get(i + 1).get(0);
			int d = both.get(i + 1).get(1);

			i1.add(a);
			i2.add(b);
			i3.add(c);

			i1.add(c);
			i2.add(a);
			i3.add(d);
		}

		System.out.println(i1.size());
		for (int i = 0; i < i1.size(); i++) {
			int num1 = i1.get(i);
			int num2 = i2.get(i);
			int num3 = i3.get(i);
			System.out.println((++num1) + " " + (++num2) + " " + (++num3));
		}
	}

	static void findParent(int u, Map<Integer, Integer> sortedMap, List<Integer> position, boolean[] visited, List<List<Integer>> even, List<List<Integer>> odd, List<List<Integer>> both) {
		if (sortedMap.get(position.get(u)) == u) {
			visited[u] = true;
			return;
		}

		List<Integer> temp = new ArrayList<>();
		while (!visited[u]) {
			visited[u] = true;
			temp.add(u);
			u = sortedMap.get(position.get(u));
		}

		if (temp.size() == 2)
			both.add(temp);
		else if (temp.size() % 2 == 0)
			even.add(temp);
		else
			odd.add(temp);

	}


	static void find(List<Integer> list, List<Integer> I1, List<Integer> I2, List<Integer> I3, List<List<Integer>> both) {
		int p = 0;
		int k = 3;
		while (p <= list.size() - k) {
			int i1 = list.get(p);
			int i2 = list.get(p + 1);
			int i3 = list.get(p + 2);
			I1.add(i1);
			I2.add(i2);
			I3.add(i3);
			list.set(p + 2, list.get(p));
			p += 2;
		}
		if (p == list.size() - 1)
			return;
		List<Integer> tmp = new ArrayList<>();
		tmp.add(list.get(p));
		tmp.add(list.get(p + 1));
		both.add(tmp);
	}


}