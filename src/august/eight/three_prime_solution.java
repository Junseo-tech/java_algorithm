package august.eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class three_prime_solution {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean isFound = false;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> prime = isPrime(N);// N 까지의 소수 들
            List<Integer> temp = new ArrayList<>();
            isFound = false;
            combinations(prime,temp, 0, N-1, 3, N);

        }
    }

    private static List<Integer> isPrime(int N){
        boolean[] primes = new boolean[N+1];
        List<Integer> prime = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            primes[i] = true;
        }
        primes[0] = false;
        primes[1] = false;
        for(int i = 2; i <= Math.sqrt(N); i++){
            if(primes[i]){
                for(int j = i*i; j <= N; j+=i){
                    primes[j] = false;
                }
            }
        }
        for(int i = 0; i <= N; i++){
            if(primes[i]){
                prime.add(i);
            }
        }
        return prime;
    }

    private static void combinations(List<Integer> prime,List<Integer> current,int start, int end, int r, int N){
        if(r == 0){
            int sum = 0;
            for(int i = 0; i < current.size(); i++){
                sum += current.get(i);
            }
            if(sum == N){
                printCombination(current);
                isFound = true;
                return;
            }
            return;
        } else {
            for(int i = start; i < prime.size(); i++){
                current.add(prime.get(i));
                combinations(prime, current, i, end,r-1, N);
                current.remove(current.size() - 1);

                if(isFound){
                    return;
                }
            }
        }
    }

    private static void printCombination(List<Integer> combination) {
        for (int num : combination) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
