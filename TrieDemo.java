public class TrieDemo {
    public static void main(String[] args) {
        KeywordTrie trie = new KeywordTrie();
        trie.addKeyword("always", "Overgeneralization");
        trie.addKeyword("never", "Overgeneralization");
        trie.addKeyword("ruined", "Catastrophizing");
        trie.addKeyword("they think", "Mind reading");

        trie.findAll("I always fail, they think I am stupid and my life is ruined.");
    }
}