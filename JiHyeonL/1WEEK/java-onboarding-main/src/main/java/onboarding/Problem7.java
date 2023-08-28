package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Follow makeRelation = new Follow();
        MaxScore makeAns = new MaxScore();
        // 유저, 유저별 친구 리스트, 방문자
        return makeAns.result(user,makeRelation.userFriend(friends),visitors);
    }

    /**
     * 각 유저들의 친구들을 저장하기 위한 형태를 제공하는 클래스
     */
    static class FriendMap {
        // relation<유저, 유저 친구리스트>
        public static HashMap<String,List<String>> relation = new HashMap<>();

        public static List<String> get(String key) {
            if(!relation.containsKey(key))
                relation.put(key,new ArrayList<>());
            return relation.get(key);
        }
        /*
         * 친구 관계는 양방향이기 때문에 key, value를 각각 바꿔서도 넣어주는 메소드
         */
        void add(String key, String value) {
            get(key).add(value);
            get(value).add(key);
        }

    }

    /**
     * FriendMap 클래스를 사용해서 각 사용자의 친구들을 넣어주는 클래스
     */
    static class Follow {
        // 각 사용자의 친구들을 담고있는 FriendMap 객체
        public static FriendMap map = new FriendMap();
        /*
         * 모든 사용자의 친구들을 반환하는 메소드
         */
        public static FriendMap userFriend(List<List<String>> friends) {
             for(List<String> friend : friends) {
                 map.add(friend.get(0),friend.get(1));
             }
             return map;
        }
    }

    /**
     * 점수를 계산하는 클래스
     */
    static class MaxScore {
        public static HashMap<String,Integer> myScore = new HashMap<>();
        public static List<String> noScore;
        /*
         * 점수가 가장 높은 5명 반환하는 메소드
         */
        public static List<String> result(String user, FriendMap relation, List<String> visitors) {
            userStorage(relation);   // 점수판 만들기
            makeNoScore(user,relation); // 나, 내 친구를 noScore 리스트에 저장
            sameKnow(user,relation);    // 친구의 친구 점수 부여 + 10
            timeLine(visitors); // 방문한 유저 점수 부여 +1

            return sortScore();
        }
        /*
         * 각 유저별 점수판 만드는 메소드(타임라인 방문자 제외)
         */
        public static void userStorage(FriendMap friends) {
            for(String user : friends.relation.keySet()) {
                myScore.put(user,0);
            }
        }
        /*
         * 나,내 친구 이름을 담은 리스트를 생성하는 메소드
         * (리스트는 이후에 나, 내 친구 제외하고 점수 부여할때 사용)
         */
        public static void makeNoScore(String user, FriendMap friends) {
            for(String key : friends.relation.keySet()) {
                // 나, 내 친구들은 따로 noScore에 저장
                if(key.equals(user)) {
                    noScore = new ArrayList<>(friends.relation.get(key));
                    noScore.add(key);
                }
            }
        }
        /*
         * 사용자와 함께 아는 친구이면 +10 부여하는 메소드
         */
        public static void sameKnow(String user, FriendMap friends) {
            for(String key : friends.relation.keySet()) {
                if(noScore.contains(key)) {
                    for (String value : friends.relation.get(key)) {
                        myScore.put(value, myScore.get(value) + 10);
                    }
                }
            }
        }
        /*
         * 사용자의 타임라인에 방문하면 +1 부여하는 메소드
         */
        public static void timeLine(List<String> visitors) {
            for(String visitor : visitors) {
                if(!myScore.containsKey(visitor)) {
                    myScore.put(visitor, 1);
                    continue;
                }
                myScore.put(visitor, myScore.get(visitor) + 1);
            }
        }
        /*
         * 점수가 가장 높은 5명 반환
         */
        public static List<String> sortScore() {
            List<String> keySet = new ArrayList<>(myScore.keySet());
            List<String> answer = new ArrayList<>();
            int count = 0;
            // 점수 기준 내림차순 정렬, 점수 같으면 이름 오름차순 정렬
            keySet.sort((o1,o2) -> {
                if(myScore.get(o2).compareTo(myScore.get(o1)) == 0)
                    return o1.compareTo(o2);
                return myScore.get(o2).compareTo(myScore.get(o1));
            });

            for(String user : keySet) {
                if(myScore.get(user) == 0 || count == 5)
                    break;
                if(noScore.contains(user))
                    continue;

                answer.add(user);
                count++;
            }
            return answer;
        }
    }
}
