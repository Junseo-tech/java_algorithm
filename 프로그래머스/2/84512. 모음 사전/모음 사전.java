// 길이 5이하 
class Solution {
    private static int count;
    private static int answer;
    public int solution(String word) {
        char[] alphabet = new char[] {'A', 'E', 'I', 'O', 'U'}; // 5
        answer = 0;
        count = 0;
        
        permutation(0, word, "", alphabet);
        return answer;
    }
    
    private static void permutation(int length, String target, String word, char[] alpha) {
        
        if(!word.equals("")) {
            count++;
        }
        
        if(target.equals(word)) {
            answer = count;
            return;
        }
        
        if(length == 5) return;
        
        for(int i = 0; i < 5; i++) {
            permutation(length + 1, target, word + alpha[i], alpha);
        }
    }
}