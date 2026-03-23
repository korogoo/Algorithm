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
        int[] op = new int[n + 1];

        for (int i = 2; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 3 == 0 && min > dp[i / 3] + 1) {
                min = dp[i / 3] + 1;
                dp[i] = min;
                op[i] = 1;
            }
            if (i % 2 == 0 && min > dp[i / 2] + 1) {
                min = dp[i / 2] + 1;
                dp[i] = min;
                op[i] = 2;
            }
            if (min > dp[i - 1] + 1) {
                min = dp[i - 1] + 1;
                dp[i] = min;
                op[i] = 3;
            }
        }

        System.out.println(dp[n]);
        int val = n;
        while (val >= 1) {
            System.out.print(val + " ");
            if (val == 1) {
                break;
            }
            if (op[val] == 1) {
                val /= 3;
                continue;
            }
            if (op[val] == 2) {
                val /= 2;
                continue;
            }
            if (op[val] == 3) {
                val -= 1;
            }
        }
    }
}