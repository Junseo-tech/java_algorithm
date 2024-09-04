package september.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2117 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N,M;
    private static int[][] town;
    private static int maxHome;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken()); // 지불 비용

            town = new int[N][N];
            maxHome = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    town[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solve();
            sb.append("#").append(t).append(" ").append(maxHome).append("\n");
        }
        System.out.println(sb);
    }

    private static void solve() {
        for(int k = 1; k <= N+1; k++){
            int cost = k * k + (k-1) * (k-1);
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    int x = i;
                    int y = j;
                    int home = 0;
                    for(int nx = 0; nx < N; nx++){
                        for(int ny = 0; ny < N; ny++){
                            if(Math.abs(x - nx) + Math.abs(y - ny) < k && town[nx][ny] == 1){
                                home++;
                            }
                        }
                    }
                    int temp_cost = home * M - cost;
                    if(temp_cost >= 0 && maxHome < home){
                        maxHome = home;
                    }
                }
            }
        }
    }
}
