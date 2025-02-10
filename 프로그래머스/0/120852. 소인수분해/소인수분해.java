import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        // 소수가 아닌 수 체크
        boolean[] isNotPN = new boolean[n + 1];
        
        // n의 소인수를 임시로 담을 리스트
        List<Integer> list = new ArrayList<>();
        
        int j;
        for(int i = 2; i <= n; i++) {
            if(!isNotPN[i]) { // i가 소수인 경우
                j = i;
                while(j <= n) {
                    isNotPN[j] = true; // 소인수 i의 배수들은 소인수가 아님
                    j += i;
                }
                // i가 n의 소인수인 경우, 리스트에 담아줌
                if(j - i == n) list.add(i);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}