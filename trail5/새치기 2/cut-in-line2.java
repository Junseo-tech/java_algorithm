import java.util.*;
import java.io.*;

class Node {
    Node prev;
    Node next;
    String name;

    public Node(String name) {
        this.name = name;
    }
}

public class Main {
    static HashMap<String, Node> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        int linePerson = n / m;

        Node[] head = new Node[m];
        Node[] tail = new Node[m];

        for(int i = 0; i < m; i++) {
            head[i] = new Node("HEAD");
            tail[i] = new Node("TAIL");

            insert(head[i], tail[i]);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            String name = st.nextToken();
            Node personNode = new Node(name);
            insert(personNode , tail[i / linePerson]);
            map.put(name, personNode);
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                String a = st.nextToken();
                String b = st.nextToken();

                Node aNode = map.get(a);
                Node bNode = map.get(b);

                pop(aNode);
                insert(aNode, bNode);

            } else if (type == 2) {
                String a = st.nextToken();
                Node aNode = map.get(a);
                pop(aNode);

            } else if (type == 3) {
                String a = st.nextToken();
                String b = st.nextToken();
                String c = st.nextToken();
                Node aNode = map.get(a);
                Node bNode = map.get(b);
                Node cNode = map.get(c);

                popRangeInsert(aNode, bNode, cNode);
            }
        }

        for(int i = 0; i < m; i++) {
            Node h = head[i].next;
            while(h != tail[i]) {
                System.out.print(h.name + " ");
                h = h.next;
            }

            System.out.println();
        }

        
    }

    private static void insert(Node a, Node b) { 
        a.prev = b.prev;
        a.next = b;
        if(b.prev != null) {
            b.prev.next = a;
        }
        b.prev = a;
    }

    private static void pop(Node a) {
        a.prev.next = a.next;
        a.next.prev = a.prev;
        a.prev = null;
        a.next = null;
    }

    private static void popRangeInsert(Node a, Node b, Node c) {
        // a 부터 b가 통째로 c인 사람 앞으로
        a.prev.next = b.next;
        b.next.prev = a.prev;

        a.prev = c.prev;
        b.next = c;

        c.prev.next = a;
        c.prev = b;
    }
}