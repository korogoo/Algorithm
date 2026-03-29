import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        for (int len = L; len <= 100; len++) {
            int numerator = N - (len * (len - 1) / 2);

            if (numerator < 0) {
                break;
            }

            if (numerator % len == 0) {
                int start = numerator / len;

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < len; i++) {
                    sb.append(start + i).append(" ");
                }
                System.out.println(sb);
                return;
            }
        }

        System.out.println(-1);
    }
}