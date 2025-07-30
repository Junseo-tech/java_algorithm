import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 산성 용액과 알칼리성 용액의 특성 값이 정렬 순서로 주어짐
// 구 ) 서로 다른 용액을 혼합하여 특성 값이 0에 가까운 용액을 만들어 내는 두 용액을 구하라 => 절대값 씌우기
public class Main {
    private static int N;
    private static long[] solutions;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long answerA, answerB;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        solutions = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            solutions[i] = Long.parseLong(st.nextToken());
        }

        answerA = 0L;
        answerB = 0L;

        binarySearch(0, N - 1);

        System.out.println(answerA + " " + answerB);



    }

    private static void binarySearch(int start, int end) {
        long answer = Long.MAX_VALUE;
        while(start < end) {
            long currentSum = solutions[start] + solutions[end];
            if (Math.abs(currentSum) < answer) {
                answer = Math.abs(currentSum);
                answerA = solutions[start];
                answerB = solutions[end];

            }

            if(currentSum > 0) {
                end--;
            } else {
                start++;
            }
        }
    }
}
