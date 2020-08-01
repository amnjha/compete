package CODECHEF.LongChallenge.July2020;

import java.io.*;
import java.util.*;

public class DRGNDEN {

	private static final FastReader reader = new FastReader();
	private static final StringBuilder out = new StringBuilder();

	private static final String END_LINE = "\n";

	private static int N;
	private static int[] a;
    private static int[] h;
	private static Stack<Integer> integerStack;
	private static int[] rightParent;
    private static int[] leftParent;
	private static List<Integer>[] leftAdj;
    private static List<Integer>[] rightAdj;


    public static void leastPrimeFactor(int n)
    {
        // Create a vector to store least primes.
        // Initialize all entries as 0.
        int[] least_prime = new int[n+1];

        // We need to print 1 for 1.
        least_prime[1] = 1;

        for (int i = 2; i <= n; i++)
        {
            // least_prime[i] == 0
            // means it i is prime
            if (least_prime[i] == 0)
            {
                // marking the prime number
                // as its own lpf
                least_prime[i] = i;

                // mark it as a divisor for all its
                // multiples if not already marked
                for (int j = 2*i; j <= n; j += i)
                    if (least_prime[j] == 0)
                        least_prime[j] = i;
            }
        }

        // print least prime factor of
        // of numbers till n
        for (int i = 1; i <= n; i++)
            System.out.println("Least Prime factor of " +
                    + i + ": " + least_prime[i]);
    }

    public static void main(String[] args) throws IOException {
		N = reader.nextInt();
		int Q = reader.nextInt();

		if(N!=1){
            a = new int[N + 1];
            h = new int[N + 1];

            integerStack = new Stack<>();

            leftParent = new int[N + 1];
            leftAdj = new ArrayList[N + 1];
            leftParent[0] = -1;
            leftAdj[0] = new ArrayList<>();

            rightParent = new int[N + 1];
            rightAdj = new ArrayList[N + 1];
            rightAdj[0] = new ArrayList<>();
            rightParent[0] = -1;

            for (int i = 1; i <= N; i++) {
                h[i] = reader.nextInt();
                leftAdj[i] = new ArrayList<>();
                rightAdj[i] = new ArrayList<>();
            }

            for (int i = 1; i <= N; i++) {
                a[i] = reader.nextInt();
            }

            integerStack = new Stack<>();
            for (int i = 1; i <= N; i++) {

                while (!integerStack.isEmpty() && h[integerStack.peek()] < h[i]) {
                    int u = integerStack.pop();
                    rightParent[u] = i;
                    rightAdj[i].add(u);
                }
                integerStack.push(i);
            }

            while (!integerStack.isEmpty()) {
                int u = integerStack.pop();
                rightParent[u] = 0;
                rightAdj[0].add(u);
            }

            integerStack = new Stack<>();
            for (int i = N; i > 0; i--) {

                while (!integerStack.isEmpty() && h[integerStack.peek()] < h[i]) {
                    int u = integerStack.pop();
                    leftParent[u] = i;
                    leftAdj[i].add(u);
                }
                integerStack.push(i);
            }

            while (!integerStack.isEmpty()) {
                int u = integerStack.pop();
                leftParent[u] = 0;
                leftAdj[0].add(u);
            }

            Tree treeLeft = new Tree(leftParent, leftAdj, 0);
            Tree treeRight = new Tree(rightParent, rightAdj, 0);
            solveQueries(treeLeft, treeRight, Q);
        }
		else  {
			int A = reader.nextInt();
			int cost = reader.nextInt();
			for (int i = 0; i < Q; i++) {
				int val = reader.nextInt();
				int l = reader.nextInt();
				int r = reader.nextInt();
				if (val == 1) {
					cost = r;
				} else {
					printWithEndLine(cost);
				}
			}
		}

		System.out.println(out);
	}

	public static void printWithEndLine(Object value) {
		out.append(value).append("\n");
	}

    static int kPrimeFactor(int n, int k)
    {
        // Find the number of 2's that
        // divide k
        while (n % 2 == 0)
        {
            k--;
            n = n / 2;
            if (k == 0)
                return 2;
        }

        // n must be odd at this point.
        // So we can skip one element
        // (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i = i + 2)
        {
            // While i divides n, store i
            // and divide n
            while (n % i == 0)
            {
                if (k == 1)
                    return i;

                k--;
                n = n / i;
            }
        }

        // This condition is to handle the
        // case where n is a prime number
        // greater than 2
        if (n > 2 && k == 1)
            return n;

        return -1;
    }

