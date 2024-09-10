import java.util.*;

class Solution {
    
    static String[][] tickets;
    static Map<String, ArrayList<Integer>> info;
    static boolean[] visited;
    static String[] answer;
    
    public String[] solution(String[][] tickets) {
        
        this.tickets = tickets;
        
        // 도착지를 기준으로 사전순 정렬
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        
        // 공항별 출발지로 가지고 있는 티켓 정보
        info = new HashMap<>();
        ArrayList<Integer> list;
        for(int i = 0; i < tickets.length; i++) {
            
            list = info.get(tickets[i][0]);
            
            if(list == null) {
                list = new ArrayList<>();
                info.put(tickets[i][0], list);
            }
            
            list.add(i);
        }
        
        // dfs로 가능한 경로 구하기
        visited = new boolean[tickets.length];
        
        answer = new String[tickets.length + 1];
        answer[0] = "ICN";
        
        dfs(0);
        
        return answer;
    }
    
    // idx := 몇 번째 여행지인지
    private static boolean dfs(int idx) {
        
        if(idx == tickets.length) {
            return true;
        }
        
        // 현재 위치에서 갈 수 있는 다음 목적지
        ArrayList<Integer> list = info.get(answer[idx]);
        
        // 다음으로 갈 수 있는 경로가 없음
        if(list == null) return false;
        
        // 다음으로 갈 수 있는 경로가 있음
        int next;
        for(int i = 0; i < list.size(); i++) {
            next = list.get(i);
            if(!visited[next]) {
                visited[next] = true;
                answer[idx + 1] = tickets[next][1];
                // 현재 경로가 가능한 경로인 경우
                if(dfs(idx + 1)) return true;
                visited[next] = false;
            }
        }
        
        // 현재 경로가 잘못된 경우
        return false;
    }
}