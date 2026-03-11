import java.util.*;
import java.io.*;


// stack에 push하는 순서는 오름차순을 지켜야 함
// 1 부터 n 까지의 수를 스택에 넣고 연산을 해서 주어진 수열이 만들어지는지 확인한다.

public class Main {
    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final String NO = "NO";
    private static Deque<Integer> stack;
    private static int n;
    private static int lastPushNum;
    private static StringBuilder sb;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {

        sb = new StringBuilder();
        stack = new ArrayDeque<>();
        n = Integer.parseInt(br.readLine());

        lastPushNum = 0;
        for(int i = 0; i < n; i++) {
            int target = Integer.parseInt(br.readLine());
            int answer = makeSequence(target);
            if(answer < 0){
                System.out.println(NO);
                return;
            }
        }
        System.out.println(sb);
    }

    private static int makeSequence(int target) {
        while(lastPushNum < target) {
            lastPushNum++;
            stack.push(lastPushNum);
            sb.append(PLUS).append("\n");
        }

        if(stack.peek() == target) {
            int pop = stack.pop();
            sb.append(MINUS).append("\n");
            return 1;
        }

        if(stack.peek() > target) {
            return -1;
        }

        return -1;
    }
}

