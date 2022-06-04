class Twitter {

    class User {
        int userId;
        List<Tweet> tweets;
        HashSet<User> followSet;
        
        public User(int userId) {
            this.userId = userId;
            tweets = new ArrayList<>();
            followSet = new HashSet<>();
        }
        
        public List<Tweet> getTweets() {
            return tweets;
        }
        
        public HashSet<User> getFollowSet() {
            return this.followSet;
        }
    }
    
    class Tweet {
        int tweetId;
        int timePosted;
        
        public Tweet(int tweetId, int timePosted) {
            this.tweetId = tweetId;
            this.timePosted = timePosted;
        }
    }

    HashMap<Integer, User> users;
    int time;
    
    public Twitter() {
        users = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId))
            users.put(userId, new User(userId));
                
        User user = users.get(userId);
        user.getTweets().add(new Tweet(tweetId, time++));
    }
    
    class UserIndex {
        User user;
        int index;
        
        public UserIndex(User user, int index) {
            this.user = user;
            this.index = index;
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)) return List.of();
        HashSet<User> followSet = users.get(userId).getFollowSet();
        Iterator<User> iter = followSet.iterator();
                
        PriorityQueue<UserIndex> heap = new PriorityQueue<>((a, b) -> Integer.compare(b.user.getTweets().get(b.index).timePosted, a.user.getTweets().get(a.index).timePosted));
                    
        while (iter.hasNext()) {
            User user = iter.next();
            int index = user.getTweets().size() - 1;
            if (index >= 0)
                heap.add(new UserIndex(user, index));
        }
        User self = users.get(userId);
        int selfIndex = self.getTweets().size() - 1;

        if (selfIndex >= 0)
            heap.add(new UserIndex(self, selfIndex));
        
        List<Integer> result = new ArrayList<>();

        int count = 0;
        while (heap.size() > 0 && count < 10) {
            UserIndex userIndex = heap.poll();
            Tweet tweet = userIndex.user.getTweets().get(userIndex.index--);
            result.add(tweet.tweetId);
            if (userIndex.index >= 0) {
                heap.add(userIndex);
            }
            count++;
        }
        
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId))
            users.put(followerId, new User(followerId));
        if (!users.containsKey(followeeId))
            users.put(followeeId, new User(followeeId));
        
        users.get(followerId).getFollowSet().add(users.get(followeeId));
    }
    
    public void unfollow(int followerId, int followeeId) {
        users.get(followerId).getFollowSet().remove(users.get(followeeId));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */