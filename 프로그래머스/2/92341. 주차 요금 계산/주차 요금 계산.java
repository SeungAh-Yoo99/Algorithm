import java.util.*;

class Solution {
    
    static int[] fees;
    
    public int[] solution(int[] fees, String[] records) {
        
        this.fees = fees;
        
        // 주차 중인 차량과 입차 시간을 담은 맵
        Map<String, Integer> in = new HashMap<>();
        
        // 누적 시간을 담은 맵
        Map<String, Integer> totalTime = new TreeMap<>();
        
        StringTokenizer st;
        String time, car, state;
        int minTime;
        for(String record : records) {
            st = new StringTokenizer(record);
            time = st.nextToken();
            car = st.nextToken();
            state = st.nextToken();
            
            // time을 분 시각으로 바꿈
            minTime = timeToMin(time);
            
            // 입차일 경우
            if(state.equals("IN")) {
                in.put(car, minTime);
            }
            // 출차일 경우
            else {
                // 누적 시간 구하기
                totalTime.put(car, totalTime.getOrDefault(car, 0) + (minTime - in.get(car)));
                
                // 출차 후 입차 목록에서 차 제거
                in.remove(car);
            }
        }
        
        // 출차하지 않은 차들 시간 구하기
        for(String key : in.keySet()) {
            totalTime.put(key, totalTime.getOrDefault(key, 0) + (timeToMin("23:59") - in.get(key)));
        }
        
        // 답 배열에 담기
        int[] answer = new int[totalTime.size()];
        int i = 0;
        for(String key : totalTime.keySet()) {
            answer[i++] = getPrice(totalTime.get(key));
        }
        
        return answer;
    }
    
    private int timeToMin(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        
        return hour * 60 + min;
    }
    
    private int getPrice(int time) {
        
        // 기본 시간을 초과하지 않았다면 기본 요금
        if(time <= fees[0]) return fees[1];
        // 기본 시간을 초과했다면
        else {
            time -= fees[0];
            return fees[1] + (time / fees[2]) * fees[3] + (time % fees[2] != 0 ? fees[3] : 0);
        }
    }
}