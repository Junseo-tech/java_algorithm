import java.util.*;
import java.io.*;

// 중복된 알파벳이 나올 수 있음, 같은 애너그램은 안됨. 정렬해서 되어야 함.
public class Main {
    private static int N;
    private static int[] alpha;
    private static StringBuilder sb;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            alpha = new int[26];
            for(int j = 0; j < line.length(); j++) {
                int num = line.charAt(j) - 'a';
                alpha[num] += 1;
            }
            backtracking(0, new int[line.length()], line.length());
        }

        System.out.println(sb);
    }



    private static void backtracking(int depth, int[] gram, int length) {
        if(depth == length) {
            for(int i = 0; i < length; i++) {
                char temp = (char) (gram[i] + 'a');
                sb.append(temp);
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < 26; i++) {
            if(alpha[i] > 0) {
                alpha[i] -= 1;
                gram[depth] = i;
                backtracking(depth + 1, gram, length);
                alpha[i] += 1;
            }
        }
    }
}
