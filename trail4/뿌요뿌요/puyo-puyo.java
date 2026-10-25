import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static boolean[][] visited;
    static int burstBlock;
    static int[][] grid;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        visited = new boolean[n][n];

        burstBlock = 0;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    result = Math.max(result, bfs(i, j, 1, n));
                }
            }
        }
        System.out.println(burstBlock + " " + result);
    }


    private static int bfs(int x, int y, int count, int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, count});
        visited[x][y] = true;
        int answer = 0;
        boolean isBurst = false;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tempX = temp[0];
            int tempY = temp[1];

            for(int d = 0; d < 4; d++) {
                int nx = tempX + dx[d];
                int ny = tempY + dy[d];
                if(0 <= nx && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] == grid[x][y]) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    count++;
                }
            }
        }

        if(count >= 4) burstBlock++;

        return count;
    }
}