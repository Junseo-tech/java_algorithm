package july.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Math_homework {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] codes = new String[N];
        for (int i = 0; i < N; i++) {
            codes[i] = br.readLine();
        }
        BigInteger[] answer = new BigInteger[N * 10];
        int index = 0;

        for(int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < codes[i].length(); j++) {
                if(isDigit(codes[i].charAt(j))){
                    sb.append(codes[i].charAt(j));
                } else {
                    if(sb.length() > 0) {
                        answer[index++] = new BigInteger(sb.toString());
                        sb.setLength(0);
                    }
                }
            }
            if(sb.length() > 0){
                answer[index++] = new BigInteger(sb.toString());
            }
        }

        BigInteger[] result = Arrays.copyOf(answer, index); // 정렬 하려면 사용 한 부분만큼 잘라주기
        Arrays.sort(result);
        for(int i = 0; i < index; i++) {
            System.out.println(result[i]);
        }
    }

    static boolean isDigit(char c){
        return Character.isDigit(c);
    }
}
