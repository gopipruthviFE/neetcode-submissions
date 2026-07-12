class WordDictionary {
    Trie trie;

    public WordDictionary() {
        this.trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }
}

class Trie{
    class TrieNode{
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode(){
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }
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
        return dfs(root, 0, word);
    }

    public boolean dfs(TrieNode node, int index, String word){
        if(index == word.length()){
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);

        if(ch == '.'){
            for(int i=0;i<26;i++){
                if(node.children[i] != null && dfs(node.children[i], index + 1, word)){
                    return true;
                }
            }
            return false;
        }else{
            int idx = ch - 'a';
            if(node.children[idx] == null){
                return false;
            }
            node = node.children[idx];
            return dfs(node, index + 1, word);
        }
    }

    public boolean startsWith(String prefix){
        TrieNode node = root;

        for(char ch : prefix.toCharArray()){
            int idx = ch - 'a';
            
            if(node.children[idx] == null){
                return false;
            }
            node = node.children[idx];
        }
        return true;
    }

    // Time : O(L * 26 * 26)
    // Space : O(N) + O(L)
}