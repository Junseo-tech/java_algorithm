import java.util.*;

class Solution {
    private static int answer;
    private static HashSet<Integer> set;
    
    public int solution(String numbers) {
        char[] number = new char[numbers.length()];
        set = new HashSet<>();
        
        for(int i = 0; i < numbers.length(); i++) {
            number[i] = numbers.charAt(i);
        }
        
        answer = 0;
        
        int N = numbers.length();
        permutation(new boolean[N], "", N, number);
        
        return answer;
    }
    
    private static void permutation(boolean[] visited, String number, int N, char[] numbers) {
        if(number.length() > N) return;
        
        if(!number.equals("")) {
            int num = Integer.parseInt(number);
            if(isPrime(num) && !set.contains(num)) {
                answer++;
                set.add(num);
            }
        }
        
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                permutation(visited, number + numbers[i], N, numbers);
                visited[i] = false;
            }
        }
    }
    
    private static boolean isPrime(int number) {
        if(number < 2) return false;
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
    
}