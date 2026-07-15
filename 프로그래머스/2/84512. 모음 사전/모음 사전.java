class Solution {
    static char[] words = new char[]{'A', 'E', 'I', 'O', 'U'};
    static int answer;
    static int count;
    public int solution(String word) {
        answer = 0;
        
        makeWord(word, "");
        return answer;
    }
    
    
    private void makeWord(String word, String temp) {
        if(answer != 0) {
            return;
        }
        if(temp.equals(word)) {
            answer = count;
            return;
        }
        
        if(temp.length() == 5) return;
        
        for(int i = 0; i < 5; i++) {
            count++;
            makeWord(word, temp + words[i]);
        }
    }
}