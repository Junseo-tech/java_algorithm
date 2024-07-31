package july.thirty.thirty_one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class organic_napa_cabbage {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};
    private static int N,M,K;
    private static boolean[][] visited;
    private static int[][] location;
    private static int[][] map;
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 10
            N = Integer.parseInt(st.nextToken()); // 세로 8
            K = Integer.parseInt(st.nextToken()); // 배추가 심어져 있는 위치 갯수

            visited = new boolean[N][M];
            location = new int[N][M];

            map = new int[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1; // 배추 위치 완료
            }

            int temp = 0;
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if (map[j][k] == 1 && !visited[j][k]){
                        bfs(j,k,++temp);
                    }
                }
            }
            long answer = 0;
            answer = Arrays.stream(location)
                    .flatMapToInt(Arrays::stream) //2차원 배열을 1차원으로 스트림 화
                    .filter(num -> num > 0).distinct().count();
            System.out.println(answer);

        }

    }

    private static void bfs(int x, int y, int temp){ // N,M,temp
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        location[x][y] = temp;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int now_x = current[0];
            int now_y = current[1];
            for(int i=0; i < 4; i++){
                int nx = now_x + dx[i];
                int ny = now_y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    location[nx][ny] = temp;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }


}
