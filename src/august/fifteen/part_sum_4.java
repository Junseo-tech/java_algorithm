package august.fifteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class part_sum_4 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N,M;
    private static int[] numbers;
    private static List<int[]> commands = new ArrayList<>();
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        dp = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            commands.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        sum();
    }

    private static void sum(){
        StringBuilder sb = new StringBuilder();
        dp[0] = 0;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + numbers[i-1];
        }
        for(int c = 0; c < M; c++){
            int[] temp = commands.get(c);
            int start = temp[0];
            int end = temp[1];
            sb.append(dp[end] - dp[start-1]).append("\n");
        }
        System.out.println(sb);
    }
}
