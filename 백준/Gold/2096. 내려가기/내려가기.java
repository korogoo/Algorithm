import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] result = solution(n, board);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] solution(int n, int[][] board) {
        int[] prevMin = new int[3];
        int[] prevMax = new int[3];

        for (int i = 0; i < 3; i++) {
            prevMin[i] = board[0][i];
            prevMax[i] = board[0][i];
        }

        for (int i = 1; i < n; i++) {
            int[] curMin = new int[3];
            int[] curMax = new int[3];

            curMin[0] = board[i][0] + Math.min(prevMin[0], prevMin[1]);
            curMin[1] = board[i][1] + Math.min(prevMin[0], Math.min(prevMin[1], prevMin[2]));
            curMin[2] = board[i][2] + Math.min(prevMin[1], prevMin[2]);

            curMax[0] = board[i][0] + Math.max(prevMax[0], prevMax[1]);
            curMax[1] = board[i][1] + Math.max(prevMax[0], Math.max(prevMax[1], prevMax[2]));
            curMax[2] = board[i][2] + Math.max(prevMax[1], prevMax[2]);

            prevMin = curMin;
            prevMax = curMax;
        }
        int min = Math.min(prevMin[0], Math.min(prevMin[1], prevMin[2]));
        int max = Math.max(prevMax[0], Math.max(prevMax[1], prevMax[2]));
        return new int[]{max, min};
    }
}
