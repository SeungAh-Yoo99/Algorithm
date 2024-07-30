import java.util.*;

class Solution {
    
    static Map<Integer, Integer> map;
    static PriorityQueue<Integer> ascPq;
    static PriorityQueue<Integer> descPq;
    
    static final long MAX = Long.MAX_VALUE;
    
    public int[] solution(String[] operations) {
        
        // 현재 key값에 해당하는 수가 몇 개인지 저장할 Map
        map = new HashMap<>();
        
        // 올림차순으로 졍렬할 큐
        ascPq = new PriorityQueue<>();
        
        // 내림차순으로 정렬할 큐
        descPq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        // 명령 수행
        String c;
        int code, count;
        StringTokenizer st;
        for(int i = 0; i < operations.length; i++) {
            st = new StringTokenizer(operations[i], " ");
            
            c = st.nextToken();
            code = Integer.parseInt(st.nextToken());
            
            if(c.equals("I")) { // 데이터 추가일 경우
                map.put(code, map.getOrDefault(code, 0) + 1);
                ascPq.add(code);
                descPq.add(code);
            }
            else { // 데이터 삭제 연산일 경우
                if(code == 1) { // 최댓값 삭제
                    getMaxNum();
                }
                else { // 최솟값 삭제
                    getMinNum();
                }
            }
        }
        
        // 마지막으로 큐에 남아있는 최댓값, 최솟값 찾기
        int[] result = new int[2];
        
        // 최댓값 찾기
        long tmp = getMaxNum();
        
        // 만약 최댓값이 없다면 최솟값도 없음
        if(tmp == MAX) return result;

        // 최댓값이 있다면 저장
        result[0] = (int)tmp;
        
        // 최솟값 찾기
        tmp = getMinNum();
        
        // 만약 최솟값이 따로 없다면 최댓값과 같음
        if(tmp == MAX) result[1] = result[0];
        // 아니라면 따로 찾은 최솟값 저장
        else result[1] = (int)tmp;
        
        return result;
    }
    
    private static long getMaxNum() { // 최댓값 뽑기

        int ret, count;
        while(!descPq.isEmpty()) {
            ret = descPq.poll(); // 현재 최댓값 뽑기

            // 아직 큐에서 제거되지 않은 수인지 확인
            count = map.get(ret);
            if(count > 0) {
                map.put(ret, count - 1);
                return ret;
            }
            // 이미 큐에서 제거된 수라면 다시 최댓값 뽑기
        }
        
        return MAX;
    }
    
    private static long getMinNum() { // 최솟값 뽑기
        
        int ret, count;
        while(!ascPq.isEmpty()) {
            ret = ascPq.poll(); // 현재 최솟값 뽑기

            // 아직 큐에서 제거되지 않은 수인지 확인
            count = map.get(ret);
            if(count > 0) {
                map.put(ret, count - 1);
                return ret;
            }
            // 이미 큐에서 제거된 수라면 다시 최솟값 뽑기
        }
        
        return MAX;
    }
}