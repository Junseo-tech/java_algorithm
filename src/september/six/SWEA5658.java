package september.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA5658 {
    private static int N,K;
    private static String input;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> list = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            input = br.readLine();
            String endPoint = input + input.substring(0, (N / 4) - 1);
            for(int i = 0; i < N; i++) {
                int temp = Integer.parseInt(endPoint.substring(i, i + N/4), 16);
                if(!list.contains(temp)) {
                    list.add(temp);
                }
            }
            Collections.sort(list, Collections.reverseOrder());
            sb.append("#").append(t).append(" ").append(list.get(K-1)).append("\n");
        }
        System.out.println(sb);
    }
}
