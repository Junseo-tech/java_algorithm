package august.twenty_six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1931 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] time;
    private static int N;
    private static int answer = 0;

    // 종료 시간이 빠른 순으로 정렬
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        time = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        solve();
        System.out.println(answer);
    }

    private static void solve(){
        int temp_finish_time = 0;
        for (int i = 0; i < N; i++) {
            if(temp_finish_time <= time[i][0]) {
                temp_finish_time = time[i][1];
                answer++;
            }
        }
    }
}
