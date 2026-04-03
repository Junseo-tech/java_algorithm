// 나누고 나머지 연산
import java.util.*;

class Number implements Comparable<Number> {
    int number;
    public Number(int number) {
        this.number = number;
    }
    
    public int compareTo(Number n) {
        String case1 = this.number + "" + n.number;
        String case2 = n.number + "" + this.number;
        return case2.compareTo(case1);
    }
    
}
class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<Number> pq = new PriorityQueue<>();
        String answer = "";
        for(int i = 0; i < numbers.length; i++) {
            pq.add(new Number(numbers[i]));
        }
        
        if(pq.peek().number == 0) {
            return "0";
        }
        
        while(!pq.isEmpty()) {
            answer += pq.poll().number;
        }
        
        return answer;
    }
}