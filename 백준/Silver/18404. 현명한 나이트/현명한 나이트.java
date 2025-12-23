import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int kX, kY;
    private static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    private static int[][] graph;
    private static boolean[][] visited;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][N];

        for(int i = 0; i < N; i++) {
            Arrays.fill(graph[i], -1);
        }

        st = new StringTokenizer(br.readLine());
        kX = Integer.parseInt(st.nextToken()) - 1;
        kY = Integer.parseInt(st.nextToken()) - 1;

        bfs();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int tempX = Integer.parseInt(st.nextToken()) - 1;
            int tempY = Integer.parseInt(st.nextToken()) - 1;
            sb.append(graph[tempX][tempY]).append(" ");
        }

        System.out.println(sb);

    }

    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{kX, kY, 0});
        visited = new boolean[N][N];
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int tempX = temp[0];
            int tempY = temp[1];
            int curDist = temp[2];

            graph[tempX][tempY] = curDist;
            visited[tempX][tempY] = true;

            for(int d = 0; d < 8; d++) {
                int nx = tempX + dx[d];
                int ny = tempY + dy[d];
                if(0 <= nx && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny, curDist + 1});
                }
            }
        }
    }
}
