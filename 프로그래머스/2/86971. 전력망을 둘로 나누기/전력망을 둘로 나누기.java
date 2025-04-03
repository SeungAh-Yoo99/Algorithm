import java.util.*;

class Solution {
    
    int answer, n;
    List<List<Integer>> edges;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        
        this.n = n;
        
        // 최소값을 구하기 위해 최대값을 저장해둠
        answer = n;
        
        // 각 송전탑에 연결되어 있는 wire 정보
        edges = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            edges.add(new ArrayList<>());
        
        for(int i = 0; i < wires.length; i++) {
            // 양방향 연결
            edges.get(wires[i][0]).add(wires[i][1]);
            edges.get(wires[i][1]).add(wires[i][0]);
        }
        
        // 루트 노드를 무조건 1이라고 생각
        // 재귀를 통해 자식 노드들의 연결을 하나씩 끊어보기
        
        // 부모 노드로 역행하지 않기 위한 방문 배열
        visited = new boolean[n + 1];
        visited[1] = true;
        
        for(int i = 0; i < edges.get(1).size(); i++)
            getSubTree(edges.get(1).get(i));
        
        return answer;
    }
    
    // root를 루트 노드로 가진 서브 트리 원소 개수를 리턴
    private int getSubTree(int root) {
        
        visited[root] = true;
        
        // root에 연결된 노드 리스트 가져오기
        List<Integer> edge = edges.get(root);
        
        // 연결된 노드가 1개라면 리프 노드임
        if(edge.size() == 1) {
            answer = Math.min(answer, (n - 1) - 1);
            // 현재 노드가 리프 노드이므로
            // 현재 노드를 루트 노드로 하는 서브 트리의 원소 개수는 1개
            return 1;
        }
        
        int child, countChild = 0;
        for(int i = 0; i < edge.size(); i++) {
            child = edge.get(i);
            if(!visited[child])
                countChild += getSubTree(child); // 자식 노드 개수 구하기
        }
        // 현재 노드를 루트 노드로 하는 서브 트리의 노드 개수
        int count = countChild + 1; // 자식 노드 개수 + 루트 노드
        
        // 현재 노드를 루트 노드로 하는 서브 트리와
        // 1을 루트 노드로 하는 트리의 개수 차이 구하기
        answer = Math.min(answer, Math.abs((n - count) - count));
        return count;
    }
}