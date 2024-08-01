package july.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Dasom {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        if(N <= 1){
            System.out.println(0);
        } else {
            int[] candidate = new int[N-1];
            for (int i = 0; i < N-1; i++) {
                candidate[i] = Integer.parseInt(br.readLine());
            }
            int count = 0;
            while(true) {
                Arrays.sort(candidate);
                if(dasom > candidate[candidate.length-1]){
                    System.out.println(count);
                    break;
                }
                candidate[candidate.length-1] -= 1;
                dasom += 1;
                count += 1;
            }
        }
    }
}
