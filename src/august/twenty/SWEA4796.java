package august.twenty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SWEA4796 {
    private static int N;
    private static int[] mountains;
    private static int answer;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            sc.nextLine();
            mountains = new int[N];
            answer = 0;
            for (int i = 0; i < N; i++) {
                mountains[i] = sc.nextInt();
            }
            sumMountains();

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);

    }

    private static void sumMountains() {
        int up = 0;
        int down = 0;
        boolean isUp = false;
        for (int i = 1; i < N; i++) {
            if (mountains[i-1] < mountains[i]) {
                if(!isUp){
                    answer += (up * down);
                    up = 0;
                    down = 0;
                }
                up++;
                isUp = true;
            } else {
                down++;
                isUp = false;
            }
        }
        answer += (up * down);
    }
}
