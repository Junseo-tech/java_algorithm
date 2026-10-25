import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] arr = new long[4][N];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }

        int size = N * N;
        long[] ab = new long[size];
        long[] cd = new long[size];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ab[idx] = arr[0][i] + arr[1][j];
                cd[idx] = arr[2][i] + arr[3][j];
                idx++;
            }
        }

        Arrays.sort(cd);

        long answer = 0;

        for (long sum : ab) {
            long target = -sum;

            int lower = lowerBound(cd, target);
            int upper = upperBound(cd, target);

            answer += upper - lower;
        }

        System.out.println(answer);
    }

    // target 이상인 첫 번째 위치
    static int lowerBound(long[] arr, long target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // target 초과인 첫 번째 위치
    static int upperBound(long[] arr, long target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}