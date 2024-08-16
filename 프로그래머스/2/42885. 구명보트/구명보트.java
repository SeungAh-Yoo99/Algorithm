import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        
        // 몸무게 오름차순 정렬
        Arrays.sort(people);
        
        // 가벼운 사람 먼저 가리키는 포인터
        int l = 0;
        // 무거운 사람 먼저 가리키는 포인터
        int r = people.length - 1;
        
        int answer = 0;
        while(l <= r) {
            // 현재 가장 무거운 사람과 현재 가장 가벼운 사람이 함께 이동할 수 있는지 체크
            
            if(people[l] + people[r] <= limit) { // 함께 이동할 수 있는 경우
                answer++;
                l++; // 둘 다 이동
                r--;
            }
            else { // 함께 이동할 수 없는 경우
                answer++;
                r--; // 무거운 사람만 이동
            }
        }

        return answer;
    }
}