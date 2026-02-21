import java.util.*;

class Solution {
    
    private int[] parents;
    
    public int solution(int n, int[][] costs) {
        
        // 유니온 파인드
        parents = new int[n];
        for(int i = 1; i < n; i++)
            parents[i] = i;
        
        // 비용이 적은 다리 순으로 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        // 비용이 적은 다리부터 건설
        int answer = 0;
        for(int i = 0; i < costs.length; i++) {
            if(union(costs[i][0], costs[i][1]))
                answer += costs[i][2];
        }
        
        return answer;
    }
    
    private boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        
        // 이미 연결되어 있는 경우
        if(a == b) return false;
        
        // 새로 연결한 경우
        if(a < b) parents[b] = a;
        else parents[a] = b;
        return true;
    }
    
    private int find(int a) {
        if (parents[a] == a) return a;
        
        return find(parents[a]);
    }
}