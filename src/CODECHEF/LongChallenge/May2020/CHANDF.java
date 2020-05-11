package CODECHEF.LongChallenge.May2020;

import java.io.*;
import java.util.Scanner;

public class CHANDF {
	private static Reader scanner = new Reader();
	private static long x, y, l, r;
	private static final StringBuilder out = new StringBuilder();
	private static final String END_LINE  = "\n";

	public static void main(String[] args) throws IOException {
		int T = scanner.nextInt();
		while (T-- > 0) {
			solve();
		}

		System.out.println(out);
	}

	private static void solve() throws IOException {
		x = scanner.nextLong();
		y = scanner.nextLong();
		l = scanner.nextLong();
		r = scanner.nextLong();

		boolean[] K = bitSet64(l);
		boolean[] L = bitSet64(r);
		boolean[] M = bitSet64(x);
		boolean[] N = bitSet64(y);
		boolean[] arr = bitSet64(r);

		int ind = -1;

		for (int i = 63; i >= 0; --i) {
			if (L[i] && !K[i]) {
				ind = i;
				break;
			}
		}
		if (ind == -1) {
			out.append(l).append(END_LINE);
		} else if (x == 0 || y == 0) {
			out.append(l).append(END_LINE);
		} else {
			int dfPos = changeIndexPosition(ind, arr);
			if (dfPos == -2) {
				out.append(l).append(END_LINE);
			} else if (dfPos == -1) {
				out.append(toUlong(arr)).append(END_LINE);
			} else {
				arr[dfPos] = false;
				if (dfPos == ind) {
					boolean flag = false;
					for (int i = dfPos - 1; i >= 0; --i) {
						if (M[i] || N[i])
							arr[i] = true;
						else
							arr[i] = false;
						if (flag)
							continue;
						if (arr[i] && !K[i])
							flag = true;
						else
							arr[i] = K[i];
					}
				} else {
					for (int i = dfPos - 1; i >= 0; --i) {
						if (M[i] || N[i])
							arr[i] = true;
						else
							arr[i] = false;
					}
				}
				long result = manipulate(-1, arr);
				out.append(result).append(END_LINE);
			}
		}
	}

	static boolean[] bitSet64(long val) {
		String bin = Long.toBinaryString(val);
		int l = bin.length();
		boolean[] bitset = new boolean[64];
		int pos = 0;
		for (int i = l - 1; i >= 0; i--) {
			if (bin.charAt(i) == '1')
				bitset[pos] = true;
			pos++;
		}

		return bitset;
	}

	static void printBitSet(boolean[] booleans) {
		for (boolean b : booleans) {
			if (b)
				System.out.print(1);
			else
				System.out.print(0);
		}
		System.out.println();
	}

	static long toUlong(boolean[] bitset) {
		String bin = "";
		for (int i = bitset.length - 1; i >= 0; i--) {
			if (bitset[i])
				bin += 1;
			else
				bin += 0;
		}
		return Long.parseLong(bin, 2);
	}

	static long manipulate(int ind, boolean[] arr) {
		long res2 = 0;
		for (int i = 0; i < ind; i++) {
			res2 += (1L << i);
		}
		for (int i = ind + 1; i < 64; i++) {
			if (arr[i])
				res2 += (1L << i);
		}
		return res2;
	}

	static int changeIndexPosition(int ind, boolean[] arr) {
		long res = 0;
		int j = -2;
		for (int i = ind; i >= -1; i--) {
			if (i > 0 && !arr[i])
				continue;
			long res1 = manipulate(i, arr);
			long res2 = (y & res1) * (x & res1);
			if (res2 > res) {
				res = res2;
				j = i;
			}
		}
		return j;
	}

	static class Reader
	{
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader()
		{
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException
		{
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException
		{
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1)
			{
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException
		{
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do
			{
				ret = ret * 10 + c - '0';
			}  while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException
		{
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

		public double nextDouble() throws IOException
		{
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

			if (c == '.')
			{
				while ((c = read()) >= '0' && c <= '9')
				{
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException
		{
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException
		{
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException
		{
			if (din == null)
				return;
			din.close();
		}
	}

}
