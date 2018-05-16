package Challenge.Dell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BobAndCities {

    private static FastReader reader = new FastReader();

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int N = reader.nextInt();
        int M = reader.nextInt();

        String[] A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = reader.nextLine();
        }

        //costs
        long L = reader.nextLong();
        long R = reader.nextLong();
        long U = reader.nextLong();
        long D = reader.nextLong();

        int stY = reader.nextInt();
        int stX = reader.nextInt();
        long[][] costMatrix = new long[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(costMatrix[i], Long.MAX_VALUE);
        }

        buildCostMatrix(costMatrix, stX, stY, M, N, L, R, U, D);

        boolean[][] houseArray = buildHouseArray(A, N, M);
        int Q = reader.nextInt();
        while (Q-- > 0) {
            checkUniqueHouses(M, N, costMatrix, houseArray);
        }
    }

    private static void checkUniqueHouses(int M, int N, long[][] costMatrix, boolean[][] houseArray) {
        int count = 0;
        long X = reader.nextLong();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (costMatrix[i][j] <= X && houseArray[i][j])
                    count++;
            }
        }
        System.out.println(count);
    }

    private static boolean[][] buildHouseArray(String[] A, int N, int M) {
        boolean[][] houseArray = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] array = A[i].toCharArray();
            for (int j = 0; j < M; j++) {
                if (array[j] == '.')
                    houseArray[i][j] = true;
            }
        }
        return houseArray;
    }

    /*
3 4
..#.
#...
..#.
1 2 3 4
2 3
3
2
5
10
     */
    private static void buildCostMatrix(long[][] costMatrix, int stX, int stY, int M, int N, long L, long R, long U, long D) {

        costMatrix[stY - 1][stX - 1] = 0;

        for (int i = stX - 1; i > 0; i--) {
            costMatrix[stY - 1][i - 1] = costMatrix[stY - 1][i] + L;
        }

        for (int i = stX - 1; i < M - 1; i++) {
            costMatrix[stY - 1][i + 1] = costMatrix[stY - 1][i] + R;
        }

        for (int i = stY - 1; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                costMatrix[i + 1][j] = costMatrix[i][j] + D;
            }
        }

        for (int i = 0; i < stY - 1; i++) {
            for (int j = 0; j < M; j++) {
                costMatrix[i][j] = costMatrix[i + 1][j] + U;
            }
        }
    }

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
