package leetcode.editor.cn;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 实现 Trie (前缀树)
 *
 * @author why
 * @date 2022-10-09 10:51:47
 */
public class P208_ImplementTriePrefixTree {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        class TrieNode {
            TrieNode[] nodes = new TrieNode[26];
            boolean flag = false;
        }

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.nodes[idx] == null) {
                    node.nodes[idx] = new TrieNode();
                }
                node = node.nodes[idx];
            }
            node.flag = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.nodes[idx] == null) {
                    return false;
                }
                node = node.nodes[idx];
            }
            return node.flag;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int idx = prefix.charAt(i) - 'a';
                if (node.nodes[idx] == null) {
                    return false;
                }
                node = node.nodes[idx];
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
