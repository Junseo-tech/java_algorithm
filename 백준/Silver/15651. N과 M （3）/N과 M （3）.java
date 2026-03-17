import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static List<int[]> answer;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();

        permutation(0, new int[M]);
        StringBuilder sb = new StringBuilder();
        for(int[] temp : answer) {
            for(int num : temp) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }


    private static void permutation(int depth, int[] temp) {
        if(depth == M) {
            answer.add(temp.clone());
            return;
        }

        for(int i = 1;  i <= N; i++) {
            temp[depth] = i;
            depth++;
            permutation(depth, temp);
            depth--;
        }
    }
}
