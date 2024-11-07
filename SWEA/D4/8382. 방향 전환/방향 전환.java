import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    private static int x1,y1,x2,y2;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static int answer;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            answer = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken()) + 100;
            y1 = Integer.parseInt(st.nextToken()) + 100;
            x2 = Integer.parseInt(st.nextToken()) + 100;
            y2 = Integer.parseInt(st.nextToken()) + 100;

            if(x1 == x2 && y1 == y2) {
                answer = 0;
            } else {
                for(int i = 0; i < 4; i++) {
                    int nx = x1 + dx[i];
                    int ny = y1 + dy[i];
                    if(nx >= 0 && nx < 201 && ny >= 0 && ny < 201) {
                        bfs(nx, ny, 1, i);
                    }
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int startX, int startY, int count, int dir) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[201][201];
        q.add(new int[]{startX, startY, count, dir});
        visited[startX][startY] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            int direction = cur[3];

            if(x == x2 && y == y2) {
                answer = Math.min(answer, cnt);
                return;
            }

            if(direction < 2) { // 상하
                for(int i = 2; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && nx < 201 && ny >= 0 && ny < 201 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, cnt + 1, i});
                    }
                }
            } else { // 좌우
                for(int i = 0; i < 2; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && nx < 201 && ny >= 0 && ny < 201 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, cnt + 1, i});
                    }
                }
            }
        }
    }

}