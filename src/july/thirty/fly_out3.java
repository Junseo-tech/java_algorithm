package july.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class fly_out3 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] section;
    public static void main(String[] args) throws IOException {
        int[] dxPlus = {-1,1,0,0};
        int[] dyPlus = {0,0,-1,1};
        int[] dxX = {-1,-1,1,1};
        int[] dyX = {1,-1,-1,1};

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken()); // m = 스프레이 세기
            section = new int[n][n]; // 배열 정의, 각 파리의 개체 수가 있음

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    section[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int candidate1 = goPlus(n , i, j, m, dxPlus, dyPlus);
                    int candidate2 = goX(n , i, j, m, dxX, dyX);
                    int candidate = Math.max(candidate1, candidate2);
                    answer = Math.max(answer, candidate);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(answer).append("\n");
            System.out.println(sb);
        }

    }

    private static int goX(int n, int x, int y, int m, int[] dxX, int[] dyX){
        int count = section[x][y];
        int maxNum = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = x + dxX[j] * i;
                int ny = y + dyX[j] * i;
                if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                    count += section[nx][ny];
                }
            }
            maxNum = Math.max(maxNum, count);
        }
        return maxNum;
    }

    private static int goPlus(int n, int x, int y, int m, int[] dxPlus, int[] dyPlus){
        int count = section[x][y];
        int maxNum = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < 4; j++) {
                int nx = x + dxPlus[j] * i;
                int ny = y + dyPlus[j] * i;

                if(nx >= 0 && ny >= 0 && nx < n && ny < n ){
                    count += section[nx][ny];
                }
            }
            maxNum = Math.max(maxNum, count);
        }
        return maxNum;
    }


}
