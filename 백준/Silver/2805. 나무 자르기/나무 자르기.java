import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static long M;
    private static int[] trees; // N개
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long answer;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        trees = new int[N];
        answer = 1;

        st = new StringTokenizer(br.readLine());

        int maxHeight = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, trees[i]);
        }


        binarySearch(0, maxHeight);
        System.out.println(answer);

    }


    private static void binarySearch(int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            long cutting = 0;
            for(int i = 0; i < N; i++) {
                long temp = trees[i] - mid;
                if(temp >= 0) cutting += temp;
            }

            if(cutting < M) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;

            }
        }
    }
}
