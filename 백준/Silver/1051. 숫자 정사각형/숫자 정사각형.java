import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int maxArea = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int size = 1; i + size < n && j + size < m; size++) {
                    char value = board[i][j];

                    if (board[i][j + size] == value
                        && board[i + size][j] == value
                        && board[i + size][j + size] == value) {
                        int area = (size + 1) * (size + 1);
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
        }

        System.out.println(maxArea);
    }
}