    public static void solveQueries(Tree treeLeft, Tree treeRight, int Q) throws IOException {
		while (Q-- > 0) {
			int type = reader.nextInt();
			int left = reader.nextInt();
			int right = reader.nextInt();

			if (type != 1) {
				if (left == right) {
					printWithEndLine(a[right]);
					continue;
				} else if (h[left] <= h[right]) {
					printWithEndLine(-1);
					continue;
				}

				if (left < right) {
					printWithEndLine(treeLeft.find(left, right));
				} else if (right < left) {
					printWithEndLine(treeRight.find(left, right));
				} else {
					printWithEndLine(a[right]);
				}
			} else {
				treeLeft.update(left, right);
				treeRight.update(left, right);
				a[left] = right;
			}
		}
	}

	static class SgTree {
		long tree[];
		int arr[];

		SgTree(int elements[], int size) {
			this.arr = elements;

			int x = (int) (Math.ceil(Math.log(size) / Math.log(2)));
			int max_size = 2 * (int) Math.pow(2, x) - 1;
			tree = new long[max_size];
			constructTree(0, 0, size - 1);
		}

		void constructTree(int index, int left, int right) {
			if (left == right)
				tree[index] = a[arr[left]];

			else {
				int mid = left + ((right - left) / 2);
				constructTree(2 * index + 1, left, mid);
				constructTree(2 * index + 2, mid + 1, right);

				tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
			}
		}

		void restructureTree(int current, int currentLeft, int currentRight, int position, int value) {
			if (currentLeft == currentRight) {
				tree[current] = value;
			}
			else {
				int mid = currentLeft + ((currentRight - currentLeft) / 2);

				if (mid < position)
					restructureTree(2 * current + 2, mid + 1, currentRight, position, value);
				else
					restructureTree(2 * current + 1, currentLeft, mid, position, value);

				tree[current] = tree[2 * current + 1] + tree[2 * current + 2];
			}
		}

		long find(int current, int currentLeft, int currentRight, int left, int right) {
			if (right < currentLeft || left > currentRight)
				return 0;

			else if (currentRight <= right && currentLeft >= left)
				return tree[current];

			int mid = currentLeft + ((currentRight - currentLeft) / 2);

			long r = find(2 * current + 2, mid + 1, currentRight, left, right);
			long l = find(2 * current + 1, currentLeft, mid, left, right);

			return r + l;
		}
	}

    static class FastReader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
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

    static class Tree {

		Map<Integer, SgTree> segmentTrees = new HashMap<>();
		Map<Integer, List<Integer>> paths = new HashMap<>();

		List<Integer>[] adjacencyList;
		int root, currentPosition;

		int[] parent;
		int[] heavy;
		int[] depth;
		int[] top;
		int[] position;

		int[][] leastCommonAncestors;

		Tree(int[] par, List<Integer>[] adjacency, int root) {
			this.root = root;
			parent = par;
			currentPosition = 0;
			adjacencyList = adjacency;

			int l = adjacency.length;
			int defaultValue = -1;

			depth = new int[l];

			heavy = new int[l];
			Arrays.fill(heavy, defaultValue);

			position = new int[l];

			top = new int[l];
			Arrays.fill(top, defaultValue);


			leastCommonAncestors = new int[N + 1][ln(N) + 1];
			decomposeHeavyChild(0);

			paths.put(0, new ArrayList<>());

			heavyLightDecomposition(0, 0);
			findLeastCommonAncestors();
			convertPathsToSegmentTrees();
		}

		int ln(int x) {
			return (int) (Math.floor(Math.log(x) / Math.log(2)));
		}

		void update(int node, int value) {
			int nodeValue = top[node];
			SgTree tree = segmentTrees.get(nodeValue);
			tree.restructureTree(0, 0, tree.arr.length - 1, position[node], value);
			segmentTrees.put(top[node], tree);
		}

