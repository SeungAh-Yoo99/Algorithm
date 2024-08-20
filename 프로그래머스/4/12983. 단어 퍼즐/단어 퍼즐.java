import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        
        // 단어 조각을 char 배열로 변환
        char[][] strsArr = new char[strs.length][];
        for(int i = 0; i < strs.length; i++) {
            strsArr[i] = strs[i].toCharArray();
        }
        
        // 완성해야 하는 문자열 char 배열로 변환
        char[] tArr = t.toCharArray();
        
        // 더 적은 단어 조합을 발견했을 경우에만 진행
        int[] count = new int[tArr.length];
        Arrays.fill(count, Integer.MAX_VALUE);
        
        // 문자열 조합 정보
        // 배열[0] := 시작 인덱스
        // 배열[1] := 몇 개의 단어를 사용했는지
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        
        int answer = -1;
        
        int[] now; boolean flag;
        while(!q.isEmpty()) {
            now = q.poll();
            
            // now[0]부터 동일한 단어 조각이 있는지 확인
            for(int i = 0; i < strsArr.length; i++) {
                flag = true;
                for(int j = 0; j < strsArr[i].length; j++) {
                    if(now[0] + j >= tArr.length || tArr[now[0] + j] != strsArr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                // 연결할 수 있는 단어 조각이라면
                if(flag) {
                    // 단어를 완성한 경우
                    if(now[0] + strsArr[i].length == tArr.length) {
                        answer = answer == -1 ? now[1] + 1 : Math.min(answer, now[1] + 1);
                    }
                    // 더 적은 단어 조각으로 문장을 완성할 수 있는 경우
                    else if(count[now[0] + strsArr[i].length] > now[1] + 1){
                        count[now[0] + strsArr[i].length] = now[1] + 1;
                        q.add(new int[] {now[0] + strsArr[i].length, now[1] + 1});
                    }
                }
            }
        }

        return answer;
    }
}