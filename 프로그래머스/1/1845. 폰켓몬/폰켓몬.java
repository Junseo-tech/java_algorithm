// N 마리 중에 N/2마리 => 최대한 다양한 폰켓몬 선택 
// return => 포켓몬 종류 
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length / 2;
        HashMap<Integer, Integer> maps = new HashMap<>();
        
        for(int num : nums) {
            maps.put(num, maps.getOrDefault(num, 0) + 1);
        }
        
        if(N <= maps.size()) {
            answer = N;
        } else {
            answer = maps.size();
        }
        
        return answer;
    }
}