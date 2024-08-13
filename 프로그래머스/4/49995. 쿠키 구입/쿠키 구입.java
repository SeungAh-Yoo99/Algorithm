import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        
        // 누적합 저장
        int[] sum = new int[cookie.length + 1];
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= cookie.length; i++) {
            sum[i] += sum[i - 1] + cookie[i - 1];
            set.add(sum[i]);
        }
        
        // 첫째 아들에게 줄 바구니 범위를 정하고
        // 둘째 아들에게 줄 수 있는 같은 과자 수의 바구니 범위가 있는지 확인
        int answer = 0; // 최대값
        int firstChild;
        for(int i = 0; i < cookie.length; i++) {
            for(int j = i + 1; j <= cookie.length; j++) {
                firstChild = sum[j] - sum[i]; // 첫째 아들에게 줄 바구니 범위를 정하고, 범위 안의 과자 수를 저장
                // firstChild와 같은 과자 수를 가진 바구니의 범위가 있는지 확인
                // (answer보다 과자 수가 많을 때만 검사)
                if(answer < firstChild && set.contains(sum[j] + firstChild)) {
                    answer = firstChild;
                }
                
            }
        }
        return answer;
    }
}