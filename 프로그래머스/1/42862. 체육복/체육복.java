// 바로 앞 번호의 학생이나 바로 뒷 번호의 학생에게만 체육복을 빌려줄 수 있음.
// 최대한 많은 학생이 체육 수업 들을 수 있도록
// 여벌 체육복을 가져온 학생이 체육복 도난 당했을 수도 있다. => 다른 애한테 체육복 빌려줄 수 없음
import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] finish = new boolean[reserve.length]; // 빌렸는지 여부 체크
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int success = 0;
        for(int i = 0; i < lost.length; i++) { // 여벌 옷 있는데 도난 당한 애들 거르기
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    finish[j] = true;
                    lost[i] = -1; // 이 애들이 다른 체육복을 빌릴 수도 있으니까 아예 접근 불가능한 값으로 막기
                    success++; // 어쨌든 얘네도 참여가능하니까 더해주기
                }
            }
        }
        
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(!finish[j] && (lost[i] == reserve[j] - 1 || lost[i] == reserve[j] + 1)) {
                    finish[j] = true;
                    success++;
                    break;
                }
            }
        }
        
        answer = success;
        int fail = lost.length - success;
        
        if(fail <= 0) {
            answer = n;
        } else {
            answer = n - fail;
        }
        
        return answer;
    }
}