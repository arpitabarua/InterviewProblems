package solutions4;

import java.util.*;

/**
 * Return the earliest time for which every person became acquainted with every other person.
 * If there is no such earliest time, return -1.
 */
public class Solution {

    public int earliestAcq(int[][] logs, int n) {
        Map<Integer, Set<Integer>> friends = buildMap(n);
        List<Timeline> timeLineList = buildTimeline(logs);
        timeLineList.sort(new TimelineComparator());
        for(Timeline timeline: timeLineList){
            addFriend(friends, timeline.friend1, timeline.friend2);
            boolean isEveryoneFriends = isEveryoneAquainted(friends, timeline.friend1, n, new HashSet<Integer>());
            if(isEveryoneFriends){
                return timeline.timeStamp;
            }
        }

        return -1;
    }
    private List<Timeline> buildTimeline(int[][] logs){
        List<Timeline> timelineList = new ArrayList<>();
        for(int[] log: logs){
            timelineList.add(new Timeline(log[0], log[1], log[2]));
        }
        return timelineList;
    }

    private void addFriend(Map<Integer, Set<Integer>> friends, int i, int j){
        Set<Integer> friendList = friends.get(i);

        Set<Integer> friendList2 = friends.get(j);
        friendList.add(j);
        friendList2.add(i);
        friends.put(i, friendList);
        friends.put(j, friendList2);
    }

    private Map<Integer, Set<Integer>> buildMap(int n){
        Map<Integer, Set<Integer>> friends = new HashMap<>();
        for(int i = 0; i < n; i++){
            friends.put(i, new HashSet<Integer>());
        }

        return friends;
    }

    private boolean isEveryoneAquainted(Map<Integer, Set<Integer>> friends,  int i, int totalFriends, Set<Integer> visited){
        if(visited.size() == totalFriends){
            return true;
        }

        Set<Integer> friendSet = friends.get(i);
        boolean isEveryoneAquainted = false;
        for (int friend : friendSet) {
            if(isEveryoneAquainted) {
                break;
            }
            if(visited.contains(friend) && visited.contains(i)){
                continue;
            }
            visited.add(friend);
            visited.add(i);
            isEveryoneAquainted = isEveryoneAquainted || isEveryoneAquainted(friends, friend, totalFriends, visited);
        }

        return isEveryoneAquainted;

    }
}

class Timeline {
    int timeStamp;
    int friend1;
    int friend2;
    Timeline(int timeStamp, int friend1, int friend2){
        this.timeStamp = timeStamp;
        this.friend1 = friend1;
        this.friend2 = friend2;
    }
}

class TimelineComparator implements Comparator<Timeline> {
    @Override
    public int compare(Timeline o1, Timeline o2) {
        return Integer.compare(o1.timeStamp, o2.timeStamp);
    }
}
