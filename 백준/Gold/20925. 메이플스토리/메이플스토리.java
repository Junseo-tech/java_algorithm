import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        //던전별 최소경험치와 분당 얻는 경험치
        int[][] dungeon = new int[n][2];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            dungeon[i][0] = Integer.parseInt(st.nextToken());
            dungeon[i][1] = Integer.parseInt(st.nextToken());
        }

        //각 던전별 이동 시간
        int[][] move = new int[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                move[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dp[i][j] : i초까지 사냥했고 j번째에서 사냥을 끝마쳤을때 경험치 최댓값
        int[][] dp = new int[t+1][n];

        for(int i = 1; i<=t; i++){
            for(int j = 0; j<n; j++){
                //던전을 이동하지 않고 제자리 사냥 (이때, 현재 경험치가 제한 조건을 만족해야됨)
                if(dp[i-1][j] >= dungeon[j][0]) dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + dungeon[j][1]);
                for(int k = 0; k<n; k++){
                    //던전을 이동해서 온 경우 (k던전에서 j로 이동)
                    int prev = i - move[k][j]; //j로 오기전, k에서의 시간
                    if(j == k || prev<0) continue; //현재 시간으로 못오거나 이전꺼랑 같은거면 무시
                    //j던전에 입장하기 위한 충분한 경험치를 소지하고 있을 경우에만 최댓값 갱신
                    if(dp[prev][k] >= dungeon[j][0])dp[i][j] = Math.max(dp[prev][k], dp[i][j]);
                }
            }
        }

        //방학이 끝나는 시점에서 어느 던전에서 마무리한게 가장 최대의 경험치인가?
        int max = 0;
        for(int i = 0; i<n; i++){
            max = Math.max(max, dp[t][i]);
        }

        System.out.println(max);
    }

}