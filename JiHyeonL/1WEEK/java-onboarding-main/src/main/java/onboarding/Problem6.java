package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        FindDuplicate sameForms = new FindDuplicate();

        return sameForms.result(forms);
    }

    /**
     * 중복 닉네임 찾는 클래스
     */
    static class FindDuplicate{
        // map<key:이름 두글자 문자열, value:인덱스>
        public static HashMap<String,Integer> allForms = new HashMap<>();
        public static List<Integer> indexList = new ArrayList<>();
        public static List<String> answer = new ArrayList<>();
        /*
         * 중복이 존재하는 form의 이메일 주소를 반환하는 메소드
         */
        public static List<String> result(List<List<String>> forms) {
            for(int index: DupIndexList(forms)) {
                answer.add(forms.get(index).get(0));
            }
            Collections.sort(answer);
            return answer;
        }
        /*
         * 중복이 존재하는 form의 인덱스 list를 반환하는 메소드
         */
        public static List<Integer> DupIndexList(List<List<String>> forms) {
            for(int i = 0; i < forms.size()-1; i++) {
                // 처음 문자열인 경우
                if(allForms.isEmpty()) {
                    nameIndexMap(splitTwo(forms.get(i).get(1)),i);
                    continue;
                }
                // 현재 문자열과 map 중 중복되는 문자열이 있는지 검사
                for(String str: splitTwo(forms.get(i).get(1))) {
                    // 중복되는 것이 있을 경우
                    if(allForms.containsKey(str)) {
                        indexSet(allForms.get(str),i);  // 인덱스 리스트에 넣기
                        continue;
                    }
                    // 중복되는 것이 없을 경우
                    allForms.put(str,i);
                }
            }
            return indexList;
        }
        /*
         * 이름을 두글자 문자열로 분리해서 list로 반환하는 메소드
         */
        public static List<String> splitTwo(String name) {
            List<String> split = new ArrayList<>();
            for(int i = 0; i < name.length()-1; i++) {
                split.add(name.substring(i,i+2));
            }
            return split;
        }
        /*
         * hashmap에 이름 key와 인덱스 value 넣어주는 메소드
         */
        public static void nameIndexMap(List<String> name,int index) {
            for(String n: name) {
                allForms.put(n,index);
            }
        }
        /*
         * 리스트에 중복 인덱스 제외하고 추가하는 메소드
         */
        public static void indexSet(int idx1, int idx2) {
            if(!indexList.contains(idx1))
                indexList.add(idx1);
            if(!indexList.contains(idx2))
                indexList.add(idx2);
        }

    }



}
