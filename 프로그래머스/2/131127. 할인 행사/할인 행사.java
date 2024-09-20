import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        
        Map<String, Integer> wantInfo = new HashMap<>(); // 원하는 제품과 수량 맵에 저장
        int totalCount = 0; // 원하는 제품의 총 개수
        for(int i = 0; i < want.length; i++) {
            wantInfo.put(want[i], number[i]);
            totalCount += number[i];
        }
        
        // 첫째 날부터 열흘 간의 할인 목록
        Integer count;
        for(int i = 0; i < 10; i++) {
            count = wantInfo.get(discount[i]);
            if(count != null) { // 현재 할인 중인 품목이 할인을 원하는 제품 목록에 있다면
                wantInfo.put(discount[i], count - 1);
                // count가 0보다 크다면 아직 해당 물품의 할인이 더 필요한 경우
                // count가 0보다 작거나 같다면 더 이상 해당 물품의 할인이 필요하지 않은 경우
                if(count > 0) totalCount--;
            }
        }
        // 첫째 날 회원가입을 하는 경우라면
        if(totalCount == 0) answer++;
        
        // 둘째 날부터 회원가입을 하는 경우 확인
        for(int i = 10; i < discount.length; i++) {
            // 10일 이전의 날은 경우에서 빼줌
            count = wantInfo.get(discount[i - 10]);
            if(count != null) {
                wantInfo.put(discount[i - 10], count + 1);
                if(count >= 0) totalCount++;
            }
            
            // 현재 날짜의 할인 물품 더해줌
            count = wantInfo.get(discount[i]);
            if(count != null) {
                wantInfo.put(discount[i], count - 1);
                if(count > 0) totalCount--;
            }
            
            // 필요한 물품이 다 포함된 경우
            if(totalCount == 0) answer++;
        }
    
        return answer;
    }
}