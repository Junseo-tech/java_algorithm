import java.util.*;
import java.io.*;


class Number implements Comparable<Number>{
    int abs;
    int original;

    public Number(int abs, int original) {
        this.abs = abs;
        this.original = original;
    }

    public int compareTo(Number n) {
        if(this.abs == n.abs) {
            return this.original - n.original;
        }
        return this.abs - n.abs;
    }
}

public class Main {
    private static int N;
    private static PriorityQueue<Number> numbers;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(temp != 0) {
                numbers.add(new Number(Math.abs(temp), temp));
            } else {
                if(numbers.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    Number num = numbers.poll();
                    sb.append(num.original).append("\n");
                }

            }
        }

        System.out.println(sb);
    }
}
