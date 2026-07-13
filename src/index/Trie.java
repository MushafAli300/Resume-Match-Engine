package index;

import java.util.ArrayList;
import java.util.Map;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        word = word.toLowerCase();

        for (char ch : word.toCharArray()) {
            if (!current.getChildren().containsKey(ch)) {
                current.getChildren().put(ch, new TrieNode());
            }
            current = current.getChildren().get(ch);
        }

        current.setEndOfWord(true);
        current.setFullWord(word);
    }

    public boolean search(String word) {
        TrieNode current = root;
        word = word.toLowerCase();

        for (char ch : word.toCharArray()) {
            if (!current.getChildren().containsKey(ch)) {
                return false;
            }
            current = current.getChildren().get(ch);
        }

        return current.isEndOfWord();
    }

    public ArrayList<String> startsWith(String prefix) {
        ArrayList<String> result = new ArrayList<>();
        TrieNode current = root;
        prefix = prefix.toLowerCase();

        for (char ch : prefix.toCharArray()) {
            if (!current.getChildren().containsKey(ch)) {
                return result;
            }
            current = current.getChildren().get(ch);
        }

        collectAllWords(current, result);
        return result;
    }

    private void collectAllWords(TrieNode node, ArrayList<String> result) {
        if (node.isEndOfWord()) {
            result.add(node.getFullWord());
        }

        for (Map.Entry<Character, TrieNode> entry : node.getChildren().entrySet()) {
            collectAllWords(entry.getValue(), result);
        }
    }
}