// dp[i] : "i번째 계단에 도착했을 때 최대 점수?"
// i-3  ->  i-1  ->  i
// i-2  ->  i

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n + 1];
        for (int i = 1; i < stair.length; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(stair));
    }
    
    private static int solution(final int[] stair) {
        final int stairCount = stair.length - 1;
        if (stairCount == 1) {
            return stair[1];
        }
        if (stairCount == 2) {
            return stair[1] + stair[2];
        }
        
        int[] dp = new int[stair.length];
        dp[0] = 0;
        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];
        
        for (int i = 3; i < stair.length; i++) {
            int a = stair[i - 1] + dp[i - 3];
            int b = dp[i - 2];
            
            dp[i] = stair[i] + Math.max(a, b);
        }
        return dp[stairCount];
    }
}