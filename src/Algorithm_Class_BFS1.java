import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm_Class_BFS1 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<List<Integer>> graph;
    private static Queue<Integer> q = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점
        int[] answer = new int[N+1];

        graph = new ArrayList<>();
        boolean[] visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) { // 열을 만들어줘야 함 -> 지금은 행만 정의 됨
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) { // 그래프 정의
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        bfs(visited, R, answer);

    }

    private static void bfs(boolean[] visited, int start, int[] answers){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int cur = q.poll(); // 큐에서 뽑기
            answers[cur] = count++;
            Collections.sort(graph.get(cur)); // 오름차순 방문
            for(int c : graph.get(cur)){
                if(!visited[c]){
                    q.add(c);
                    visited[c] = true;
                }
            }

        }
        for(int i = 1; i < answers.length; i++){
            sb.append(answers[i]).append("\n");
        }

        System.out.println(sb);
    }
}
