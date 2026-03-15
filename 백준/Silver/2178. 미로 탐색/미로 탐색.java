import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[][] maze;
    private static int[] dx = new int[]{-1,1,0,0};
    private static int[] dy = new int[]{0,0,-1,1};
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        int answer = bfs(0,0);
        System.out.println(answer);
    }


    private static int bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        int count = 1;
        queue.add(new int[]{i, j, count});
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tempX = temp[0];
            int tempY = temp[1];
            int tempC = temp[2];
            if(tempX == N-1 && tempY == M-1) {
                return tempC;
            }
            for(int d = 0; d < 4; d++) {
                int nx = tempX + dx[d];
                int ny = tempY + dy[d];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && maze[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, tempC + 1});
                }
            }
        }

        return count;
    }
}
