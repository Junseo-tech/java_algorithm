import java.util.*;
import java.io.*;

public class Main {
    static int[] parents;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        parents = new int[n+1];
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];

        for(int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        visited[1] = true;
        travel(1);

        for(int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void travel(int num) {
        for(int i = 0; i < graph[num].size(); i++) {
            int y = graph[num].get(i);
            if(!visited[y]) {
                visited[y] = true;
                parents[y] = num;

                travel(y);
            }
        }
    }
}