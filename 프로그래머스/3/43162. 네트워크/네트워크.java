class Solution {
    
    static int[] parent;
    
    public int solution(int n, int[][] computers) {

        // 유니온 파인드로 네트워크 개수 구하기
        parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(computers[i][j] == 1) union(i, j);
            }
        }
        
        // 네트워크 개수 세기
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(parent[i] == i) answer++;
        }
        
        return answer;
    }
    
    private static int find(int a) {
        if(parent[a] == a) return a;
        
        return parent[a] = find(parent[a]);
    }
    
    private static void union(int a, int b) {
        
        a = find(a);
        b = find(b);
        
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
} 
