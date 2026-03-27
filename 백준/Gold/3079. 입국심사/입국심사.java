import java.util.*;
import java.io.*;

// 최소 시간을 구하는 거
// 시간에 각 심사대 별 걸리는 시간을 나눠서 인원 수가 나오면 된다. 동시에 일어나는 거니까
public class Main {
    private static int N; //  N : 입국 심사대 갯수
    private static long M; // M : 상근이와 친구들
    private static int[] time;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        time = new int[N];

        for(int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }

        long answer = binarySearch(1, 1000000000 * M);
        System.out.println(answer);
    }

    private static long binarySearch(long start, long end) {
        long ans = 0;
        while(start <= end) {
            long mid = start + (end - start) / 2;
            long temp = 0;

            for(int i = 0; i < N; i++) {
                temp += (mid / time[i]); // 10억 * 5억 / 1 이 창구가 9,999만개면 대략 2^75로 2^64를 넘어선다 (long)
                if(temp > M) break; // 10억 시간이 시작되는 창구 * 10억명 이면 첫번째에서 Mid가 10억 * 5억이니까 
            }

            if(temp < M) {
                start = mid + 1;
            } else {
                end = mid - 1;
                ans = mid;
            }
        }

        return ans;
    }
}
