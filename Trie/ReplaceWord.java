import java.util.*;
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord;
    
    public TrieNode() {
        Arrays.fill(children, null);
        isEndOfWord = false;
    }
}

public class ReplaceWord {
    TrieNode root;

    public ReplaceWord() {
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

    public String findRoot(String word) {
        TrieNode current = root;
        StringBuilder prefix = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null) {
                break;
            }
            prefix.append(word.charAt(i));
            current = current.children[index];
        }
        if(current.isEndOfWord) return prefix.toString();
        return word;
    }

    public String replaceWords(String[] dictionary, String sentence) {
        StringBuilder result = new StringBuilder();
        for(String word : dictionary) {
            insert(word);
        }
        String[] words = sentence.split(" ");
        for(String word : words) {
            result.append(findRoot(word)).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReplaceWord trie = new ReplaceWord();
        int n = scanner.nextInt();
        String[] dict = new String[n];
        for(int i = 0; i < n; i++) {
            dict[i] = scanner.nextLine();
        }
        scanner.nextLine();
        String sentence = scanner.nextLine();
        String result = trie.replaceWords(dict, sentence);
        System.out.println(result);
        scanner.close();
    }
}