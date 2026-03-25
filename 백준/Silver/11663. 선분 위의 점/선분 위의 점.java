import java.util.*;
import java.io.*;

public class Main {
    private static int N, M; // 1 <= N,M <= 100,000
    private static int[] dot;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dot = new int[N]; // 점의 갯수

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            dot[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dot);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start > end) {
                int temp = start;
                start = end;
                end = temp;
            }

            if(start > dot[N-1]||end < dot[0]) {
                sb.append(0).append("\n");
                continue;
            }


            int lower = findLower(0, N-1, start);
            int upper = findUpper(0, N-1, end);

            sb.append(upper - lower + 1).append("\n");

        }

        System.out.println(sb);
    }


    private static int findLower(int start, int end, int target) {
        int ans = 0;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target <= dot[mid]) {
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static int findUpper(int start, int end, int target) {
        int ans = 0;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target < dot[mid]) { // 60 >
                end = mid - 1;
            } else { // target >= dot[mid].  60 >= 30
                start = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }


}
