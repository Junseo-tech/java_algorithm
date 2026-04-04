import java.util.*;

class Node {
    HashMap<Character, Node> child = new HashMap<>();
    boolean end = false;
    
    public Node() {
        this.child = child;
        this.end = end;
    }
}

class Trie {
    Node root;
    
    public Trie() {
        this.root = new Node();
    }
    
    public boolean insert(String str) {
        Node node = this.root;
        
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if(node.child.containsKey(c) && node.child.get(c).end) {
                return false;
            }
            node.child.putIfAbsent(c, new Node());
            node = node.child.get(c);
        }
        
        if(!node.child.isEmpty()) { // 다 넣었는데 아래 있음 => 내가 더 짧은 경우
            return false;
        }
        
        node.end = true;
        
        return true;
    }
}
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Trie trie = new Trie();
        for(int i = 0; i < phone_book.length; i++) {
            if(!trie.insert(phone_book[i])) {
                answer = false;
                return answer;
            }
        }
        
        return answer;
    }
}