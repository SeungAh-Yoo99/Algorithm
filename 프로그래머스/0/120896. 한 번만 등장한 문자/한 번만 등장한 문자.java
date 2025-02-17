class Solution {
    public String solution(String s) {
        
        // 등장 횟수를 저장하기 위한 배열
        int[] count = new int['z' - 'a' + 1];
        
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < count.length; i++)
            if(count[i] == 1) answer.append((char)(i + 'a'));
        return answer.toString();
    }
}