package september.twenty_six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2240 {
    private static int T,W;
    private static int[][] dp;
    private static int[] apple;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        dp = new int[T + 1][W + 1];
        apple = new int[T];
        for(int i = 0; i < T ; i++) {
            apple[i] = Integer.parseInt(br.readLine());
        }
    }

    private static void knapsack() {
        for(int i = 1; i <= T; i++) {

        }
    }
}
