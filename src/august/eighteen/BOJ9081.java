package august.eighteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ9081 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static char[] words;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        words = new char[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words = word.toCharArray();

        }
    }
}
