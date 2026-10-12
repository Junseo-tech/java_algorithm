import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();

        if(word1.length() != word2.length()) {
            System.out.println("No");
            return;
        }

        char[] wordArr1 = word1.toCharArray();
        char[] wordArr2 = word2.toCharArray();
        
        Arrays.sort(wordArr1);
        Arrays.sort(wordArr2);


        for(int i = 0; i < word1.length(); i++) {
            if(wordArr1[i] != wordArr2[i]) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}