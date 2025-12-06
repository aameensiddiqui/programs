/**
   355. Design Twitter

   Design a simplified version of Twitter where users can post tweets,
   follow/unfollow another user, and is able to see the 10 most recent
   tweets in the user's news feed.

   Implement the Twitter class:

   Twitter() Initializes your twitter object.
   void postTweet(int userId, int tweetId) Composes a new tweet with
   ID tweetId by the user userId. Each call to this function will be made
   with a unique tweetId.
   List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet
   IDs in the user's news feed. Each item in the news feed must be posted
   by users who the user followed or by the user themself. Tweets must be
   ordered from most recent to least recent.
   void follow(int followerId, int followeeId) The user with ID followerId
   started following the user with ID followeeId.
   void unfollow(int followerId, int followeeId) The user with ID followerId
   started unfollowing the user with ID followeeId.

   Example 1:
   Input
   ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
   [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
   Output
   [null, null, [5], null, null, [6, 5], null, [5]]

   Explanation
   Twitter twitter = new Twitter();
   twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
   twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
   twitter.follow(1, 2);    // User 1 follows user 2.
   twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
   twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
                            // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
   twitter.unfollow(1, 2);  // User 1 unfollows user 2.
   twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5],
                            //since user 1 is no longer following user 2.

   Constraints:
   1 <= userId, followerId, followeeId <= 500
   0 <= tweetId <= 104
   All the tweets have unique IDs.
   At most 3 * 104 calls will be made to postTweet, getNewsFeed, follow, and unfollow.
   A user cannot follow himself.
*/
import java.util.*;

class Twitter {
    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> followings;
    int time;
    
    public Twitter() {
        tweets = new HashMap<>();
        followings = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        if(tweets.containsKey(userId)) {
            for(int[]tweet : tweets.get(userId)) {
                pq.offer(tweet);
                if(pq.size() > 10) pq.poll();
            }
        }

        if(followings.containsKey(userId)) {
            for(int followee : followings.get(userId)) {
                if(tweets.containsKey(followee)) {
                    for(int[]tweet : tweets.get(followee)) {
                        pq.offer(tweet);
                        if(pq.size() > 10) pq.poll();
                    } 
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()) list.addFirst(pq.poll()[1]);
        return list;
    }

    public void follow(int followerId, int followeeId) {
        followings.putIfAbsent(followerId, new HashSet<>());
        followings.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(followings.containsKey(followerId))
            followings.get(followerId).remove(followeeId);
    }
}
class DesignTwitter {
    public static void main(String[]args) {
        // Twitter obj = new Twitter();
        // obj.postTweet(userId,tweetId);
        // List<Integer> param_2 = obj.getNewsFeed(userId);
        // obj.follow(followerId,followeeId);
        // obj.unfollow(followerId,followeeId);

        Twitter twitter = new Twitter();

        twitter.postTweet(1, 2);
        twitter.postTweet(2, 6);
        IO.println(twitter.getNewsFeed(1)); // [2]
        twitter.follow(1, 2);
        IO.println(twitter.getNewsFeed(1)); // [6,2]
        twitter.unfollow(1, 2);
        twitter.postTweet(1, 7);
        IO.println(twitter.getNewsFeed(1)); // [7,2]
    }
}
