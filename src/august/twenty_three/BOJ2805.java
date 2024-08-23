package august.twenty_three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static int[] trees;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);
        System.out.println(getWood());
    }

    private static long getWood() {
        long start = 0;
        long end = trees[N - 1];
        long maxHeight = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long temp = 0;

            for (int i = 0; i < N; i++) {  // 나무 높이 전체를 순회
                if (trees[i] > mid) {  // 나무 높이가 현재 높이보다 클 때
                    temp += trees[i] - mid;
                }
            }

            if (temp >= M) {  // 원하는 나무 양보다 많이 가져왔으면
                maxHeight = mid;  // 이 높이가 가능한 최대 높이
                start = mid + 1;  // 더 높은 높이에서 탐색
            } else {  // 원하는 나무 양보다 적게 가져왔으면
                end = mid - 1;  // 더 낮은 높이에서 탐색
            }
        }

        return maxHeight;
    }
}
