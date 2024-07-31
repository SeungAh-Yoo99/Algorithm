import java.util.*;

class Solution {
    
    static int[][] triangle;
    static int[][] visited;
    
    public int solution(int[][] triangle) {
        
        this.triangle = triangle;
        
        // dfs를 이용하여 왼쪽 대각선으로 이동한 경우와 오른쪽 자식으로 이동한 경우 중
        // 더 큰 경우를 선택함
    
        // 이전 경우에서 이미 구한 경우는 다시 구하지 않음
        visited = new int[triangle.length][triangle.length];
        for(int i = 0; i < triangle.length; i++) Arrays.fill(visited[i], -1);
        
        // dfs
        int answer = dfs(0, 0);
        return answer;
    }
    
    private static int dfs(int height, int index) {
        
        int ret = triangle[height][index];
        
        // 리프 노드일 경우 자기 자신 리턴
        if(height == triangle.length - 1) {
            visited[height][index] = ret;
            return ret;
        }
        
        // 대각선 왼쪽으로 이동한 경우
        int leftChild;
        if(visited[height + 1][index] == -1) // 이전 노드에서 아직 안구한 곳만 다시 구하러 감
            leftChild = dfs(height + 1, index);
        else leftChild = visited[height + 1][index];
        
        // 대각선 오른쪽으로 이동한 경우(오른쪽 경우는 무조건 처음 구함)
        int rightChild = dfs(height + 1, index + 1);
        
        // 더 큰 경우를 더해줌
        ret += Math.max(leftChild, rightChild);
        
        visited[height][index] = ret;
        return ret;
    }
}