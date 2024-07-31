package july.thirty.thirty_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.StringTokenizer;

public class knight_movement {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    static int[] dx = {-2,-1,2,1,-2,-1,2,1};
    static int[] dy = {1,2,1,2,-1,-2,-1,-2};
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int answer = 0;
            N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());
            answer = bfs(x, y, end_x, end_y);
            System.out.println(answer);
        }
    }

    private static int bfs(int start_x, int start_y, int end_x, int end_y){
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.add(new int[]{start_x,start_y, count});
        visited[start_x][start_y] = true;
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            count = current[2];
            if(x == end_x && y == end_y){
                return count;
            }
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, count+1});
                }
            }
        }
        return -1;
    }
}
