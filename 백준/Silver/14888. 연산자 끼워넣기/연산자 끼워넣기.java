import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[] nums;
    private static int[] oper;
    private static int minAns;
    private static int maxAns;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        oper = new int[4];

        st = new StringTokenizer(br.readLine());
        for(int i  = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken()); // 덧셈, 뺄셈, 곱셈, 나눗셈 갯수
        }

        minAns = Integer.MAX_VALUE;
        maxAns = Integer.MIN_VALUE;

        backtracking(0, new int[N-1]);

        System.out.println(maxAns);
        System.out.println(minAns);
    }

    // 연산자들 배치 => 근데 모두 다 배치. 순서가 있음. 중복은 안됨. 순열, n-1 모두 사용
    private static void backtracking(int depth, int[] temp) {
        if(depth == N-1) {
            calculate(temp);
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(oper[i] > 0) {
                temp[depth] = i;
                oper[i] -= 1;
                backtracking(depth + 1, temp);
                oper[i] += 1;
            }
        }
    }

    private static void calculate(int[] temp) {
        int temAns = nums[0];
        for (int i = 1; i < N; i++) {
            if (temp[i - 1] == 0) {
                    temAns += nums[i];
            } else if (temp[i - 1] == 1) {
                    temAns -= nums[i];
            } else if (temp[i - 1] == 2) {
                    temAns *= nums[i];
            } else {
                    temAns /= nums[i];
            }

        }

            minAns = Math.min(minAns, temAns);
            maxAns = Math.max(maxAns, temAns);
        }
    }

