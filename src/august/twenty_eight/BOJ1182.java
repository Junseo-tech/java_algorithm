package august.twenty_eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N,S;
    private static int[] numbers;
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        if(S == 0){
            answer--;
        }
        findSum(0,0);

        System.out.println(answer);
    }

    private static void findSum(int count, int tempSum){
        if(count == N){
            if(tempSum == S){
                answer++;
            }
            return;
        }
        findSum(count + 1,tempSum + numbers[count]);
        findSum(count + 1,tempSum);

    }
}
