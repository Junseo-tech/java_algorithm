import java.util.*;
import java.io.*;

public class Main {
    private static int N,M,V;
    private static List<List<Integer>> graph;
    private static StringBuilder sb;
    private static Deque<Integer> stack;
    private static Queue<Integer> queue;
    private static boolean[] visited;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        sb = new StringBuilder();
        stack = new ArrayDeque<>();
        queue = new ArrayDeque<>();
        visited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");
        for(int temp : graph.get(start)) {
            if(!visited[temp]) {
                dfs(temp);
            }
        }
    }

    private static void bfs(int start) {
        visited = new boolean[N + 1];
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append(" ");
            for(int temp : graph.get(cur)) {
                if(!visited[temp]) {
                    queue.add(temp);
                    visited[temp] = true;
                }
            }
        }
    }
}
