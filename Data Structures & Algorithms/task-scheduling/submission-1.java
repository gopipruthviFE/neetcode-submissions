class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxCount = 0;

        for(int i=0;i<tasks.length;i++){
            freq[tasks[i] - 'A']++;
        }

        for(int i=0;i<26;i++){
           maxFreq = Math.max(maxFreq, freq[i]);
        }

        for(int i=0;i<26;i++){
           if(freq[i] == maxFreq){
            maxCount++;
           }
        }

        int minRequired = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(tasks.length, minRequired);
    }
    // O(n + 26)
}
