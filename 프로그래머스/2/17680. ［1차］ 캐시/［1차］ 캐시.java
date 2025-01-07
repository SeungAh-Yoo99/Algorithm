import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        // 캐시 정보
        Deque<String> cache = new ArrayDeque<>();
        
        for(String city : cities) {
            
            // 대소문자 구분 없음
            city = city.toLowerCase();
            
            if(cache.contains(city)) { // 캐시에 이미 정보가 있다면
                answer += 1; // 실행시간은 + 1
                cache.remove(city); // LRU에 따라 다시 맨 뒤로 보내줌
            }
            else { // 캐시에 정보가 없다면
                answer += 5; // 실행시간은 + 5
                if(cache.size() >= cacheSize) { // 캐시가 꽉 찼다면
                    cache.pollFirst(); // 가장 오래 전에 쓰인 데이터 삭제
                }
            }
            if(cache.size() < cacheSize) cache.addLast(city);
        }
        
        return answer;
    }
}