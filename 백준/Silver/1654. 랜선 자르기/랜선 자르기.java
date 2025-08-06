import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N개보다 많이 만드는 것도 N개를 만드는 것에 포함
// 구 ) 최대 랜선의 길이를 구하라
public class Main {
    private static int N, K; // N : 만들어야 하는 랜선 수, K : 가지고 있는 랜선, 길이 제각각
    private static int[] lines;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lines = new int[K];
        int maxNum = Integer.MIN_VALUE;

        for(int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            maxNum = Math.max(maxNum, lines[i]);
        }

        // 구하는 답은 최대 랜선의 길이, 종료되는 조건은 N 이상일 때
        // 길이를 잡고 안되면 줄이는 방식으로 가야 할 거 같음. N 보다 작으면 값을 줄이는. mid가 답이되는 형식의 이분 탐색 ?
        // 457 539 743 802


        long result = binarySearch(1, maxNum);
        System.out.println(result);

    }

    private static long binarySearch(long start, long end) {
        long result = 0;
        while(start <= end) {
            long mid = start + (end - start) / 2; // ex. 629

            int temp = 0;
            for(int i = 0; i < K; i++) {
                temp += lines[i] / mid;
            }

            if(temp < N) {
                end = mid - 1;
            } else { // 현재 갯수가 N개
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }
}
