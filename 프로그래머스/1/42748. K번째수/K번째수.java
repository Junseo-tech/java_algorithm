// i부터 j까지 자르고 그 안에서 k번째에 있는 숫자 구하기
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int goal = commands[i][2];
            
            answer[i] = findNum(start, end, goal, array);
        }
        
        return answer;
    }
    
    private static int findNum(int start, int end, int goal, int[] array) {
        
        int[] newArray = Arrays.copyOfRange(array, start - 1, end);
        Arrays.sort(newArray);
//         int[] newArray = new int[end - start + 1];
        
//         int idx = 0;
//         for(int i = start - 1; i < end; i++) {
//             newArray[idx] = array[i];
//             idx++;
//         }
        
//         Arrays.sort(newArray);
        
         return newArray[goal-1];
    }
}