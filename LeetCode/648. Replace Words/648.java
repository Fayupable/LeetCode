

class Solution {

    public String replaceWords(List<String> dictionary, String sentence) {

        Set<String> rootset = new HashSet<>();
        // Initialize a Set to store the roots from the dictionary

        for (String root: dictionary) rootset.add(root);
        // Add all the roots from the dictionary to the Set

        StringBuilder ans = new StringBuilder();
        // Initialize a StringBuilder to build the answer string

        for (String word: sentence.split("\\s+")) {
            // Split the sentence into words and iterate over each word

            String prefix = "";
            // Initialize a String to store the prefix of the current word

            for (int i = 1; i <= word.length(); ++i) {
                // Iterate over each character in the current word

                prefix = word.substring(0, i);
                // Get the prefix of the current word up to the current character

                if (rootset.contains(prefix)) break;
                // If the prefix is a root, break the loop
            }

            if (ans.length() > 0) ans.append(" ");
            // If the answer string is not empty, append a space to it

            ans.append(prefix);
            // Append the prefix (or the root) to the answer string
        }

        return ans.toString();
        // Convert the answer string to a String and return it
    }
}

/*
 class Solution {
    static class Node {
        boolean isWord;
        Node[] children = new Node[26];
    }

    Node root = new Node();
    public String replaceWords(List<String> dictionary, String sentence) {
        for (String str: dictionary) {
            insert(str);
        }
        
        String[] arr = sentence.split(" ");
        StringBuilder builder = new StringBuilder("");
        for (int i=0; i<arr.length; i++) {
            String replace = search(arr[i]);
            if (replace == "") {
                builder.append(arr[i]);
            } else {
                builder.append(replace);
            }
            builder.append(" ");
        }
        return builder.toString().trim();
    }

    public void insert(String str) {
        Node node = this.root;
        for (char c: str.toCharArray()) {
            int n = c-'a';
            if (node.children[n] == null) {
                node.children[n] = new Node();
            }
            node = node.children[n];
        }
        node.isWord = true;
    }


    public String search(String str) {
        Node node = this.root;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            int n = c-'a';
            if (node.children[n] == null) {
                return "";
            }
            node = node.children[n];
            if (node.isWord) return str.substring(0, i+1);
        }
        return "";
    }
}
 */

/*
 class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // Set<String> set = new HashSet<>();
        // for (String s : dictionary)
        // set.add(s);
        // StringBuilder ans = new StringBuilder();
        // for (String word : sentence.split(" ")) {
        // StringBuilder w = new StringBuilder();
        // for (char c : word.toCharArray()) {
        // w.append(c);
        // if (set.contains(w.toString()))
        // break;
        // }
        // ans.append(w);
        // ans.append(" ");
        // }

        // ans.deleteCharAt(ans.length() - 1);
        // return ans.toString();

        dictionary.forEach(root -> insert(root));

        StringBuilder sb = new StringBuilder();
        for (String word : sentence.split(" ")) {
            sb.append(getRootWord(word)).append(" ");
        }
        return sb.toString().trim();
    }

    class TrieNode {
        Map<Character, TrieNode> links;
        boolean isEndOfWord;

        public TrieNode() {
            links = new HashMap<>();
            isEndOfWord = false;
        }
    }

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            TrieNode charNode = node.links.get(c);
            if (charNode == null) {
                charNode = new TrieNode();
                node.links.put(c, charNode);
            }
            node = charNode;
        }
        node.isEndOfWord = true;
    }

    public String getRootWord(String word) {
        if (root.links.get(word.charAt(0)) == null)
            return word;

        TrieNode node = root;
        StringBuilder rootWord = new StringBuilder();
        for (char c : word.toCharArray()) {
            rootWord.append(c);
            TrieNode charNode = node.links.get(c);
            if (charNode == null)
                return word;
            if (charNode != null && charNode.isEndOfWord)
                return rootWord.toString();
            node = charNode;
        }
        return word;
    }

}
 */