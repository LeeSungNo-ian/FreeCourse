package onboarding;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.regex.Pattern;

public class Problem7 {
    static UserRepository repository = new UserRepository();

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();

        for (List<String> f : friends) {

            User7 user1 = addUser(new Id(f.get(0)));
            User7 user2 = addUser(new Id(f.get(1)));

            user1.addFriend(user2);
            user2.addFriend(user1);

        }

        Optional<User7> result = repository.findById(new Id(user));
        User7 target = result.get();
        for (User7 targetFriend : target.friends) {
            for (User7 recommendation : targetFriend.friends) {
                if (recommendation.id == target.id) continue;

                if (!target.recommendationList.containsKey(recommendation.id)) {
                    Recommendation reco = new Recommendation(recommendation.id, 10);
                    target.recommendationList.put(recommendation.id, reco);
                } else {
                    Recommendation reco = target.recommendationList.get(recommendation.id);
                    reco.score += 10;
                }
            }
        }

        for (String visitor : visitors) {
            Id visitorId = new Id(visitor);
            Optional<User7> friend = repository.findById(visitorId);
            if (!friend.isEmpty() && target.friends.contains(friend.get())) continue;

            if (!target.recommendationList.containsKey(visitorId)) {
                Recommendation reco = new Recommendation(visitorId, 1);
                target.recommendationList.put(visitorId, reco);
            } else {
                Recommendation reco = target.recommendationList.get(visitorId);
                reco.score += 1;
            }
        }

        List<Id> keySet = new ArrayList<>(target.recommendationList.keySet());

        // Value 값으로 오름차순 정렬
        keySet.sort(new Comparator<Id>() {
            @Override
            public int compare(Id o1, Id o2) {
                if (target.recommendationList.get(o1).score == target.recommendationList.get(o2).score) {
                    return target.recommendationList.get(o1).id.id.compareTo(target.recommendationList.get(o2).id.id);
                }
                return target.recommendationList.get(o1).id == target.recommendationList.get(o2).id? 1 : 0;
            }
        });

        for (Id recoId : target.recommendationList.keySet()) {
            if (answer.size() > 5) break;
            answer.add(recoId.id);
        }
        return answer;
    }

    private static User7 addUser(Id id) {
        Optional<User7> result = repository.findById(id);

        if (result.isEmpty()) {
            User7 newUser = new User7(id);
            repository.save(newUser);
            return newUser;
        }

        return result.get();
    }

    static class User7 {
        Id id;
        List<User7> friends = new ArrayList<>();
        Map<Id, Recommendation> recommendationList = new HashMap<>();

        public User7(Id idValue) {
            id = idValue;
        }

        public void addFriend(User7 friend) {
            friends.add(friend);
        }

    }

    static class Id {
        String id;

        public Id(String idValue) {
            // 1 이상 30 이하인 문자열이며 소문자로만 이루어져 있다.
            if (!Pattern.matches("^[a-z]{1,29}$", idValue)) throw new RuntimeException("아이디는 1 이상 30 이하인 문자열이며 소문자로만 이루어져야 합니다.");
            id = idValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Id)) return false;
            Id id1 = (Id) o;
            return Objects.equals(id, id1.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    static class Recommendation {
        Id id;
        int score;

        public Recommendation(Id id, int score) {
            this.id = id;
            this.score = score;
        }
    }
}