/*
0 1 2 3 4 5 6 7 8 9 10
0 0 1 1 2 3 2 3 3 2 3
0 0 2 1 2 3 1 3 2 1 3
*/
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int[] prev = new int[n + 1];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;

            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }
        }

        System.out.println(dp[n]);
        int cur = n;
        while (true) {
            System.out.print(cur + " ");
            if (cur == 1) {
                break;
            }
            cur = prev[cur];
        }
    }
}