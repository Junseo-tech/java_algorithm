package august.twenty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class delivery_sugar {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int five = N / 5;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while(five >= 0){
            int remainder = N - (5 * five);
            if(remainder % 3 == 0){
                int num = remainder / 3;
                sum = num + five;
                if(min > sum){
                    min = sum;
                }
            }
            five--;
        }

        if(sum == 0){
            sb.append("-1");
        } else {
            sb.append(min);
        }
        System.out.println(sb);
    }
}
