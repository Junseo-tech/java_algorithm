// 같은 종류의 폰켓몬은 같은 번호를 가진다
// 최대한 다양한 폰켓몬을 가지길 바란다. 따라서 최대한 많은 종류의 폰켓몬을 포함해서 n/2마리를 선택한다. 
// 방법을 찾고, 종류 번호의 개수를 return 한다.

import java.util.*;
class Solution {
    public int solution(int[] nums) { // nums 길이 10,000이 최대 , 늘 짝수 
        int answer = 0;
        HashMap<Integer, Integer> pocket = new HashMap<>();
        int goal = nums.length / 2;
        
        for(int i = 0; i < nums.length; i++) {
            pocket.put(nums[i], pocket.getOrDefault(nums[i], 0) + 1); // 일단 몇개 있는지 채워
        }
        
        if(pocket.size() > goal) {
            answer = goal;
        } else {
            answer = pocket.size();
        }
        return answer;
    }
}