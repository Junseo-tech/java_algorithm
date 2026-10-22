import java.util.*;
import java.io.*;

// 게임이 가장 적게 지속될 떄와, 가장 오래 지속 될 때의 횟수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long m = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long minAns = Long.MAX_VALUE;
        long maxAns = Long.MIN_VALUE;

        for(long i = a; i <= b; i++) {
            long temp = binarySearch(1, m, i);
            minAns = Math.min(minAns, temp);
            maxAns = Math.max(maxAns, temp);
        }

        System.out.print(minAns + " " + maxAns);

    }

    private static long binarySearch(long start, long end, long computer) {
        long mid = (end - start) / 2 + start;
        long count= 0;
        while(start <= end) {
            count++;
            mid = (end - start) / 2 + start;

            if(mid < computer) {
                start = mid + 1;
            } else if(mid == computer) {
                return count;
            } else {
                end = mid - 1;
            }
        }
        return count;
    }
}