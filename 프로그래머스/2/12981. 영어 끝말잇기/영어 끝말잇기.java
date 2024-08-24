import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // 나왔던 단어를 담아두는 set
        Set<String> isUsed = new HashSet<>();
        isUsed.add(words[0]);
        
        char[] word = words[0].toCharArray();
        
        // 이전 단어의 마지막 문자
        char last = word[word.length - 1];
        
        for(int i = 1; i < words.length; i++) {
            
            word = words[i].toCharArray();
            
            // 앞사람이 말한 단어의 마지막 문자로 시작하지 않은 경우나
            // 이전에 등장했던 단어를 사용한 경우
            if(last != word[0] || isUsed.contains(words[i])) {
                answer[0] = i % n + 1; // 틀린 사람
                answer[1] = i / n + 1; // 차례
                break;
            }
            else {
                last = word[word.length - 1];
                isUsed.add(words[i]);
            }
        }

        return answer;
    }
}