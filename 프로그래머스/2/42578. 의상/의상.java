import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> kind = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            kind.put(clothes[i][1], kind.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int temp = 1;
        for(Map.Entry<String, Integer> entry : kind.entrySet()) {
            int num = entry.getValue() + 1;
            temp *= num;
        }
        
        answer = temp - 1;
        return answer;
    }
}