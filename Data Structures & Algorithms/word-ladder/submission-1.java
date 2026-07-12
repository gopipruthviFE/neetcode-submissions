class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        int count = 0;

        for(int i=0;i<wordList.size();i++){
            words.add(wordList.get(i));
        }

        que.add(beginWord);

        while(!que.isEmpty()){
            int size = que.size();
            count++;

            for(int i=0;i<size;i++){
                String word = que.poll();
                if(word.equals(endWord)){
                    return count;
                }
                char[] node = word.toCharArray();

                for(int j=0;j<node.length;j++){
                    char ch = node[j];

                    for(char k='a';k<='z';k++){
                        node[j] = k;
                        String newWord = new String(node);
                        if(words.contains(newWord)){
                            que.offer(newWord);
                            words.remove(newWord);
                        }
                    }
                    node[j] = ch;
                }
            }
        }

        return 0;
    }

    // Time : O(wordList.length * n * 26)
    // Space : O(wordList.length * n)

}
