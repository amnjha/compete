package hackerearth;

import java.util.*;

/**
 * https://www.hackerearth.com/practice/algorithms/graphs/shortest-path-algorithms/practice-problems/algorithm/mancunian-goes-to-the-derby/
 */
public class MancunianDerby {
	static Scanner scanner = new Scanner(System.in);
	List<List<Node>> adj;
	private int dist[];
	private Set<Integer> settled;
	private PriorityQueue<Node> pq;
	private int V; // Number of vertices

	public MancunianDerby(int V) {
		this.V = V;
		dist = new int[V];
		settled = new HashSet<Integer>();
		pq = new PriorityQueue<Node>(V, new Node());
	}

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		List<List<Node>> adj = new ArrayList<>();
		int N = scanner.nextInt();
		int E = scanner.nextInt();
		int Q = scanner.nextInt();

		for (int i = 0; i < N; i++) {
			List<Node> item = new ArrayList<>();
			adj.add(item);

			int A = scanner.nextInt();
			int B = scanner.nextInt();

			adj.get(0).add(new Node(A, B));
		}

		MancunianDerby dpq = new MancunianDerby(N);
		dpq.dijkstra(adj, 0);
		System.out.println("The shorted path from node :");
		for (int i = 0; i < dpq.dist.length; i++)
			System.out.println(0 + " to " + i + " is "
					+ dpq.dist[i]);
	}

	public void dijkstra(List<List<Node>> adj, int src) {
		this.adj = adj;

		for (int i = 0; i < V; i++)
			dist[i] = Integer.MAX_VALUE;

		pq.add(new Node(src, 0));

		dist[src] = 0;
		while (settled.size() != V) {

			int u = pq.remove().node;
			settled.add(u);

			e_Neighbours(u);
		}
	}

	// Function to process all the neighbours
	// of the passed node
	private void e_Neighbours(int u) {
		int edgeDistance = -1;
		int newDistance = -1;

		// All the neighbors of v
		for (int i = 0; i < adj.get(u).size(); i++) {
			Node v = adj.get(u).get(i);

			// If current node hasn't already been processed
			if (!settled.contains(v.node)) {
				edgeDistance = v.cost;
				newDistance = dist[u] + edgeDistance;

				// If new distance is cheaper in cost
				if (newDistance < dist[v.node])
					dist[v.node] = newDistance;

				// Add the current node to the queue
				pq.add(new Node(v.node, dist[v.node]));
			}
		}
	}
}

class Node implements Comparator<Node> {
	public int node;
	public int cost;

	public Node() {
	}

	public Node(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}

	@Override
	public int compare(Node node1, Node node2) {
		if (node1.cost < node2.cost)
			return -1;
		if (node1.cost > node2.cost)
			return 1;
		return 0;
	}
}