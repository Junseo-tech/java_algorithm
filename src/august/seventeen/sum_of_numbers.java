package august.seventeen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sum_of_numbers {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N,M;
    private static int[] numbers;
    private static int answers;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        sumOfNumbers();
        System.out.println(answers);
    }

    private static void sumOfNumbers() {
        int start = 0;
        int end = 0;
        int currentSum = 0;
        while(end < N){
            currentSum += numbers[end];
            while(currentSum > M && start <= end){
                currentSum -= numbers[start];
                start++;
            }
            if(currentSum == M){
                answers++;
            }
            end++;
        }
    }
}
