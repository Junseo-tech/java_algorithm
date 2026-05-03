import java.util.*;

class Solution {
    static HashMap<String, PriorityQueue<String>> maps = new HashMap<>();
    static List<String> result = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        for(int i = 0; i < tickets.length; i++) {
            // computeIfAbsent 활용하기. 람다식 무서워하지 말긔.
            maps.computeIfAbsent(tickets[i][0], k -> new PriorityQueue<>()).add(tickets[i][1]); 
        }
        
        dfs("ICN");
        
        Collections.reverse(result);
        
        return result.toArray(new String[0]); // 이렇게 해서 제일 작게 만들어 놓으면 자바가 알아서 키워주니까
    }
    
    private static void dfs(String country) {
        PriorityQueue<String> to = maps.get(country);
        
        while(to != null && !to.isEmpty()) {
            dfs(to.poll());
        }
        
        result.add(country);
    }
}