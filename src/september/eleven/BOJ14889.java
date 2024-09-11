package september.eleven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
    private static int N;
    private static int[][] game;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int start;
    private static int link;
    private static int answer;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        game = new int[N][N];

        start = 0;
        link = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, new int[N / 2]);
        System.out.println(answer);
    }

    private static void dfs(int count, int idx, int[] chosen) {
        if(count == N / 2) {
            start = countStrength(chosen, 0, new boolean[N / 2], new int[N / 2]);

            boolean[] isChosen = new boolean[N];
            for (int i = 0; i < N / 2; i++) {
                isChosen[chosen[i]] = true;
            }

            int[] remaining = new int[N / 2];
            int index =0;
            for (int i = 0; i < N / 2; i++) {
                if(!isChosen[i]) {
                    remaining[index++] = i;
                }
            }
            link = countStrength(remaining, 0, new boolean[N / 2], new int[N / 2]);
            answer = Math.min(answer, start - link);
            return;
        }
        for(int i = idx; i < N; i++) {
            chosen[count] = i;
            dfs(count + 1, i + 1, chosen);
        }
    }

    private static int countStrength(int[] candidate, int count, boolean[] visited, int[] chosen) {
        if(count == 2){
            int x = chosen[0];
            int y = chosen[1];
            int now = game[x][y] + game[y][x];
            return now;
        }
        int total = 0;
        for(int i = 0; i < N / 2; i++) {
            if(!visited[i]) {
                visited[i] = true;
                chosen[count] = candidate[i];
                total += countStrength(candidate, count + 1, visited, chosen);
                visited[i] = false;
            }
        }
        return total;
    }
}
