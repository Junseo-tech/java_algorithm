import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int M,N; // M : 조카의 수 , N : 과자의 수
    private static int[] snacks;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        snacks = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            if(max < snacks[i]) {
                max = snacks[i];
            }
        }

        int result = binarySearch(max);
        System.out.println(result);

    }

    private static int binarySearch(int max) {
        int start = 1;
        int end = max;
        int result = 0;
        while(start <= end) {
            int mid = (start + end) / 2;

            int temp = 0;
            for(int i = 0; i < N; i++) {
                temp += snacks[i] / mid; // 더하기
            }

            if(temp >= M) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}