class Solution {
    public String reorganizeString(String s) {
        //task and count
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        // task, nextAvailableTime and count
        Queue<int[]> que = new LinkedList<>();
        int[] freq = new int[26];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int i=0;i<26;i++){
            if(freq[i] > 0){
                pq.offer(new int[]{i, freq[i]});
            }
        }

        int[] prev = null;
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty() || !que.isEmpty()){
            int[] task = pq.poll();
            sb.append((char)(task[0] + 'a'));

            task[1]--;

            if(prev != null && prev[1] > 0){
                pq.offer(prev);
            }

            prev = task;
        }

        if(sb.length() != s.length()){
            return "";
        }

        return sb.toString();
    }

    // Time : O(nlog26)
}