// 뒤에 있는 기능이 먼저 완성되어도 앞 기능이 배포될 때 함께 된다.
// 각 배포마다 몇 개의 기능이 배포되는지 구하라
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int n = progresses.length;
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            int days = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) days++;
            queue.add(days);
        }
        
        int prev = queue.poll(); // 7
        int count = 1;
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int num = queue.poll(); // 3 9
            if(prev >= num) {
                count++; // 2
            } else {
                prev = num; 
                result.add(count);
                count = 1;
            }
        }
        result.add(count);
        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}