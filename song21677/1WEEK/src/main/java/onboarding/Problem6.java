package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Problem6 {
    static public List<User6> user = new ArrayList<>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        // user 추가
        for (List<String> form : forms) {
            try {
                Nickname nickname = new Nickname(form.get(1));
                Email email = new Email(form.get(0));
                user.add(new User6(nickname, email));
            } catch (RuntimeException e) {
                // 입력값 형식이 맞지 않을 때, 중복된 닉네임이 있을 때 사용자에 추가되지 않았을 때 answer에 넣는다.
                answer.add(form.get(0));
            }
        }

        // 중복된 닉네임을 가지고 있었지만 자신이 추가될 땐 중복된 값이 없었기에 user에 추가되었고
        // 따라서 해당 값을 user에서 가져와 answer에 담는 작업이다.
        for (User6 User6 : User6.duplicateUser6) {
            Email User6Email = User6.email;
            answer.add(User6Email.email);
        }

        answer.sort((email1, email2) -> email1.compareTo(email2));

        Set<String> set = new HashSet<String>(answer);

        answer =new ArrayList<String>(set);
        return answer;
    }
}
