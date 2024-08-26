import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[] {1, gems.length};
        
        // 몇 종류의 보석이 있는지 확인
        Set<String> set = new HashSet<>();
        for(String gem : gems) {
            set.add(gem);
        }
        int kindOfGems = set.size();
        
        // 보석 종류가 한 가지인 경우
        if(kindOfGems == 1) {
            answer[0] = 1;
            answer[1] = 1;
            return answer;
        }
        
        // 투 포인터 사용
        int left = 0, right = 0;
        
        // 투 포인터 이내에 key에 해당하는 보석의 개수 저장
        Map<String, Integer> map = new HashMap<>();
        map.put(gems[0], 1);
        
        
        int count;
        while(left < gems.length && right < gems.length) {
            
            // 보석 종류가 모자르면 포함
            if(map.size() < kindOfGems) {
                // 오른쪽 포인터가 이미 마지막을 가리키고 있다면
                if(right == gems.length - 1) break;
                
                right++;
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            }
            // 종류가 모자르진 않다면 범위를 줄일 수 있는지 확인
            else {
                count = map.get(gems[left]);
                if(count == 1) map.remove(gems[left]);
                else map.put(gems[left], count - 1);
                left++;
            }
            
            // 현재 left ~ right 범위에 모든 종류의 보석을 가지고 있다면
            // 더 좁은 범위의 답을 answer에 저장
            if(map.size() == kindOfGems) {
                if(right - left < answer[1] - answer[0]) {
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
            }
        }
        
        return answer;
    }
}