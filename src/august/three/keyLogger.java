package august.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class keyLogger {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        // - : 백스페이스
        // 커서 바로 앞에 글자가 존재하면 그 글자를 지운다
        // > < : 오른쪽 왼쪽으로 한 칸 씩
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String pwd = br.readLine();
            Stack<Character> password = new Stack<>();
            for(int j = 0; j < pwd.length(); j++){
                password.push(pwd.charAt(j));
            }
        }
    }

    private String guessPwd(Stack<Character> pwd){
        Stack<Character> answer = new Stack<>();
        Stack<Character> tempStack = new Stack<>();
        while(!pwd.isEmpty()){
            char temp = pwd.pop();
            if(answer.empty()){
                answer.push(temp);
            }
            if (answer.peek().equals("<")){
                answer.pop();
            } else if(answer.peek().equals(">")){
                answer.pop(); // >

            } else if(answer.peek().equals("-")){
                answer.pop();
            } else {
                answer.push(temp);
            }
        }
        return null;
    }

    private static boolean isPass(char c){
        return Character.isUpperCase(c) || Character.isLowerCase(c) || Character.isDigit(c);
    }
}
