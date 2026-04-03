import java.util.*;
import java.io.*;

class Solution {
    // participant의 길이 최대 100,000, completion은 그거보다 1 작음
    // 동명이인이 있을 수 있음
    private static HashMap<String, Integer> runner;
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        runner = new HashMap<>();
        
        for(int i = 0; i < participant.length; i++) { // participant에 넣기 
            if(runner.containsKey(participant[i])) {
                int temp = runner.get(participant[i]);
                runner.put(participant[i], temp + 1);
            } else {
                runner.put(participant[i], 1);   
            }
        }
        
        for(int i = 0; i < completion.length; i++) {
            if(runner.containsKey(completion[i])) {
                int temp = runner.get(completion[i]);
                runner.put(completion[i], temp - 1);
            } else {
                runner.put(completion[i], 1);
            }
            
        }
        
        for(Map.Entry<String, Integer> entry : runner.entrySet()) {
            if(entry.getValue() > 0) {
                answer = entry.getKey();
            }
        }


        return answer;
    }
}