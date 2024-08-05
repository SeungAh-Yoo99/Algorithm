import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        char[] tmp = s.toCharArray(); // 문자열을 char 배열로 변환
        Queue<Character> q = new LinkedList<>(); // 0과 1을 큐에 담아 관리
        for(int i = 0; i < tmp.length; i++) q.add(tmp[i]);
        
        int count;
        while(q.size() > 1) { // 문자열이 "1"이 될 때까지
            
            // 변환 횟수
            answer[0]++;
            
            // 1의 개수
            count = 0;
            
            // 큐에서 문자를 하나씩 빼며 검사
            while(!q.isEmpty()) {
                // '0'이라면 제거된 0의 개수 증가
                if(q.poll() == '0') answer[1]++;
                // '1'이라면 1 개수 증가
                else count++;
            }
            
            // 1 개수를 이진 변환 후 문자들을 큐에 담아 가져옴
            q = changeBinary(count);
        }
        
        return answer;
    }
    
    private static Queue<Character> changeBinary(int n) { // n을 이진 변환 후, 문자들을 큐에 담아 리턴
        
        int b = 18; // 아무리 커도 2의 18진수보다 크지 않음
        
        Queue<Character> ret = new LinkedList<>();
        while(b >= 0) {
            if(n >= Math.pow(2, b)) {
                ret.add('1');
                n -= Math.pow(2, b);
            }
            else ret.add('0');
            
            b--;
        }
        
        // 앞의 0 없애기
        while(ret.peek() == '0') ret.poll();
        
        return ret;
    }
}
