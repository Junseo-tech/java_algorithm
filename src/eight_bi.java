import java.util.*;
import java.io.*;

public class eight_bi {

        public static void main(String[] args) throws IOException {

            Scanner sc = new Scanner(System.in);
            String s = sc.next();

            StringBuilder sb = new StringBuilder(); // string을 더하는 상황에 유용

            for(int i = 0; i < s.length(); i++) {
                String a = Integer.toBinaryString(s.charAt(i) - '0'); // charAt은 string으로 저장된 문자열 중에서 한 글자만 선택해서 char 타입으로 바꿔준다
                if(a.length() == 2 && i != 0)
                    a = "0" + a;
                else if(a.length() == 1 && i !=0)
                    a = "00" + a;

                sb.append(a);
            }

            System.out.println(sb);
        }

}
