import java.util.*;

class Solution {
    public String solution(String polynomial) {
        
        // +를 기준으로 문자열 자르기
        StringTokenizer st = new StringTokenizer(polynomial, "+ ");
        
        // x의 개수
        int x = 0;
        // 상수의 개수
        int n = 0;
        
        String tmp;
        while(st.hasMoreTokens()) {
            tmp = st.nextToken();
            
            // x인 경우
            if(tmp.equals("x")) x += 1;
            else if(tmp.charAt(tmp.length() - 1) == 'x')
                x += Integer.parseInt(tmp.substring(0, tmp.length() - 1));
            else
                n += Integer.parseInt(tmp);
        }
        
        String answer = "";
        if(x != 0) { // x값을 출력해야 하는 경우
            if(x != 1) { // 계수 1은 생략
                answer += x;
            }
            answer += "x";
            
            if(n != 0) // 뒤에 상수 값도 출력해야 하는 경우
                answer += " + ";
        }
        if(n != 0) answer += n;
        
        return answer;
    }
}