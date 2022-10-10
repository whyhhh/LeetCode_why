package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词搜索 II
 *
 * @author why
 * @date 2022-10-09 15:13:10
 */
public class P212_WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new P212_WordSearchIi().new Solution();
        System.out.println(solution.findWords(
                new char[][]{{'a'},
                        {'e'}},
                new String[]{"a"}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class TrieNode {
            String str;
            TrieNode[] nodes = new TrieNode[26];
        }

        private TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.nodes[idx] == null) {
                    node.nodes[idx] = new TrieNode();
                }
                node = node.nodes[idx];
            }
            node.str = word;
        }

        boolean search(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (node.nodes[idx] == null) {
                    return false;
                }
                node = node.nodes[idx];
            }
            return true;
        }

        int maxX, maxY;
        char[][] board;
        boolean[][] boardFlag;
        int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int wordNum = 0;
        Set<Character> charSet = new HashSet<>();

        public List<String> findWords(char[][] board, String[] words) {
            boardFlag = new boolean[board.length][board[0].length];
            maxX = board.length;
            maxY = board[0].length;
            this.board = board;
            Set<String> ansSet = new HashSet<>();

            for (int i = 0; i < maxX; i++) {
                for (int j = 0; j < maxY; j++) {
                    charSet.add(board[i][j]);
                }
            }

            for (String word : words) {
                if (word.length() <= maxX * maxY && check(word)) {
                    insert(word);
                    wordNum++;
                }
            }

            for (int i = 0; i < maxX; i++) {
                for (int j = 0; j < maxY; j++) {
                    if (root.nodes[board[i][j] - 'a'] != null) {
                        boardFlag[i][j] = true;
                        dfs(i, j, ansSet, root.nodes[board[i][j] - 'a']);
                        boardFlag[i][j] = false;
                    }
                    if (ansSet.size() == wordNum) break;
                }
            }

            return new ArrayList<>(ansSet);
        }

        void dfs(int _x, int _y, Set<String> set, TrieNode node) {
            if (set.size() == wordNum) return;
            if (node.str != null) {
                set.add(node.str);
            }
            for (int[] move : moves) {
                int x = _x + move[0];
                int y = _y + move[1];
                if (x < 0 || x >= maxX) continue;
                if (y < 0 || y >= maxY) continue;
                if (boardFlag[x][y]) continue;
                if (node.nodes[board[x][y] - 'a'] == null) continue;
                boardFlag[x][y] = true;
                dfs(x, y, set, node.nodes[board[x][y] - 'a']);
                boardFlag[x][y] = false;
            }
        }

        private boolean check(String word) {
            for (int i = 0; i < word.length(); i++) {
                if (!charSet.contains(word.charAt(i))){
                    return false;
                }
            }
            return true;
        }

    }


//leetcode submit region end(Prohibit modification and deletion)

}
