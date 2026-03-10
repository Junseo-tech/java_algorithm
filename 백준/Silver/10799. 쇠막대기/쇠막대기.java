import java.util.*;
import java.io.*;

public class Main {
    private static Deque<Character> stack;
    private static final char LEFT = '(';
    private static final char RIGHT = ')';
    private static int answer;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        stack = new ArrayDeque<>();

        String line = br.readLine();
        answer = 0;

        stack.push(line.charAt(0));
        char prev = line.charAt(0);
        for(int i = 1; i < line.length(); i++) {
            if(line.charAt(i) == LEFT) stack.push(line.charAt(i));
            if(line.charAt(i) == RIGHT && prev == LEFT) {
                stack.pop();
                answer += stack.size();
            }
            if(line.charAt(i) == RIGHT && prev == RIGHT) {
                stack.pop();
                answer++;
            }
            prev = line.charAt(i);
        }

        System.out.println(answer);


    }
}
