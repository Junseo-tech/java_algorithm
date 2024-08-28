package august.twenty_eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ13023 {
    private static List<List<Integer>> graph = new ArrayList<>();
    private static int N,M;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] visited;
    private static boolean found;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, false);
            dfs(i, 0);
            if(found) break;
        }

        System.out.println(found? 1 : 0);

    }

    private static void dfs(int x, int depth){
        if(depth >= 4){
            found = true;
            return;
        }
        visited[x] = true;
        for(int v : graph.get(x)){
            if(!visited[v]){
                dfs(v, depth + 1);
                if(found) return;
            }
        }
        visited[x] = false;
    }


}
