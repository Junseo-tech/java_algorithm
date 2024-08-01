package july.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class permutation_restore {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] tree;
    private static int[] arr;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        answer = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // Initialize segment tree
        tree = new int[N * 4];
        initTree(1, N, 1);

        // Recover permutation from inversion sequence
        for (int i = N; i >= 1; i--) {
            int left = 1;
            int right = N;
            while (left < right) {
                int mid = (left + right) / 2;
                if (query(1, N, 1, left, mid) >= arr[i] + 1) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            answer[left] = i;
            update(1, N, 1, left);
        }

        // Print the result
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    // Initialize the segment tree
    private static void initTree(int start, int end, int node) {
        if (start == end) {
            tree[node] = 1; // All positions are initially available
            return;
        }
        int mid = (start + end) / 2;
        initTree(start, mid, node * 2);
        initTree(mid + 1, end, node * 2 + 1);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    // Query the segment tree to find the count of available positions in the range
    private static int query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return 0; // Out of range
        }
        if (left <= start && end <= right) {
            return tree[node]; // Exact range
        }
        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
    }

    // Update the segment tree to mark the position as used
    private static void update(int start, int end, int node, int index) {
        if (start == end) {
            tree[node] = 0; // Mark this position as used
            return;
        }
        int mid = (start + end) / 2;
        if (index <= mid) {
            update(start, mid, node * 2, index);
        } else {
            update(mid + 1, end, node * 2 + 1, index);
        }
        tree[node] = tree[node * 2] + tree[node * 2 + 1]; // Update the parent node
    }
}
