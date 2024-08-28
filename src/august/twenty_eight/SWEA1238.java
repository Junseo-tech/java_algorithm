package august.twenty_eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA1238 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<List<Integer>> graph;
    private static int answer;
    private static int N, start;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        for(int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            answer = Integer.MIN_VALUE;
            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();

            for(int i = 0; i <= 101; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N / 2; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
            }

            bfs(start);

            sb.append(answer).append("\n");

        }
        System.out.println(sb);
    }

    private static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[101];
        q.add(x);
        visited[x] = true;
        while(!q.isEmpty()){
            int size = q.size();
            int tempMax = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                tempMax = Math.max(tempMax, cur);
                for(int c : graph.get(cur)){
                    if(!visited[c]){
                        visited[c] = true;
                        q.add(c);
                    }
                }
            }
            answer = tempMax;
        }
    }
}
