import java.util.*;
import java.io.*;

public class Main {
    private static int N, M; // 1 <= N,M <= 100,000
    private static int[] dot;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException { // O(M * logN + N * logN)

        // 점이 있기 때문에 해당 배열에서 갯수를 정해야 한다. 따라서 주어진 선의 범위의 각각의 점 인덱스를 찾아서 계산해주면 된다.
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dot = new int[N]; // 점의 갯수

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            dot[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dot); // O(NlogN)

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(start > end) { // 두 점이 정렬되어서 나온다는 말이 없다. 따라서 바꿔 줘야 한다.
                int temp = start;
                start = end;
                end = temp;
            }

//            if(start > dot[N-1]||end < dot[0]) { // 아예 벗어난 경우도 따져야 한다.
//                sb.append(0).append("\n");
//                continue;
//            }


            int lower = findLower(0, N-1, start); // 하한의 인덱스를 찾는다.
            int upper = findUpper(0, N-1, end); // 상한의 인덱스를 찾는다.

            sb.append(upper - lower + 1).append("\n");

        }

        System.out.println(sb);
    }


    private static int findLower(int start, int end, int target) { // O(logN)
        int ans = N;
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

    private static int findUpper(int start, int end, int target) { // O(logN)
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(target < dot[mid]) {  // dot[mid] < target
                end = mid - 1;
            } else { // dot[mid] <= target
                start = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }


}
