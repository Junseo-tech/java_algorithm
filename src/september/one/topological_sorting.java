package september.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class topological_sorting {
    private static int V,E;
    private static int[][] graph;
    private static int[] link;
    private static Queue<Integer> queue = new LinkedList<>();
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        for(int tc = 1; tc <= 10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            sb.setLength(0);
            queue.clear();
            graph = new int[V + 1][V + 1];
            link = new int[V + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < E; i++){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a][b] = 1;
                link[b] += 1;
            }

            for(int i = 1; i <= V; i++){
                if(link[i] == 0) queue.add(i);
            }

            while(!queue.isEmpty()){
                int cur = queue.poll();
                sb.append(cur).append(" ");
                for(int i = 1; i <= V; i++){
                    if(graph[cur][i] == 1){
                        link[i] -= 1;
                        if(link[i] == 0) queue.add(i);
                    }
                }
            }
            System.out.println("#" + tc + " " + sb.toString());
        }
    }

}
