import java.util.*;
import java.io.*;


public class Main {
    private static int N;
    private static char[] now;
    private static int[] alphaCount; // 알파벳 26개
    private static StringBuilder sb;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            now = new char[line.length()];
            alphaCount = new int[26];
            for(int j = 0; j < line.length(); j++) {
                alphaCount[line.charAt(j) - 'a']++;
            }
            permutation( 0, line.length());

        }

        System.out.println(sb);

    }


    private static void permutation(int depth, int length) {
        if(depth == length) {
            for(int i = 0; i < length; i++) {
                sb.append(now[i]);
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < 26; i++) {
            if(alphaCount[i] > 0) {
                now[depth] = (char) (i + 'a');
                depth++;
                alphaCount[i]--;
                permutation(depth, length);
                depth--;
                alphaCount[i]++;
            }
        }
    }

}
