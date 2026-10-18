import java.util.HashMap;
import java.util.Map;

public class KeywordTrie {

    // One letter-position in the tree
    private static class Node {
        Map<Character, Node> children = new HashMap<>();
        String distortion = null; // not null = a keyword ends here
    }

    private final Node root = new Node();

    // Add a keyword, letter by letter
    public void addKeyword(String keyword, String distortion) {
        Node current = root;
        for (char c : keyword.toLowerCase().toCharArray()) {
            Node next = current.children.get(c);
            if (next == null) {
                next = new Node();
                current.children.put(c, next);
            }
            current = next;
        }
        current.distortion = distortion;
    }

    // Find every keyword that appears in the text
    public void findAll(String text) {
        String lower = text.toLowerCase();
        for (int start = 0; start < lower.length(); start++) {
            Node current = root;
            for (int i = start; i < lower.length(); i++) {
                current = current.children.get(lower.charAt(i));
                if (current == null) {
                    break;
                }
                if (current.distortion != null) {
                    System.out.println("Found \"" + lower.substring(start, i + 1)
                            + "\" -> " + current.distortion);
                }
            }
        }
    }
}
