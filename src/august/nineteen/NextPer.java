package august.nineteen;

import java.util.Arrays;
import java.util.Scanner;

public class NextPer {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        Arrays.sort(input);

        do {
            System.out.println(Arrays.toString(input));
        } while (np(input));
    }
    static boolean np(int[] p) { // boolean : true => 다음 순열 존재, false => 다음 순열 없음
        int N = p.length;

        // step 1) 꼭대기 찾기
        int i = N - 1;
        while (i > 0 && p[i - 1] >= p[i]) --i;

        if (i == 0) return false;

        // step 2) 꼭대기 앞 교환 위치에 교환할 값 자리 찾기 (i-1 위치 값보다 큰 값중 가장 작은 값)
        int j = N - 1;
        while (p[i - 1] >= p[j]) --j;

        // step 3) 두 위치 수 교환
        swap(p, i-1,j);

        // stemp 4) 꼭대기부터 맨 뒤까지 오름차순의 형태로 만들자
        int k = N-1;
        while(i < k){
            swap(p, i++, k--);
        }
        return true;
    }

    static void swap(int[] p, int i, int j) {
        int temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }
}
