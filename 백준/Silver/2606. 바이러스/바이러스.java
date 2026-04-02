import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computerCount = Integer.parseInt(br.readLine());
        int edgeCount = Integer.parseInt(br.readLine());

        graph = new ArrayList[computerCount + 1];
        visited = new boolean[computerCount + 1];

        for (int i = 1; i <= computerCount; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        System.out.println(count - 1);
    }

    static void dfs(int now) {
        visited[now] = true;
        count++;

        for (int next : graph[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}