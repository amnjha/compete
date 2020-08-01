package CODECHEF.LongChallenge.June2020;

import java.util.*;

public class CONTAIN {
	static List<List<Point>> ans = new ArrayList<>();

	static boolean compare(Point a, Point b) {
		return a.x < b.x || (a.x == b.x && a.y < b.y);
	}

	private static void removeMatch(List<Point> points, Point match) {
		while (points.remove(match));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t;
		t = scanner.nextInt();
		while (t-- > 0) {
			long n, q;
			n = scanner.nextLong();
			q = scanner.nextLong();
			List<Point> points = new ArrayList<>();
			for (int i = 0; i < n; ++i) {
				long u = scanner.nextLong();
				long v = scanner.nextLong();

				Point point = new Point();
				point.x = u;
				point.y = v;

				points.add(point);
			}
			List<Point> copy = new ArrayList<>(points);
			while (copy.size() > 2) {
				convex_hull(copy);
			}
			copy.clear();
			while (q-- > 0) {
				long answer = 0;
				Point P = new Point();
				P.x = scanner.nextDouble();
				P.y = scanner.nextDouble();


				for (List<Point> itr : ans) {
					boolean ok = false;
					for (int i = 0; i < itr.size(); ++i) {
						if (!cw(itr.get(i), itr.get((i + 1) % itr.size()), P)) {
							ok = true;
							break;
						}
					}
					if (!ok) answer++;
					else break;
				}
				System.out.println(answer);
			}
			ans.clear();
			points.clear();
		}
	}

	static boolean cw(Point a, Point b, Point c) {
		return a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y) < 0;
	}

	static boolean ccw(Point a, Point b, Point c) {
		return a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y) > 0;
	}

	static long orientation(Point p, Point q, Point r) {
		double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

		if (val == 0) return 0;
		return (val > 0) ? 1 : 2;
	}

	static void convex_hull(List<Point> a) {
		if (a.size() == 1)
			return;

		Collections.sort(a, (a1, b) -> a1.x < b.x || (a1.x == b.x && a1.y < b.y) ? 1 : -1);
		Point p1 = a.get(0), p2 = a.get(a.size() - 1);
		List<Point> up = new ArrayList<>();
		List<Point> down = new ArrayList<>();

		up.add(p1);
		down.add(p1);

		for (int i = 1; i < a.size(); i++) {
			if (i == a.size() - 1 || cw(p1, a.get(i), p2)) {
				while (up.size() >= 2 && !cw(up.get(up.size() - 2), up.get(up.size() - 1), a.get(i)))
					up.remove(up.size() - 1);
				up.add(a.get(i));
			}
			if (i == a.size() - 1 || ccw(p1, a.get(i), p2)) {
				while (down.size() >= 2 && !ccw(down.get(down.size() - 2), down.get(down.size() - 1), a.get(i)))
					down.remove(down.size() - 1);
				down.add(a.get(i));
			}
		}

		List<Point> tpts = new ArrayList<>();
		for (int i = 0; i < up.size(); i++) {
			tpts.add(up.get(i));
			removeMatch(a, up.get(i));
		}
		for (int i = down.size() - 2; i > 0; i--) {
			tpts.add(down.get(i));
			removeMatch(a, down.get(i));
		}
		List<Point> temp = new ArrayList<>(a);
		for (Point point : temp) {
			for (int i = 0; i < tpts.size(); ++i) {
				long x = orientation(tpts.get(i), tpts.get((i + 1) % tpts.size()), point);
				if (x == 0)
					removeMatch(a, point);
			}
		}
		ans.add(tpts);
	}

	static class Point {
		double x;
		double y;

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Point point = (Point) o;
			return Double.compare(point.x, x) == 0 &&
					Double.compare(point.y, y) == 0;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}


}
