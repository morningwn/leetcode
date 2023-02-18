package com.github.morningwn.t0001_t0500.t0301_t0400.t0351_t0360;

import com.github.morningwn.prefab.Out;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * T0355 class
 *
 * @author morningwn
 * @date 2020/04/13
 */
public class T0355 {

    @Test
    public void test() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        Out.println(twitter.getNewsFeed(1));       //[1]
        twitter.follow(2, 1);
        Out.println(twitter.getNewsFeed(2));       //[1]

        twitter.unfollow(2, 1);
        Out.println(twitter.getNewsFeed(2));

//        twitter.postTweet(1, 5);
//        Out.println( twitter.getNewsFeed(1) );
//        twitter.follow(1, 2);
//        twitter.postTweet(2, 6);
//        Out.println( twitter.getNewsFeed(1) );
//
//        twitter.unfollow(1, 2);
//        Out.println( twitter.getNewsFeed(1) );


    }

    class Twitter {
        private final Map<Integer, User> userList;
        private final List<Mesg> mesgList;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            userList = new HashMap<>();
            mesgList = new ArrayList<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {

            if (!userList.containsKey(userId)) {
                User user = new User(userId, new ArrayList<>());
                userList.put(userId, user);
            }

            Mesg mesg = new Mesg(userId, tweetId);
            mesgList.add(mesg);
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed.
         * Each item in the news feed must be posted by users who the user followed or by the user herself.
         * Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {

            List<Integer> res = new ArrayList<>(10);

            if (!userList.containsKey(userId)) {
                return res;
            }
            List<Integer> users = userList.get(userId).followers;
            users.add(userId);


            int index = mesgList.size() - 1;

            while (index >= 0) {

                Mesg mesg = mesgList.get(index);

                for (int i = 0; i < users.size(); i++) {
//                Out.println( users.get(i) + "\t 这里");
                    if (users.get(i) == mesg.userid) {
                        res.add(mesg.tweetId);
                        break;
                    }
                }

                if (res.size() == 10) {
                    break;
                }
//            Out.println( index );
                index--;
            }

            return res;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {

            if (!userList.containsKey(followerId)) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(followeeId);
                User user = new User(followerId, tmp);
                userList.put(followerId, user);
            } else {
                User user = userList.get(followerId);
                if (!user.followers.contains(followeeId)) {
                    user.followers.add(followeeId);
                }
            }
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {

            if (userList.containsKey(followerId)) {
                User user = userList.get(followerId);
                if (user.followers.contains(followeeId)) {

                    for (int i = 0; i < user.followers.size(); i++) {

                        if (user.followers.get(i) == followeeId) {
                            user.followers.remove(i);
                            break;
                        }
                    }
                }
            }
        }

        class User {
            public int userid;
            public List<Integer> followers;
//        public List<Integer> showMesg;

            public User(int userid, List<Integer> followers) {
                this.userid = userid;
                this.followers = followers;
            }
//        public User( int userid, List<Integer> followers, List<Integer> showMesg ){
//            this.userid = userid;
//            this.followers = followers;
//            this.showMesg = showMesg;
//        }
        }

        class Mesg {
            public int userid;
            public int tweetId;

            public Mesg(int userid, int tweetId) {
                this.userid = userid;
                this.tweetId = tweetId;
            }
        }
    }

}

