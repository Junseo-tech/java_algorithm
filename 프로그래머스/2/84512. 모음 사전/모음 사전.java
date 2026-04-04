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
        
        if(!word.equals("")) { // 순서니까 A부터 세기 
            count++;
        }
        
        if(target.equals(word)) { // 맞으면 return 
            answer = count;
            return;
        }
        
        if(answer > 0) return;
        
        if(length == 5) return; // 5넘으면 못만듦
        
        for(int i = 0; i < 5; i++) {
            permutation(length + 1, target, word + alpha[i], alpha);
        }
    }
}