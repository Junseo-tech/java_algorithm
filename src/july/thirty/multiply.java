package july.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class multiply {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int A = Integer.parseInt(br.readLine());
        String B = br.readLine();

        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;

        int B1 = Integer.parseInt(B.substring(2,3)); // begin 인덱스부터 end 인덱스 직전
        int B2 = Integer.parseInt(B.substring(1,2));
        int B3 = Integer.parseInt(B.substring(0,1));

        three = A * B1;
        four = A * B2;
        five = A * B3;
        six = A * Integer.parseInt(B);

        StringBuilder sb = new StringBuilder();
        sb.append(three).append("\n").append(four).append("\n").append(five).append("\n").append(six);
        System.out.println(sb);
        }
}
