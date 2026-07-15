// 갈색 격자 수, 노란 격자 수가 매개변수로 주어짐. 
// 가로, 세로 크기를 순서대로 배열에 담아 return.

// brown + yellow = 가로 * 세로
// (가로 - 2) * (세로 - 2) = yellow

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for(int i = 3; i <= Math.sqrt(total); i++) {
                if(total % i == 0) {
                int width = Math.max(i, total / i);
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