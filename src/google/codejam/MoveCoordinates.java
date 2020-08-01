package google.codejam;

import java.util.Objects;

public class MoveCoordinates {
	public static long max=1000000000L;
	public static long min=-1000000000L;
	static boolean isReachable(int x, int y, int a, int b, int moveCount, String directions) {
		int d;
		if(moveCount == 0)
			d =1;
		else
			d = moveCount * 2;

		if (x > max || y > max||x<min||y<min)
			return false;

		if (x == a && y == b) {
			System.out.println(directions);
			return true;
		}

		// check for other 2 possibilities
		return (isReachable(x, y+d, a, b,d, directions + "N")
				|| isReachable(x+d, y, a, b,d, directions + "E")
				|| isReachable(x, y-d, a, b,d, directions+"S")
				|| isReachable(x-d, y, a, b,d, directions+"W"));
	}

	public static void main(String[] args) {
		System.out.println(isReachable(0,0,2,3, 0, ""));
	}

	public static class Coordinate{
		int x;
		int y;

		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Coordinate that = (Coordinate) o;
			return x == that.x &&
					y == that.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
}
