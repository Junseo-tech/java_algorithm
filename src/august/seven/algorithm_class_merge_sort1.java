package august.seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algorithm_class_merge_sort1 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private  static int [] A;
    private static int K;
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        merge_sort(0, N - 1);
        if (count < K) {
            System.out.println(-1);
        }
    }

    private static void merge_sort(int p, int r){
        int count = 0;
        if(p < r){
            int q = (p+r) / 2;
            merge_sort(p,q);
            merge_sort(q+1,r);
            merge(p,q,r);
        }
    }

    private static void merge(int p, int q, int r){
        int[] temp = new int[r-p+1];
        int i = p;
        int j = q+1;
        int t = 0;
        while (i <= q && j <= r) {
            if(A[i] <= A[j]){
                temp[t++] = A[i++];
            } else {
                temp[t++] = A[j++];
            }
        }
        while (i <= q){
            temp[t++] = A[i++];
        }
        while (j <= r){
            temp[t++] = A[j++];
        }
        for(i=p,t=0;i<=r;i++,t++){
            A[i] = temp[t];
            count++;
            if(count == K){
                System.out.println(A[i]);
                return;
            }
        }

    }
}