		void findLeastCommonAncestors() {
			for (int i = 0; i < leastCommonAncestors.length; i++) {
				for (int j = 0; j < leastCommonAncestors[i].length; j++) {
					leastCommonAncestors[i][j] = -1;
				}
			}

			for (int i = 1; i <= N; i++)
				leastCommonAncestors[i][0] = parent[i];

			for (int j = 1; j <= ln(N); j++) {
				for (int i = 1; i <= N; i++) {
					if (leastCommonAncestors[i][j - 1] != -1) {
						int v = leastCommonAncestors[i][j - 1];
						leastCommonAncestors[i][j] = leastCommonAncestors[v][j - 1];
					}
				}
			}
		}

		int findLeastCommonAncestor(int first, int second) {
			if (depth[first] > depth[second]) {
				int temp = first;
				first = second;
				second = temp;
			}
			int d = depth[second] - depth[first];

			while (d > 0) {
				int i = ln(d);
				second = leastCommonAncestors[second][i];
				d -= (1 << i);
			}

			if (first == second)
				return first;

			for (int i = ln(N); i >= 0; i--) {
				if (leastCommonAncestors[first][i] != -1 && leastCommonAncestors[first][i] != leastCommonAncestors[second][i]) {
					first = leastCommonAncestors[first][i];
					second = leastCommonAncestors[second][i];
				}
			}

			return parent[first];
		}

		void convertPathsToSegmentTrees() {
			for (int key : paths.keySet()) {
				List<Integer> path = paths.get(key);
				int n = path.size();

				int[] arr = new int[path.size()];
				for (int i = 0; i < path.size(); i++) {
					arr[i] = path.get(i);
				}

				segmentTrees.put(key, new SgTree(arr, n));
			}
		}

		int decomposeHeavyChild(int u) {

			int size = 1;
			int maxChildSize = 0;

			for (int i = 0; i < adjacencyList[u].size(); i++) {
				int value = adjacencyList[u].get(i);

				depth[value] = depth[u] + 1;
				int childSize = decomposeHeavyChild(value);
				size += childSize;

				if (childSize > maxChildSize) {
					maxChildSize = childSize;
					heavy[u] = value;
				}
			}

			return size;
		}

		void heavyLightDecomposition(int u, int h) {
			top[u] = h;
			position[u] = currentPosition++;

			List<Integer> path = paths.get(h);
			path.add(u);
			paths.put(h, path);

			if (heavy[u] != -1)
				heavyLightDecomposition(heavy[u], h);

			for (int child : adjacencyList[u]) {
				if (child == heavy[u])
					continue;
				currentPosition = 0;
				paths.put(child, new ArrayList<>());
				heavyLightDecomposition(child, child);
			}
		}

		long find(int left, int right) {
			int lca = findLeastCommonAncestor(left, right);
			if (lca != left)
				return -1;

			long result = 0;
			while (top[left] != top[right]) {
				if (depth[top[left]] > depth[top[right]]) {
					int temp = left;
					left = right;
					right = temp;
				}
				SgTree t = segmentTrees.get(top[right]);
				long val = t.find(0, 0, t.arr.length - 1, position[top[right]], position[right]);
				result += val;
				right = parent[top[right]];
			}

			if (depth[left] > depth[right]) {
				left = left + right;
				right = left - right;
				left = left - right;
			}

			SgTree t = segmentTrees.get(top[right]);
			long val = t.find(0, 0, t.arr.length - 1, position[left], position[right]);
			result += val;
			return result;
		}

	}

    static final int MAXN = 100001;
    static int spf[] = new int[MAXN];
    static void sieve()
    {
        spf[1] = 1;
        for (int i=2; i<MAXN; i++)
            spf[i] = i;

        for (int i=4; i<MAXN; i+=2)
            spf[i] = 2;

        for (int i=3; i*i<MAXN; i++)
        {
            if (spf[i] == i)
            {
                for (int j=i*i; j<MAXN; j+=i)

                    if (spf[j]==j)
                        spf[j] = i;
            }
        }
    }

    static Vector<Integer> getFactorization(int x)
    {
        Vector<Integer> ret = new Vector<>();
        while (x != 1)
        {
            ret.add(spf[x]);
            x = x / spf[x];
        }
        return ret;
    }
}