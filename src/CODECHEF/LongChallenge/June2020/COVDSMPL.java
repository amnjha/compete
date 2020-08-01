package CODECHEF.LongChallenge.June2020;

import java.util.*;

public class COVDSMPL {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		while (T-- > 0) {
			solve2();
			int X = sc.nextInt();
			if (X == -1) {
				return;
			}
		}
	}

	private static void solve2(){
		int N = sc.nextInt();
		int P = sc.nextInt();

		int[][] mat = new int[N][N];
		find(new Partition(1, 1, N, N), mat);

		System.out.println(2);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println(mat[i][N - 1]);
		}
	}

	private static int find(Partition p, int[][] mat) {
		System.out.println(1 + " " + p.r1 + " " + p.c1 + " " + p.r2 + " " + p.c2);
		int expected = sc.nextInt();
		int found = 0;


		if (p.r1 == p.r2 && p.c1 == p.c2) {
			mat[p.r1 - 1][p.c1 - 1] = expected;
			return expected;
		} else {
			if (expected == 0)
				return 0;

			int numElements = ((p.r2 - p.r1) + 1) * ((p.c2 - p.c1) + 1);
			if (expected == numElements) {
				fill(p, mat);
				return expected;
			}

			List<Partition> partitions = divide(p.r1, p.c1, p.r2, p.c2);
			for (Partition partition : partitions) {
				found += find(partition, mat);
				if (found == expected)
					return found;
			}
		}

		return found;
	}

	private static List<Partition> divide(int r1, int c1, int r2, int c2) {
		List<Partition> partitions = new ArrayList<>();

		if (r1 == r2) {
			partitions.add(new Partition(r1, c1, r2, (c1 + c2) / 2));
			partitions.add(new Partition(r1, ((c1 + c2) + 1) / 2, r2, c2));
		} else if (c1 == c2) {
			partitions.add(new Partition(r1, c1, (r1 + r2) / 2, c2));
			partitions.add(new Partition(((r1 + r2) + 1) / 2, c1, r2, c2));
		} else {
			int rowSplit = (r1 + r2) / 2;
			int colSplit = (c1 + c2) / 2;

			partitions.add(new Partition(r1, c1, rowSplit, colSplit));
			partitions.add(new Partition(rowSplit + 1, c1, r2, colSplit));
			partitions.add(new Partition(r1, colSplit + 1, rowSplit, c2));
			partitions.add(new Partition(rowSplit + 1, colSplit + 1, r2, c2));
		}

		return partitions;
	}

	private static void fill(Partition partition, int[][] mat) {
		int r1 = partition.r1;
		int r2 = partition.r2;
		int c1 = partition.c1;
		int c2 = partition.c2;

		for (int i = r1 - 1; i < r2; i++) {
			for (int j = c1 - 1; j < c2; j++) {
				mat[i][j] = 1;
			}
		}
	}

	private static void push(Stack<Partition> partitions, Partition partition, Set<Partition> inserted) {
		partitions.push(partition);
		/*if (inserted.add(partition)) {
		}*/
	}


	private static void pushPartitions(int r1, int c1, int r2, int c2, Stack<Partition> partitions, Set<Partition> inserted) {
		int rowSplit = (r1 + r2) / 2;
		int colSplit = (c1 + c2) / 2;

		/*System.out.println(new Partition(r1, c1, rowSplit, colSplit));
		System.out.println(new Partition(rowSplit + 1, c1, r2, colSplit));
		System.out.println(new Partition(r1, colSplit + 1, rowSplit, c2));
		System.out.println(new Partition(rowSplit + 1, colSplit + 1, r2, c2));
		System.out.println();*/

		push(partitions, new Partition(r1, c1, rowSplit, colSplit), inserted);
		push(partitions, new Partition(rowSplit + 1, c1, r2, colSplit), inserted);
		push(partitions, new Partition(r1, colSplit + 1, rowSplit, c2), inserted);
		push(partitions, new Partition(rowSplit + 1, colSplit + 1, r2, c2), inserted);
	}

	static class Partition {
		int r1;
		int c1;
		int r2;
		int c2;

		int found;

		public Partition(int r1, int c1, int r2, int c2) {
			this.r1 = r1;
			this.c1 = c1;
			this.r2 = r2;
			this.c2 = c2;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Partition partition = (Partition) o;
			return r1 == partition.r1 &&
					c1 == partition.c1 &&
					r2 == partition.r2 &&
					c2 == partition.c2;
		}

		@Override
		public int hashCode() {
			return Objects.hash(r1, c1, r2, c2);
		}

		@Override
		public String toString() {
			return "Partition{" +
					"r1=" + r1 +
					", c1=" + c1 +
					", r2=" + r2 +
					", c2=" + c2 +
					'}';
		}
	}
}
