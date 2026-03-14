import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static List<List<Integer>> graph;
   // private static Map<Integer, Integer> result;
    private static int[] result;
    private static boolean[] visited;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        N = Integer.parseInt(br.readLine()); // N (2 ≤ N ≤ 100,000)
        graph = new ArrayList<>();
     //   result = new TreeMap<Integer, Integer>();
        visited = new boolean[N + 1];
        result = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        StringBuilder sb = new StringBuilder();
//        for(Map.Entry<Integer, Integer> t : result.entrySet()) { // O(N)
//            sb.append(t.getValue()).append("\n");
//        }

        for(int i = 2; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);

    }

    private static void dfs(int start) { // O(V + E) 인데 V == N, E == N-1 이니까 O(N)
        visited[start] = true;
        for(int temp : graph.get(start)) {
            if(!visited[temp]) {
                //result.putIfAbsent(temp, start); // O(logN)
                result[temp] = start;
                dfs(temp);
            }
        }
    }
}
