package august.twenty_seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1267 {
    private static int V,E;
    private static int[][] graph;
    private static int[] link;
    private static Queue<Integer> queue = new LinkedList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        for(int tc = 1; tc <= 10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new int[V][V];
            link = new int[V];

            sb.setLength(0);

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < E; i++) {
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                graph[start][end] = 1;
                link[end] += 1;
            }

            for(int i = 0; i < V; i++) {
                if(link[i] == 0) queue.add(i);
            }

            while(!queue.isEmpty()) {
                int cur = queue.poll();
                sb.append(cur + 1).append(" ");
                for(int i = 0; i < V; i++) {
                    if(graph[cur][i] == 1) {
                        link[i] -= 1;
                        if(link[i] == 0) queue.add(i);
                    }
                }
            }

            System.out.println("#" + tc + " " + sb.toString());
        }
    }
}
