import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[] nums;
    private static int x;
    private static int answer;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());
        Arrays.sort(nums);
        answer = 0;
        twoPointer(0, N-1);
        System.out.println(answer);
    }

    private static void twoPointer(int start, int end) {
        while(start < end) {
            int num = nums[start] + nums[end];
            if(num == x) {
                answer++;
                start++;
                end--;
            } else if(num < x) {
                start++;
            } else {
                end--;
            }
        }
    }
}
