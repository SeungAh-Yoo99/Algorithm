import java.util.*;

class Solution {
    public int solution(int[] number) {
        
        // 정렬
        Arrays.sort(number);
        
        // 두 개의 조합과 한 개의 포인터
        int answer = 0;
        int pointer, sum;
        for(int i = 0; i < number.length - 2; i++) {
            for(int j = i + 1; j < number.length - 1; j++) {
                pointer = number.length - 1;
                sum = number[i] + number[j] + number[pointer];
                while(sum >= 0 && pointer > j) {
                    if(sum == 0) answer++;
                    sum -= number[pointer];
                    sum += number[--pointer];
                }
            }
        }

        return answer;
    }
}