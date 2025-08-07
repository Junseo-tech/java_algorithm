import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int T, N;
    private static int[] dx = new int[] {1, -1, 1, -1, -2, 2, 2, -2};
    private static int[] dy = new int[] {-2, -2, 2, 2, 1, 1, -1, -1};
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y =  Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int goalX = Integer.parseInt(st.nextToken());
            int goalY = Integer.parseInt(st.nextToken());

            bfs(x, y, goalX, goalY);
        }
        System.out.println(sb);

    }

    private static void bfs(int x, int y, int goalX, int goalY) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[] {x, y, count});
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tempX = temp[0];
            int tempY = temp[1];
            int tempCount = temp[2];
            if(tempX == goalX && tempY == goalY) {
                sb.append(tempCount).append("\n");
                return;
            }
            for(int i = 0; i < 8; i++) {
                int nx = tempX + dx[i];
                int ny = tempY + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, tempCount + 1});
                }
            }
        }

    }
}
