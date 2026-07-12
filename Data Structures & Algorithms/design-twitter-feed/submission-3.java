class Twitter {
    Map<Integer, List<int[]>>tweets;
    Map<Integer, List<Integer>> following;
    int timeStamp;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        timeStamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        int[] tweet = new int[2];
        tweet[0] = tweetId;
        tweet[1] = ++timeStamp;
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = following.get(userId);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        if(list != null){
            for(int i=0;i<list.size();i++){
                if(!tweets.containsKey(list.get(i)) || list.get(i).equals(userId)){
                    continue;
                }
                for (int[] tw : tweets.get(list.get(i))) pq.offer(tw);
            }
        }
        if(tweets.containsKey(userId)){
            for (int[] tw : tweets.get(userId)) pq.offer(tw);
        }

        List<Integer> res = new ArrayList<>();
        int size = pq.size();

        for(int i=0;i<10 && !pq.isEmpty();i++){
            res.add(pq.poll()[0]);
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        List<Integer> list = following.computeIfAbsent(followerId, k -> new ArrayList<>());//List of users whom I follow
        if(!list.contains(followeeId)){
            list.add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!following.containsKey(followerId)){
            return;
        }
        List<Integer> list = following.get(followerId);
        list.remove(Integer.valueOf(followeeId));
    }
}
