package august.twenty_seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA2105 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[][] cafe;
    private static int[] dx = {-1,-1, 1, 1};
    private static int[] dy = {1, -1, -1, 1};
    private static int max_category;
    private static boolean[][] visited;
    private static boolean[] already_visited;
    private static int answer;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            cafe = new int[N][N];
            answer = Integer.MIN_VALUE;
            max_category = Integer.MIN_VALUE;

            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    cafe[i][j] = Integer.parseInt(st.nextToken());
                    if(max_category < cafe[i][j]) {
                        max_category = cafe[i][j];
                    }
                }
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(isPossible(i,j)) {
                        visited = new boolean[N][N];
                        already_visited = new boolean[max_category + 1];
                        cafeTour(i,j,i,j,0, 0);
                    }
                }
            }
            sb.append("#").append(tc).append(" ");
            if(answer == Integer.MIN_VALUE) {
                sb.append(-1);
            } else {
                sb.append(answer);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }


    private static void cafeTour(int start_x, int start_y, int x, int y, int count, int dir) {
        if(x < 0 || y < 0 || x >= N || y >= N) {
            return;
        }

        if(start_x == x && start_y == y && count > 2) {
            answer = Math.max(answer, count);
            return;
        }

        for(int i = dir; i < 4; i++) { // dir이 차례대로 갈 수 있도록 해주기
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && !already_visited[cafe[nx][ny]]) {
                visited[nx][ny] = true;
                already_visited[cafe[nx][ny]] = true;
                cafeTour(start_x, start_y, nx, ny, count + 1, i);
                visited[nx][ny] = false;
                already_visited[cafe[nx][ny]] = false;
            }
        }

    }


    private static boolean isPossible(int x, int y) {
        for(int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
                return false;
            }
        }
        return true;
    }

}

