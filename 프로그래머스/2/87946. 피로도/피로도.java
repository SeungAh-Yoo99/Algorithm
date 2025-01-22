class Solution {
    
    int[][] dungeons;
    boolean[] visited;
    int answer;
    
    public int solution(int k, int[][] dungeons) {
        
        this.dungeons = dungeons;
        
        // 해당 던전을 클리어 했는지 체크
        visited = new boolean[dungeons.length];
        
        answer = -1;
        
        for(int i = 0; i < dungeons.length; i++) {
            if(k >= dungeons[i][0]) {
                visited[i] = true;
                backTracking(k - dungeons[i][1], 1);
                visited[i] = false;
            }
        }
        
        return answer;
    }
    
    void backTracking(int k, int count) {
        boolean flag = false;
        
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                backTracking(k - dungeons[i][1], count + 1);
                visited[i] = false;
                flag = true;
            }
        }
        
        // 더 이상 깰 수 있는 던전이 없다면
        if(!flag) {
            answer = Math.max(answer, count);
        }
    }
}