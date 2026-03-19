import java.util.*;
import java.io.*;

public class Main {
    private static int N,M;
    private static StringBuilder answer;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        comb(0, 1, new int[M], new boolean[N + 1]);

        System.out.println(answer);
    }

    private static void comb(int depth, int start, int[] num, boolean[] visited) {
        if(depth == M) {
            for(int i = 0; i < M; i++) {
                answer.append(num[i]).append(" ");
            }
            answer.append("\n");
            return;
        }
        for(int i = start; i <= N; i++) {
            if(!visited[i]) {
                num[depth] = i;
                visited[i] = true;
                comb(depth + 1, i + 1, num, visited);
                visited[i] = false;
            }
        }
    }
}
