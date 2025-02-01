import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        
        // arr의 시작과 끝을 가리키는 인덱스
        int start = 0, end = arr.length - 1;
        
        // query를 순회하며 작업을 반복
        for(int i = 0; i < query.length; i++) {
            if(i % 2 == 0) { // 짝수 인덱스인 경우에는
                end = start + query[i]; // 뒷부분을 자르기
            }
            else { // 홀수 인덱스인 경우에는
                start = start + query[i]; // 앞부분을 자르기
            }
        }
        
        // 남은 부분 배열 리턴
        return Arrays.copyOfRange(arr, start, end + 1);
    }
}