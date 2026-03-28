import java.util.*;
import java.io.*;

// 같은 양의 두 용액을 혼합해서 특성값이 0에 가장 가까운 용액을 만든다.
// 절대값으로 계산하자. 0이랑 가까운지만 판단하면 되니까.
public class Main {
    private static int N;
    private static long[] solutions;
    private static long ans;
    private static long x, y;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        N = Integer.parseInt(br.readLine());
        solutions = new long[N];

        ans = Long.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            solutions[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(solutions);

        binarySearch(0, N-1);
        System.out.println(x + " " + y);
    }


    private static void binarySearch(int start, int end) {
        while(start < end) {
            long now = solutions[start] + solutions[end];

            if(Math.abs(now) <= ans) {
                ans = Math.abs(now);
                x = solutions[start];
                y = solutions[end];
            }

            if(now < 0) {
                start++;
            } else {
                end--;
            }
        }
    }
}
