package october.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA3307 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine());
        for (int test = 1; test <= t; test++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            LinkedList<Integer> list = new LinkedList<>();
            list.add(-1);
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(st.nextToken());
                if (a >= list.get(list.size() - 1)) {
                    list.add(a);
                    continue;
                }

                int start = 0;
                int end = list.size();
                int mid = 0;

                while (start < end) {
                    mid = (start + end) / 2;

                    if (a > list.get(mid)) {
                        start = mid+1;
                    } else {
                        end = mid;
                    }
                }

                list.remove(end);
                list.add(end, a);
            }
            sb.append("#").append(test).append(" ").append(list.size() - 1).append("\n");
        }
        System.out.println(sb);

    }

}
