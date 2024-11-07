import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N,M;
    private static char[][] map;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] visited;
    private static int answer;
    private static Queue<int[]> water = new LinkedList<>();
    private static StringBuilder sb =  new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            sb.append("#").append(t).append(" ");

            map = new char[N][M];
            visited = new int[N][M];
            answer = 0;
            for(int i = 0; i < N; i++) {
                String line = br.readLine();
                for(int j = 0; j < M; j++) {
                    map[i][j] = line.charAt(j);
                    visited[i][j] = Integer.MAX_VALUE;
                    if(map[i][j] == 'W') {
                        water.add(new int[]{i, j});
                        visited[i][j] = 0;
                    }
                }
            }
            bfs();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    answer += visited[i][j];
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }

    private static void bfs() {
        while(!water.isEmpty()) {
            int[] temp = water.poll();
            int x = temp[0], y = temp[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 'L' && visited[nx][ny] == Integer.MAX_VALUE) {
                    visited[nx][ny] = visited[x][y] + 1;
                    water.add(new int[]{nx, ny});
                }
            }
        }

    }


}