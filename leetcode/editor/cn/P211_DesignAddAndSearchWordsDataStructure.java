package leetcode.editor.cn;

/**
 * 添加与搜索单词 - 数据结构设计
 *
 * @author why
 * @date 2022-10-09 11:57:22
 */
public class P211_DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {
        class TrieNode {
            boolean flag = false;
            TrieNode[] nodes = new TrieNode[26];
        }

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
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
            return dfs(word, root, 0);
        }

        private boolean dfs(String word, TrieNode node, int i) {
            if (i == word.length()) {
                return node.flag;
            }
            char c = word.charAt(i);
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.nodes[j] != null && dfs(word, node.nodes[j], i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = c - 'a';
                if (node.nodes[idx] != null) {
                    return dfs(word, node.nodes[idx], i + 1);
                } else {
                    return false;
                }
            }


        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
