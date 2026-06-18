// 한 번호가 다른 번호의 접두어인 경우 => 접두어인 경우가 있으면 false, 아니면 true
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
            
        for(int i = 1; i < phone_book.length; i++) {
            if(phone_book[i].startsWith(phone_book[i - 1])) {
                answer = false;
                break;
            }
        }
        
        return answer;
    }
}