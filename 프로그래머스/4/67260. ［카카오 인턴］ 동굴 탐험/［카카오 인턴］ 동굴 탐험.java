import java.util.*;

class Solution {
    
    public boolean solution(int n, int[][] path, int[][] order) {
        // 인접한 동굴 정보를 담을 리스트
        ArrayList<Queue<Integer>> edges = new ArrayList<>();
        for(int i = 0; i < n; i++)
            edges.add(new LinkedList<>());
        for(int i = 0; i < n - 1; i++) {
            edges.get(path[i][0]).add(path[i][1]);
            edges.get(path[i][1]).add(path[i][0]);
        }
        
        // 먼저 방문해야 하는 동굴 리스트
        int[] preVisit = new int[n];
        for(int i = 0; i < order.length; i++) {
            // 0번 방보다 먼저 방문해야 하는 방이 있으면 절대 모든 방을 탐험할 수 없음
            if(order[i][1] == 0) return false;
            
            preVisit[order[i][1]] = order[i][0];
        }
        
        // 방문 완료한 동굴 리스트
        boolean[] visited = new boolean[n];
        
        // dfs 대신, 방문 경로를 담을 스택
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        visited[0] = true;
        
        int answer = 0;
        
        int now, next;
        while(!stack.isEmpty()) {        
            now = stack.peekLast();
            
            // 연결된 방 중, 더 이상 확인할 방이 없는 경우
            if(edges.get(now).size() == 0) {
                answer++;
                stack.pollLast();
                continue;
            }
            
            next = edges.get(now).poll();
            // 역행 방지
            if(visited[next]) continue;
            
            // 아직 선행 방이 미방문 상태라면
            if(!visited[preVisit[next]])
                // 선행 방에 임의의 간선 연결
                // 선행 방에 방문 후, 방문할 수 있게 하기
                edges.get(preVisit[next]).add(next);
            else {
                // 다음 방 방문하기
                stack.addLast(next);
                visited[next] = true;
            }
        }
        
        if(answer == n) return true;
        else return false;
    }
}