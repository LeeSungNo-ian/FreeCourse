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
                // 입력값 형식이 맞지 않을 때, 중복된 닉네임이 있을 때 사용자에 추가되지 않았을 때 answer에 넣습니다.
                answer.add(form.get(0));
            }
        }

        // 중복된 닉네임을 가지고 있었지만 자신이 추가될 땐 중복된 값이 없었기에 user에 추가되었고
        // 따라서 해당 값을 user에서 가져와 answer에 담는 작업입니다.
        for (User6 User6 : User6.duplicateUser6) {
            Email User6Email = User6.email;
            answer.add(User6Email.email);
        }

        answer.sort((email1, email2) -> email1.compareTo(email2));

        Set<String> set = new HashSet<String>(answer);

        answer =new ArrayList<String>(set);
        return answer;
    }
    static class User6 {
        static List<User6> duplicateUser6 = new ArrayList<>();
        Nickname nickname;
        Email email;

        public User6(Nickname nickname, Email email) {
            this.nickname = nickname;
            this.email = email;
        }
    }
    static class Nickname {
        String nickname;

        public Nickname(String nicknameValue) throws RuntimeException {
            validate(nicknameValue);
            checkDuplicate(nicknameValue);
            nickname = nicknameValue;
        }

        private void validate(String nicknameValue) {
            if (!Pattern.matches("^[가-힣]{1,19}$", nicknameValue)) {
                throw new RuntimeException("닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이어야 합니다.");
            }
        }

        private void checkDuplicate(String nicknameValue) {
            for (User6 User6 : Problem6.user) {
                if (isDuplicate(User6.nickname, nicknameValue)) {
                    User6.duplicateUser6.add(User6);
                    throw new RuntimeException("닉네임이 중복되었습니다.");
                }
            }
        }

        private boolean isDuplicate(Nickname User6Nickname, String nickname) {
            String storedNickname = User6Nickname.nickname;

            int storedNickPointer = 0;
            int nickPointer = 0;
            boolean isSamePreChar = false;

            while (nickPointer < nickname.length()) {
                if (storedNickname.charAt(storedNickPointer) == nickname.charAt(nickPointer)) {
                    if (isSamePreChar) return true;

                    isSamePreChar = true;
                    storedNickPointer++;
                    nickPointer++;
                } else {
                    isSamePreChar = false;
                    nickPointer++;
                }
            }
            return false;
        }
    }

    static class Email {
        String email;

        public Email(String emailValue) throws RuntimeException {
            validate(emailValue);
            email = emailValue;
        }

        private void validate(String emailValue) {
            if (!Pattern.matches("^[A-Za-z]{1,8}@email.com", emailValue)) {
                throw new RuntimeException("이메일은 이메일 형식에 부합하며 11자 이상 20자 미만이어야 합니다.");
            }
        }
    }

}

