package september.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA2115 {
    private static int N, M, C;
    private static int[][] honey;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<int[]> candidates = new ArrayList<>();
    private static List<int[]> comb = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            honey = new int[N][N];
            candidates.clear();
            comb.clear();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    honey[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N - M; j++) { // j의 시작 좌표 넣어주기
                    candidates.add(new int[]{i, j});
                }
            }

            int[][] chosen = new int[2][2];
            dfs(0, 0, chosen);

            System.out.println("Test case #" + t + ":");
            for (int[] combination : comb) {
                System.out.println("Combination: (" + combination[0] + ", " + combination[1] + ")");
            }
        }
    }

    private static void dfs(int count, int start, int[][] chosen) {
        if (count == 2) {  // 두 사람이 모두 벌통 선택을 완료한 경우
            int[] first = chosen[0];
            int[] second = chosen[1];

            // 두 선택이 겹치는지 확인
            if (first[0] == second[0] && (first[1] + M > second[1])) {
                // 같은 행에 있고 겹친다면 유효하지 않은 선택
                return;
            }

            comb.add(new int[]{first[0], first[1], second[0], second[1]});
            return;
        }

        for (int i = start; i < candidates.size(); i++) {
            chosen[count] = candidates.get(i);
            dfs(count + 1, i + 1, chosen);
        }
    }
}
