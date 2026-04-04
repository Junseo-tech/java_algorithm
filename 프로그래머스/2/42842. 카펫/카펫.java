class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for(int i = 3; i <= Math.sqrt(total); i++) {
            if(total % i == 0) {
                int width = Math.max(total % i, total / i);
                int vertical = total / width;
                
                if((width - 2) * (vertical - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = vertical;
                    
                    break;
                }
            }
        }
        return answer;
    }
}