import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
       StringTokenizer st;
        
        // 현재 시간 구하기
        st = new StringTokenizer(pos, ":");
        int now = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        
        // 비디오 길이 구하기
        st = new StringTokenizer(video_len, ":");
        int len = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        
        // 오프닝 건너뛰기
        st = new StringTokenizer(op_start, ":");
        int start = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        st = new StringTokenizer(op_end, ":");
        int end = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        
        // 명령 수행
        for(String command : commands) {
            if(start <= now && now <= end) now = end;
            if(command.equals("prev")) {
                now = now - 10 <= 0 ? 0 : now - 10;
            }
            else {
                now = now + 10 >= len ? len : now + 10;
            }
        }
        if(start <= now && now <= end) now = end;
        
        // 시간 변환
        int hour = now / 60;
        int minute = now % 60;
        StringBuilder answer = new StringBuilder();
        if(hour < 10) answer.append("0");
        answer.append(hour).append(":");
        if(minute < 10) answer.append("0");
        answer.append(minute);
        
        return answer.toString();
    }
}