import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        
        // 참석 가능한 학생들의 번호와 랭크를 담는 리스트
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < rank.length; i++) {
            if(attendance[i]) list.add(new int[] {i, rank[i]});
        }
        
        // 랭크를 기준으로 올림차순 정렬
        Collections.sort(list, (o1, o2) -> o1[1] - o2[1]);
        
        int answer = 10000 * list.get(0)[0] + 100 * list.get(1)[0] + list.get(2)[0];
        return answer;
    }
}