class Solution {
    public String solution(String s, String skip, int index) {
        
        // 각 알파벳이 skip에 포함되는지 여부 확인
        boolean[] inSkip = new boolean['z' - 'a' + 1];
        for(int i = 0; i < skip.length(); i++) {
            inSkip[skip.charAt(i) - 'a'] = true;
        }
        
        StringBuilder answer = new StringBuilder();
        
        int now;
        for(int i = 0; i < s.length(); i++) {
            now = s.charAt(i) - 'a';
            for(int j = 0; j < index; j++) {
                now = now == 'z' - 'a' ? 0 : now + 1;
                while(inSkip[now]) {
                    now = now == 'z' - 'a' ? 0 : now + 1;
                }
            }
            answer.append((char)('a' + now));
        }
        
        
        return answer.toString();
    }
}