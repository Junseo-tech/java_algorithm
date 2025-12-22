import java.util.*;
import java.io.*;

/*
*   첫 징검다리는 점프해서 아무거나 밟을 수 있다. 이 점프가 첫 점프이다.
*   두 번째 점프부터는 이전에 점프한 거리보다 1 이상 더 긴 거리를 뛰어야 한다.
*   N번 징검다리는 반드시 밟아야 한다. (1 <= N <= 10^6) => 1초인데 N 개 큼 O(N)도 안됨. O(logN) 해야 함.
*   N번 징검다리를 밟은 후 강 건너로 이동할 땐 점프를 하지 않으므로 위의 규칙이 적용되지 않는다.
*
*   구) 밟을 수 있는 최대의 징검다리 갯수.
*
* */
public class Main {
    private static int T;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine()); // 징검다리의 총 수 N.
            long answer = binarySearch(1,2000000000L, N);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static long binarySearch(long start, long end, long N) {
        long answer = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long temp = mid * (mid + 1) / 2; // mid : 마지막 점프한 거리
            if (temp <= N) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }
}
