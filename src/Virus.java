import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Virus {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Queue<Integer> q = new LinkedList<Integer>();
    private static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine()); // 랑크 수

        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        boolean[] visited = new boolean[N+1];

        for (int i = 1; i <= M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int answer = bfs(1, visited);
        System.out.println(answer);
    }

    private static int bfs(int start, boolean[] visited){
        int count = 0;
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for (int t : graph.get(temp)) {
                if (!visited[t]) {
                    visited[t] = true;
                    count += 1;
                    q.add(t);
                }
            }
        }
        return count;
    }

}
