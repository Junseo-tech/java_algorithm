package september.seven;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1767 {
    private static int N;
    private static int[][] maxi;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<int[]> core = new ArrayList<>();
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int maxConnected;
    private static int minLinked;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            maxi = new int[N][N];

            maxConnected = Integer.MIN_VALUE;
            minLinked = Integer.MAX_VALUE;

            core.clear();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    maxi[i][j] = Integer.parseInt(st.nextToken());
                    if(maxi[i][j] == 1){
                        if(i == 0 || i == N - 1 || j == 0 || j == N - 1) continue;
                        core.add(new int[]{i, j});
                    }
                }
            }
            dfs(0,0,0);
            sb.append("#").append(t).append(" ").append(minLinked).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int count, int connected, int length) {
        if(count == core.size()){
            if(connected > maxConnected) {
                maxConnected = connected;
                minLinked = length;
            } else if(connected == maxConnected) {
                minLinked = Math.min(minLinked, length);
            }
            return;
        }

        int x = core.get(count)[0];
        int y = core.get(count)[1];

        for(int k = 0; k < 4; k++){
            int tempLength = cheackAndPlace(x, y, k);
            if(tempLength != -1) {
                dfs(count + 1, connected + 1, length + tempLength);
                removeWire(x, y, k, tempLength);
            }
        }
        dfs(count + 1, connected,  length);
    }

    private static int cheackAndPlace(int x, int y, int dir) {
        int nx = x;
        int ny = y;
        int length = 0;

        while(true) {
            nx += dx[dir];
            ny += dy[dir];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) { // 끝에 도달
                for(int i = 0; i < length; i++){
                    x += dx[dir];
                    y += dy[dir];
                    maxi[x][y] = 2;
                }
                return length;
            }

            if(maxi[nx][ny] != 0){
                return -1;
            }

            length++;
        }
    }

    private static void removeWire(int x, int y, int dir, int length){
        int nx = x;
        int ny = y;
        for(int i = 0; i < length; i++){
            nx += dx[dir];
            ny += dy[dir];
            maxi[nx][ny] = 0;
        }
    }

}
