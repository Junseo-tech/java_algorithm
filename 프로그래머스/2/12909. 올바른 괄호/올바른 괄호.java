import java.util.*;

// 괄호가 올바른 괄호이면 true, 아니면 false
class Solution {
    static Deque<Character> stack;
    boolean solution(String s) {
        boolean answer = true;
        stack = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.add('(');
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pollLast();
            }
        }
        
        if(!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}