package index;

import java.util.HashMap;

public class TrieNode {

    private HashMap<Character, TrieNode> children;
    private boolean isEndOfWord;
    private String fullWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
        fullWord = null;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public String getFullWord() {
        return fullWord;
    }

    public void setFullWord(String fullWord) {
        this.fullWord = fullWord;
    }
}