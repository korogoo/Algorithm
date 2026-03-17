import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while (st.hasMoreTokens()) {
                board[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(board));
    }

    private static int[][] BOARD;

    private static class Count {
        private int zero;
        private int one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public void add(Count count) {
            zero += count.zero;
            one += count.one;
        }
    }

    private static String solution(final int[][] board) {
        BOARD = board;
        Count count = recursive(board.length, 0, 0);
        return count.zero + "\n" + count.one;
    }

    private static boolean isDifferent(final int size, final int i, final int j) {
        int initial = BOARD[i][j];
        for (int y = i; y < i + size; y++) {
            for (int x = j; x < j + size; x++) {
                if (BOARD[y][x] != initial) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Count recursive(final int size, final int i, final int j) {
        if (!isDifferent(size, i, j)) {
            if (BOARD[i][j] == 1) {
                return new Count(0, 1);
            }
            return new Count(1, 0);
        }

        int half = size / 2;
        Count count = new Count(0, 0);
        count.add(recursive(half, i, j));
        count.add(recursive(half, i, j + half));
        count.add(recursive(half, i + half, j));
        count.add(recursive(half, i + half, j + half));
        return count;
    }
}