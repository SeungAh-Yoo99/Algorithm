class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int cnt1  = 0, cnt2 = 0;
        char x = 'A';
        for(int i = 0; i < s.length(); i++) {
             if(cnt1 == 0) { // 첫 글자 읽기
                 x = s.charAt(i);
                 cnt1 = 1;
                 answer++; // 첫 글자를 읽을 때 분리된 문자열 개수 세주기
             }
            else {
                if(x != s.charAt(i)) { // 첫 글자와 다른 글자라면
                    cnt2++;
                    if(cnt1 == cnt2) { // 두 횟수가 같아지는 순간
                        cnt1 = 0;
                        cnt2 = 0;
                    }
                }
                else cnt1++; // 첫 글자와 같은 글자라면
            }
        }
        
        return answer;
    }
}