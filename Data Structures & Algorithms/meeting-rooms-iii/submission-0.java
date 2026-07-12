class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        PriorityQueue<long[]> usedRooms = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]){
                return Long.compare(a[1], b[1]);
            }else{
                return Long.compare(a[0], b[0]);
            }
        });

        for(int i=0;i<n;i++){
            availableRooms.offer(i);
        }

        int[] count = new int[n];

        for(int[] meeting : meetings){
            long start = meeting[0];
            long end = meeting[1];

            long duration = end - start;

            while(!usedRooms.isEmpty() && usedRooms.peek()[0] <= start){
                availableRooms.offer((int) usedRooms.poll()[1]);
            }

            if(!availableRooms.isEmpty()){
                int room = availableRooms.poll();
                usedRooms.offer(new long[]{end, room});
                count[room]++;
            }else{
                long[] earliest = usedRooms.poll();
                long newEnd = earliest[0] + duration;
                int room = (int)earliest[1];

                usedRooms.offer(new long[]{newEnd, room});
                count[room]++;
            }
        }

        int answer = 0;

        for(int i=0;i<n;i++){
            if(count[i] > count[answer]){
                answer = i;
            }
        }

        return answer;
    }
}