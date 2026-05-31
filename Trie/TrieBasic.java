import java.util.*;
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
    
    public TrieNode() {
        Arrays.fill(children, null);
        isEndOfWord = false;
    }
}

public class TrieBasic {
    TrieNode root;

    public TrieBasic() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index] == null) current.children[index] = new TrieNode();
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index] == null) return false;
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index] == null) return false;
            current = current.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrieBasic trie = new TrieBasic();
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            String word = scanner.next();
            trie.insert(word);
        }
        String searchWord = scanner.next();
        System.out.println(trie.search(searchWord) ? "Found" : "Not Found");
        String prefix = scanner.next();
        System.out.println(trie.startsWith(prefix) ? "Prefix Exists" : "Prefix Doesn't Exist");
        scanner.close();
    }
}