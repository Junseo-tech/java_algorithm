package august.twenty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ16345 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N,L;
    private static int[] fruits;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        fruits = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(fruits);

        for(int i = 0; i < N; i++) {
            if(L >= fruits[i]) {
                L++;
            }
        }
        System.out.println(L);
    }

}
