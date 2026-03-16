import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] inputs = new int[3];
        int i = 0;
        while (st.hasMoreTokens()) {
            inputs[i++] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(inputs[0], inputs[1], inputs[2]));
    }

    private static int solution(final int N, final int r, final int c) {
        int n = (int) Math.pow(2, N);
        return recursive(n, r, c);
    }

    private static int recursive(final int size, final int r, int c) {
        if (size == 2) {
            if (r == 0 && c == 0) {
                return 0;
            }
            if (r == 0 && c == 1) {
                return 1;
            }
            if (r == 1 && c == 0) {
                return 2;
            }
            if (r == 1 && c == 1) {
                return 3;
            }
        }

        int half = size / 2;
        int area = half * half;
        if (r < half && c < half) {
            return recursive(half, r, c);
        }
        if (r < half) {
            return area + recursive(half, r, c - half);
        }
        if (c < half) {
            return 2 * area + recursive(half, r - half, c);
        }
        return 3 * area + recursive(half, r - half, c - half);
    }
}