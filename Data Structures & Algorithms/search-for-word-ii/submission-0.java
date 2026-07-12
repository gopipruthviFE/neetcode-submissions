class Solution {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void backtrack(int row, int col, char[][] board, List<String> res, TrieNode node, StringBuilder sb){
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length){
            return;
        }

        char ch = board[row][col];

        if(ch == '#'){
            return;
        }

        TrieNode next = node.children[ch - 'a'];
        if(next == null){
            return;
        }
        sb.append(ch);
        board[row][col] = '#';

        if(next.isEndOfWord){
            res.add(sb.toString());
            next.isEndOfWord = false;
        }

        for(int[] dir : dirs){
            int nRow = row + dir[0];
            int nCol = col + dir[1];

            backtrack(nRow, nCol, board, res, next, sb);
        }
        sb.deleteCharAt(sb.length() - 1);
        board[row][col] = ch;
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        List<String> res = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                backtrack(i, j, board, res, trie.root, new StringBuilder());
            }
        }

        return res;
    }
}
class TrieNode{
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode(){
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
}
class Trie{
    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;

        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(node.children[idx] == null){
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word){
        TrieNode node = root;

        for(char ch : word.toCharArray()){
            int idx = ch - 'a';
            if(node.children[idx] == null){
                return false;
            }
            node = node.children[idx];
        }

        return node.isEndOfWord;
    }

    // Time : O(W * L + (M * N) * (4 * 3 ^ L - 1))
    // Space : O(W * L + L)
}
