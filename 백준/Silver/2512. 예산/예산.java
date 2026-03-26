import java.util.*;
import java.io.*;

// 정해진 총액 이하에서 가능한 최대의 총 예산
public class Main {
    private static int N;
    private static long M;
    private static int[] budget;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        N = Integer.parseInt(br.readLine());
        budget = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, budget[i]);
        }

        M = Long.parseLong(br.readLine()); // 상한액
        long answer = binarySearch(0 , max);
        System.out.println(answer);
    }

    private static long binarySearch(int start, int end) {
        int ans = 0;
        while(start <= end) {
            int now = 0;
            int mid = start + (end - start) / 2; // 상한액

            for(int i = 0; i < N; i++) {
                if(mid < budget[i]) { // 상한액이 예산보다 더 작으면
                    now += mid;
                } else { // 상한액이 예산보다 크거나 같으면
                    now += budget[i];
                }
            }

            if(now > M) {
                end = mid - 1;
            } else {
                start = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
