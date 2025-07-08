import java.io.*;
import java.util.*;

class Main {
    public static BufferedWriter bw;
    public static BufferedReader br;
    public static int N;

    public static class Node {
        Map<Character, Node> child = new HashMap<>();
        int isEnd = 0;
    }

    public static class Trie {
        Node root = new Node();

        public String insert(String in) {
            Node node = root;
            StringBuilder result = new StringBuilder();
            boolean endFlag = false;
            for (int i = 0; i < in.length(); i++) {
                //해당 자식 노드 존재할때
                if (node.child.get(in.charAt(i)) != null) {
                    node = node.child.get(in.charAt(i));
                    result.append(in.charAt(i));
                }
                //해당 자식 노드 없을때
                else {
                    Node next = new Node();
                    node.child.put(in.charAt(i), next);
                    node = next;
                    if (!endFlag) {
                        result.append(in.charAt(i));
                        endFlag = true;
                    }
                }
            }
            if (node.isEnd == 0) {
                node.isEnd = 1;
                return result.toString();
            }
            else {
                node.isEnd += 1;
                return result.append(node.isEnd).toString();
            }


        }
    }

    public static void main(String[] args) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(System.out)) ;
        br = new BufferedReader(new InputStreamReader(System.in));
        Trie trie = new Trie();
        N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            String res = trie.insert(br.readLine());
            bw.write(res + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}