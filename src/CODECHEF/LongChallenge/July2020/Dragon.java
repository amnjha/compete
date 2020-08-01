package CODECHEF.LongChallenge.July2020;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

class Dragon {

    // static final Scanner in = new Scanner(System.in);
    static final Reader in = new Reader();
    static int N, Q;
    static int[] a, h;
    static Stack<Integer> stack;
    static int[] parentR, parentL;
    static List<Integer>[] adjL, adjR;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        N = in.nextInt();
        Q = in.nextInt();
        if (N == 1) {
            int A = in.nextInt();
            int cost = in.nextInt();
            for (int i = 0; i < Q; i++) {
                int val = in.nextInt();
                int l = in.nextInt();
                int r = in.nextInt();
                if (val == 1) {
                    cost = r;
                } else {
                    println(cost);
                }
            }
        } else {
            a = new int[N + 1];
            h = new int[N + 1];

            parentR = new int[N + 1];
            parentL = new int[N + 1];
            stack = new Stack<>();
            adjL = new ArrayList[N + 1];
            adjR = new ArrayList[N + 1];

            adjL[0] = new ArrayList<>();
            adjR[0] = new ArrayList<>();
            parentL[0] = -1;
            parentR[0] = -1;

            for (int i = 1; i <= N; i++) {
                h[i] = in.nextInt();
                adjL[i] = new ArrayList<>();
                adjR[i] = new ArrayList<>();

            }

            for (int i = 1; i <= N; i++) {
                a[i] = in.nextInt();
            }

            // ..creating TreeR
            stack = new Stack<>();
            for (int i = 1; i <= N; i++) {

                while (!stack.isEmpty() && h[stack.peek()] < h[i]) {
                    int u = stack.pop();
                    parentR[u] = i;
                    adjR[i].add(u);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                int u = stack.pop();
                parentR[u] = 0;
                adjR[0].add(u);
            }

            // ..creating TreeL
            stack = new Stack<>();
            for (int i = N; i > 0; i--) {

                while (!stack.isEmpty() && h[stack.peek()] < h[i]) {
                    int u = stack.pop();
                    parentL[u] = i;
                    adjL[i].add(u);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                int u = stack.pop();
                parentL[u] = 0;
                adjL[0].add(u);
            }

            // printAdj("adjR", adjR);
            // printAdj("adjL", adjL);

            Tree treeL = new Tree(parentL, adjL, 0);
            Tree treeR = new Tree(parentR, adjR, 0);

            while (Q-- > 0) {
                int type = in.nextInt();
                int l = in.nextInt();
                int r = in.nextInt();

                if (type == 1) {
                    // ..update
                    treeL.update(l, r);
                    treeR.update(l, r);
                    a[l] = r;

                } else {
                    if(l==r){
                        println(a[r]);
                        continue;
                    }
                    else if (h[l] <= h[r]) {
                        println(-1);
                        continue;
                    }
                    if (l > r) {

                        println(treeR.query(l, r));
                    } else if (r > l) {
                        println(treeL.query(l, r));
                    } else {
                        println(a[r]);
                    }
                }
            }

        }

        System.out.println(stringBuilder);
    }

    static void print(Object value) {
        stringBuilder.append(value);
    }

    static void println(Object value) {
        stringBuilder.append(value).append("\n");
    }

    static void printAdj(String str, List<Integer>[] adj) {
        println(str + " --> ");
        for (int i = 0; i < adj.length; i++) {
            System.out.print(i + " -->");
            for (int j : adj[i])
                System.out.print(j + " ");
            println("");
        }
        println("");
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

    static class Tree {

        int[] parent, heavy, depth, head, pos;
        List<Integer>[] adj;
        int root, cur_pos;

        HashMap<Integer, List<Integer>> paths = new HashMap<>();
        HashMap<Integer, SegmentTree> seg_trees = new HashMap<>();

        int[][] LCA;

        Tree(int[] par, List<Integer>[] ad, int r) {
            parent = par;
            adj = ad;
            root = r;
            cur_pos = 0;
            heavy = new int[ad.length];
            depth = new int[ad.length];
            head = new int[ad.length];
            pos = new int[ad.length];
            LCA = new int[N + 1][log2(N) + 1];
            Arrays.fill(heavy, -1);
            Arrays.fill(head, -1);

            heavyChildDFS(0); // ..n

            paths.put(0, new ArrayList<>());
            HLD(0, 0); // ..n

            computeLCAMatrix();
            // printDecomposedTree();

            convertpathsToSegmentTrees(); // .. nlogn
        }

        int log2(int x) {
            return (int) Math.floor(Math.log(x) / Math.log(2));
        }

        void computeLCAMatrix() {

            for (int i = 0; i < LCA.length; i++) {

                for (int j = 0; j < LCA[i].length; j++) {
                    LCA[i][j] = -1;
                }

            }

            for (int i = 1; i <= N; i++)
                LCA[i][0] = parent[i];

            for (int j = 1; j <= log2(N); j++) {
                for (int i = 1; i <= N; i++) {
                    if (LCA[i][j - 1] != -1) {
                        int par = LCA[i][j - 1];
                        LCA[i][j] = LCA[par][j - 1];
                    }
                }
            }
            // println("ComputeLCA is ....");
            // for(int i = 0;i < LCA.length;i++)
            // {
            //     System.out.print(i+" --> ");
            //     for(int j = 0;j < LCA[i].length;j++){
            //         System.out.print(LCA[i][j]+" ");
            //     }
            //     println();
            // }
        }

        int getLCA(int a, int b) {
            // println("\t\ta = " + a + " b = " + b);
            if (depth[a] > depth[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            int d = depth[b] - depth[a];
            // println("\t\td = " + d);

            while (d > 0) {
                int i = log2(d);
                b = LCA[b][i];
                d -= (1 << i);
                // println("\t\t\ti = " + i + " b = " + b + " d = " + d);
            }

            if (a == b)
                return a;
            // println("\t\tNow... second loop...");
            for (int i = log2(N); i >= 0; i--) {
                // println("\t\t\ti = "+i);
                if (LCA[a][i] != -1 && LCA[a][i] != LCA[b][i]) {
                    a = LCA[a][i];
                    b = LCA[b][i];
                }
            }

            return parent[a];
        }

        void printDecomposedTree() {
            println("decomposed tree --> ");
            for (int key : paths.keySet()) {
                println(key + " --> " + paths.get(key));
            }
        }

        void convertpathsToSegmentTrees() {
            for (int key : paths.keySet()) {
                List<Integer> path = paths.get(key);
                int n = path.size();

                int[] arr = new int[path.size()];
                for (int i = 0; i < path.size(); i++) {
                    arr[i] = path.get(i);
                }

                seg_trees.put(key, new SegmentTree(arr, n));
            }
        }

        int heavyChildDFS(int u) {

            int size = 1;
            int max_child_size = 0;

            for (int v : adj[u]) {
                depth[v] = depth[u] + 1;
                int child_size = heavyChildDFS(v);
                size += child_size;
                if (child_size > max_child_size) {
                    max_child_size = child_size;
                    heavy[u] = v;
                }
            }

            return size;
        }

        void HLD(int u, int h) {
            head[u] = h;
            pos[u] = cur_pos++;

            putInItsPath(u, h);

            if (heavy[u] != -1)
                HLD(heavy[u], h);

            for (int child : adj[u]) {
                if (child == heavy[u])
                    continue;
                cur_pos = 0;
                paths.put(child, new ArrayList<>());
                HLD(child, child);
            }
        }

        void putInItsPath(int u, int h) {
            List<Integer> path = paths.get(h);
            path.add(u);
            paths.put(h, path);
        }

        long query(int a, int b) {
            int lca = getLCA(a, b);
            // println("l = " + a + " r = " + b + " lca " + lca);
            if (lca != a)
                return -1;

            long res = 0;
            for (; head[a] != head[b]; b = parent[head[b]]) {
                // println("\thead of " + a + " = " + head[a] + " head of " + b + " = " + head[b]);
                if (depth[head[a]] > depth[head[b]]) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                SegmentTree t = seg_trees.get(head[b]);
                // println("\ttree of " + b + " = " + t);
                long val = t.query(0, 0, t.arr.length - 1, pos[head[b]], pos[b]);
                // println("\tquery from " + pos[head[b]] + " to " + pos[b] + " val = " + val);
                res += val;
            }

            if (depth[a] > depth[b]) {
                int temp = a;
                a = b;
                b = temp;
            }

            SegmentTree t = seg_trees.get(head[b]);
            // println("\ttree of " + b + " = " + t);
            long val = t.query(0, 0, t.arr.length - 1, pos[a], pos[b]);
            // println("\tquery from " + pos[head[b]] + " to " + pos[b] + " val = " + val);
            res += val;
            return res;
        }

        void update(int node, int new_val) {
            SegmentTree tree = seg_trees.get(head[node]);
            // println("before update == " + tree);
            tree.update(0, 0, tree.arr.length - 1, pos[node], new_val);
            seg_trees.put(head[node], tree);
            // println("after update == " + tree);
        }

    }

    static class SegmentTree {
        long tree[];
        int arr[];

        SegmentTree(int arr[], int n) {
            this.arr = arr;

            int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

            int max_size = 2 * (int) Math.pow(2, x) - 1;

            tree = new long[max_size];

            buildTree(0, 0, n - 1);
        }

        void buildTree(int i, int l, int r) {
            if (l == r)
                tree[i] = a[arr[l]];
            else {
                int mid = (l + r) / 2;
                buildTree(2 * i + 1, l, mid);
                buildTree(2 * i + 2, mid + 1, r);

                tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
            }
        }

        long query(int curr, int curr_l, int curr_r, int query_l, int query_r) {
            // println("\t\tcurr = " + curr + " curr_l = " + curr_l + " curr_r " + curr_r + " query_l = "
            // + query_l + " query_r = " + query_r);
            if (query_l > curr_r || query_r < curr_l)
                return 0;
            if (curr_l >= query_l && curr_r <= query_r)
                return tree[curr];

            int mid = (curr_l + curr_r) / 2;

            long ans_l = query(2 * curr + 1, curr_l, mid, query_l, query_r);
            long ans_r = query(2 * curr + 2, mid + 1, curr_r, query_l, query_r);

            return ans_l + ans_r;
        }

        void update(int curr, int curr_l, int curr_r, int pos, int val) {
            if (curr_l == curr_r)
                tree[curr] = val;
            else {
                int mid = (curr_l + curr_r) / 2;

                if (pos <= mid)
                    update(2 * curr + 1, curr_l, mid, pos, val);
                else
                    update(2 * curr + 2, mid + 1, curr_r, pos, val);

                tree[curr] = tree[2 * curr + 1] + tree[2 * curr + 2];
            }
        }

        @Override
        public String toString() {
            String toRet = "[";
            for (int i = 0; i < tree.length; i++) {
                toRet += tree[i] + " ";
            }
            toRet += "]";
            return toRet;
        }

    }

}