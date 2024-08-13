import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class hamster {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, X, M;
    private static List<int[]> commands = new ArrayList<>();
    private static int[] bestAnswer;
    private static int maxSum = -1;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]); // 우리 갯수
            X = Integer.parseInt(input[1]); // 각 우리 햄스터의 최댓값
            M = Integer.parseInt(input[2]); // 남긴 기록의 수

            for (int i = 0; i < M; i++) {
                String[] input2 = br.readLine().split(" ");
                int L = Integer.parseInt(input2[0].trim()) - 1;
                int R = Integer.parseInt(input2[1].trim()) - 1;
                int S = Integer.parseInt(input2[2].trim());
                commands.add(new int[]{L, R, S});
            }

            bestAnswer = null;
            maxSum = -1;
            makeSequence(0, new int[N], 0);

            sb.append("#").append(tc).append(" ");
            if (bestAnswer != null) {
                for (int i = 0; i < N; i++) {
                    sb.append(bestAnswer[i]).append(" ");
                }
            } else {
                sb.append("-1");
            }
            sb.append("\n");

            commands.clear();
        }

        System.out.println(sb);
    }

    static void makeSequence(int depth, int[] chosen, int currentSum) {
        if (depth == N) {
            if (isGoodSequence(chosen) && currentSum > maxSum) {
                maxSum = currentSum;
                bestAnswer = chosen.clone();
            }
            return;
        }

        for (int i = 0; i <= X; i++) {
            chosen[depth] = i;
            if (currentSum + i <= 60) {
                makeSequence(depth + 1, chosen, currentSum + i);
            }
        }
    }

    static boolean isGoodSequence(int[] chosen) {
        for (int[] command : commands) {
            int sum = 0;
            for (int i = command[0]; i <= command[1]; i++) {
                sum += chosen[i];
            }
            if (sum != command[2]) {
                return false;
            }
        }
        return true;
    }
}
