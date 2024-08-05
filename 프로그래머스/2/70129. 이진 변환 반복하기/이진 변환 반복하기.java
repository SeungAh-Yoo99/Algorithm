import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        char[] tmp = s.toCharArray(); // 문자열을 char 배열로 변환
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < tmp.length; i++) q.add(tmp[i]);
        
        int count; // 1의 개수
        while(q.size() > 1) {
            
            answer[0]++;
            
            count = 0;
            
            while(!q.isEmpty()) {
                if(q.poll() == '0') answer[1]++;
                else count++;
            }
            
            q = changeBinary(count);
        }
        
        return answer;
    }
    
    private static Queue<Character> changeBinary(int n) {
        
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