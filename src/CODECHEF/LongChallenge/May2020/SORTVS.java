package CODECHEF.LongChallenge.May2020;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.ArrayList;
//import java.util.*;

public class SORTVS {

	private static Reader in = new Reader();

	private static int position[];
	private static Set<Integer>[] nodeSet;
	private static boolean[] existing;

	public static void main(String[] args) throws IOException {
		int T = in.nextInt();

		while (T-- > 0) {
			System.out.println(solve());
		}
	}

	private static int solve() throws IOException {
		int N = in.nextInt();
		int M = in.nextInt();
		position = new int[N];
		existing = new boolean[N];
		nodeSet = new HashSet[N];
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		int result = 0;

		for (int i = 0; i < N; i++) {
			position[i] = in.nextInt() - 1;
			nodeSet[i] = new HashSet<>();
			map.put(position[i], i);
		}

		for (int i = 0; i < M; i++) {
			int x = in.nextInt() - 1;
			int y = in.nextInt() - 1;
			nodeSet[x].add(y);
			nodeSet[y].add(x);
		}

		for (int i = 0; i < N; i++) {
			if (!existing[i]) {
				dfsTreeTraverse(i, list);
				int t = search(list);
				if (t > 0)
					t--;
				result += t;
				list.clear();
			}
		}
		return result;
	}

	static void dfsTreeTraverse(int n, List<Integer> list) {
		list.add(n);
		if (existing[n])
			return;
		existing[n] = true;
		int next = position[n];
		if (next == n)
			return;

		dfsTreeTraverse(next, list);
	}

	private static int search(List<Integer> list) {
		int t = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			int node1 = list.get(i);
			int node2 = list.get(i + 1);
			if (nodeSet[node1].contains(node2))
				continue;
			t += 1;
		}
		return t;
	}

	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			}
			while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}
}