import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class free {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static List<int[]> days = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int T = Integer.parseInt(input[0]);
            int W = Integer.parseInt(input[1]);
            days.add(new int[]{T, W});
        }
        days.add(new int[]{0, 0});  // N+1번째 인덱스에 빈 값 추가
        checkMoney();
    }

    private static void checkMoney(){
        int[] dp = new int[N + 2];
        int max = 0;  // max 변수를 0으로 초기화하여 초기 비교값이 되도록 설정

        for (int i = 0; i <= N; i++) {
            int day = days.get(i)[0];
            int money = days.get(i)[1];

            if (max < dp[i]) { // 해당 인덱스로 온 최대값을 나타냄
                max = dp[i];
            }
            int nxt = i + day;
            if (nxt < N + 2) {
                dp[nxt] = Math.max(dp[nxt], max + money);
            }
        }
        System.out.println(dp[N]);  // N번째 값을 출력
    }
}
