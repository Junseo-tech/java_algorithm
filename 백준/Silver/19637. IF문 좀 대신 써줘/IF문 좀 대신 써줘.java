import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static String[] name;
    private static int[] stat;
    private static int[] character;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        name = new String[N];
        stat = new int[N];
        character = new int[M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            stat[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            character[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int answer = binarySearch(0, N - 1, character[i]);
            sb.append(name[answer]).append("\n");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int start, int end, int now) {
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(stat[mid] >= now) { // 10000 >= 9999
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
