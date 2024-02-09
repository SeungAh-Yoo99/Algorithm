import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int answer = 0;
        
        // 친구들의 수
        int num = friends.length;
        
        // 해당 이름의 인덱스를 저장
        Map<String, Integer> nameIndex = new HashMap<>();
        for(int i = 0; i < num; i++) {
            nameIndex.put(friends[i], i);
        }
        
        // 선물을 주고 받은 횟수
        // count[i][j][0] := i번째 사람이 j번째 사람에게 준 선물 개수
        // count[i][j][1] := i번째 사람이 j번째 사람에게 받은 선물 개수
        // count[i][i][0] := i번째 사람이 준 총 선물 개수
        // count[i][i][1] := i번째 사람이 받은 총 선물 개수
        int[][][] count = new int[num][num][2];
        StringTokenizer st;
        int A, B;
        for(int i = 0; i < gifts.length; i++) {
            st = new StringTokenizer(gifts[i]);
            A = nameIndex.get(st.nextToken()); // 준 사람
            B = nameIndex.get(st.nextToken()); // 받은 사람
            count[A][B][0]++;
            count[A][A][0]++;
            count[B][A][1]++;
            count[B][B][1]++;
        }
        
        // 다음달에 받을 선물 개수
        int[] next = new int[num];
        
        // 두 사람씩 선물 주고 받을 수 있는지 확인
        for(int i = 0; i < num - 1; i++) {
            for(int j = i + 1; j < num; j++) {
                // 1. 두 사람이 선물을 주고받은 기록이 있다면, 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받는다.
                if(count[i][j][0] > 0 || count[i][j][1] > 0) {
                    if(count[i][j][0] > count[i][j][1]) { // i가 j에게 준게 더 많다면
                        next[i]++;
                        continue;
                    }
                    else if(count[i][j][0] < count[i][j][1]) { // i가 j에게 받은게 더 많다면
                        next[j]++;
                        continue;
                    }
                }
                // 2. 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 더 작은 사람에게 선물을 하나 받는다.
                if(count[i][i][0] - count[i][i][1] > count[j][j][0] - count[j][j][1]) { // i의 선물 지수가 더 큰 경우
                    next[i]++;
                }
                else if(count[i][i][0] - count[i][i][1] < count[j][j][0] - count[j][j][1]) { // j의 선물 지수가 더 큰 경우
                    next[j]++;
                }
            }
        }
        
        // 가장 많은 선물을 받는 친구 찾기
        for(int i = 0; i < num; i++) answer = Math.max(answer, next[i]);
        
        return answer;
    }
}