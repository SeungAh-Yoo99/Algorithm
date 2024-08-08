import java.util.*;

class Solution {
    
    static Map<Long, Long> map;
    
    public long[] solution(long k, long[] room_number) {
        
        long[] answer = new long[room_number.length];
        
        map = new HashMap<>();
        
        for(int i = 0; i < room_number.length; i++) {
            answer[i] = getEmptyRoom(room_number[i]);
        }
        return answer;
    }
    
    private static long getEmptyRoom(long n) {
        
        // 배정 받을 방 번호
        Long emptyRoom = map.get(n);
        
        // n번 방이 아직 배정받지 않았다면
        if(emptyRoom == null) {
            map.put(n, n + 1); // 다음 배정받을 방을 가리키고
            return n; // n번 방에 배정
        }
        
        // n번 방이 이미 배정받은 방이라면 다음 방을 찾아봄
        long room = getEmptyRoom(emptyRoom);
        map.put(n, room + 1);
        return room;
    }
}