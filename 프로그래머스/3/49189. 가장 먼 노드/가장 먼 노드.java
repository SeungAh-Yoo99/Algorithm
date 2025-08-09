import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int maxLength = 0;
        
        // 최단거리를 저장할 배열
        int[] minLength = new int[n + 1];
        Arrays.fill(minLength, n);
        minLength[1] = 0;
        
        // 간선 정보를 저장할 리스트
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            edges.add(new ArrayList<>());
        
        // 간선 정보 저장
        for(int i = 0; i < edge.length; i++) {
            edges.get(edge[i][0]).add(edge[i][1]);
            edges.get(edge[i][1]).add(edge[i][0]);
        }
        
        // 다익스트라
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                                        (o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] {1, 0});
        
        int[] now;
        ArrayList<Integer> e;
        int next;
        while(!pq.isEmpty()) {
            now = pq.poll();
            
            // 이미 최단거리를 구했다면 넘어가기
            if(minLength[now[0]] < now[1]) continue;
            
            // 가장 멀리 떨어진 노드인지 확인
            if(maxLength < now[1]) {
                maxLength = now[1];
                answer = 1;
            }
            else if(maxLength ==  now[1])
                answer++;
            
            // now에서 연결된 간선 이동
            e = edges.get(now[0]);
            for(int i = 0; i < e.size(); i++) {
                next = e.get(i);
                if(minLength[next] > now[1] + 1) {
                    minLength[next] = now[1] + 1;
                    pq.add(new int[] {next, now[1] + 1});
                }
            }
        }
        
        return answer;
    }
}