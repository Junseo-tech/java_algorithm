package august.eighteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11724 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N,M;
    private static List<List<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.println(result);
    }

    private static void dfs(int v){
        visited[v] = true;
        for(int w : graph.get(v)){
            if(!visited[w]){
                dfs(w);
            }
        }
    }
}
