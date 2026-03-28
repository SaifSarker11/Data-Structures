import java.util.*;
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
    int childCount;
    
    public TrieNode() {
        Arrays.fill(children, null);
        isEndOfWord = false;
        childCount = 0;
    }
}

public class LongestCommonPrefix {
    TrieNode root;

    public LongestCommonPrefix() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for(char ch : word.toCharArray()) {
            int index = ch - 'a';
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
                current.childCount++;
            }
            current = current.children[index];
            
        }
        current.isEndOfWord = true;
    }

    public String getLongestCommonPrefix() {
        StringBuilder lcp = new StringBuilder();
        TrieNode current = root;
        while(current.childCount == 1 && !current.isEndOfWord) {
            for(int i = 0; i < 26; i++) {
                if(current.children[i] != null) {
                    lcp.append((char)(i + 'a'));
                    current = current.children[i];
                    break;
                }
            }
        }
        return lcp.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LongestCommonPrefix trie = new LongestCommonPrefix();
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < n; i++) {
            String word = scanner.next();
            trie.insert(word);
        }
        System.out.println(trie.getLongestCommonPrefix());
        scanner.close();
    }
}