class Solution {
    
    String[] park;
    int N, M;
    
    public int[] solution(String[] park, String[] routes) {
        
        // 공원 정보
        this.park = park;
        N = park.length;
        M = park[0].length();
        
        // 로봇 강아지의 위치
        int[] now = new int[] {-1, -1};
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(park[i].charAt(j) == 'S') {
                    now = new int[] {i, j};
                    break;
                }
            }
            if(now[0] != -1) break;
        }
        
        // 명령 실행
        char op; int n;
        for(int i = 0; i < routes.length; i++) {
            op = routes[i].charAt(0);
            n = routes[i].charAt(2) - '0';
            
            if(!isOut(now, op, n) && !meetObstacle(now, op, n)) {
                now = move(now, op, n);
            }
        }
        
        return now;
    }
    
    // 주어진 방향으로 이동할 때 공원을 벗어나는지 확인
    boolean isOut(int[] now, char op, int n) {
        
        int[] next = new int[2];
        
        switch(op) {
            case 'N':
                next[0] = now[0] - n;
                next[1] = now[1];
                break;
            case 'S':
                next[0] = now[0] + n;
                next[1] = now[1];
                break;
            case 'W':
                next[0] = now[0];
                next[1] = now[1] - n;
                break;
            case 'E':
                next[0] = now[0];
                next[1] = now[1] + n;
        }
        
        if(next[0] >= 0 && next[0] < N && next[1] >= 0 && next[1] < M) return false;
        else return true;
    }
    
    // 주어진 방향으로 이동 중 장애물을 만나는지 확인
    boolean meetObstacle(int[] now, char op, int n) {
        
        if(op == 'N') {
            for(int i = 1; i <= n; i++) {
                if(park[now[0] - i].charAt(now[1]) == 'X') return true;
            }
        }
        else if(op == 'S') {
            for(int i = 1; i <= n; i++) {
                if(park[now[0] + i].charAt(now[1]) == 'X') return true;
            }
        }
        else if(op == 'W') {
            for(int i = 1; i <= n; i++) {
                if(park[now[0]].charAt(now[1] - i) == 'X') return true;
            }
        }
        else{
            for(int i = 1; i <= n; i++) {
                if(park[now[0]].charAt(now[1] + i) == 'X') return true;
            }
        }
        
        return false;
    }
    
    int[] move(int[] now, char op, int n) {
        
        int[] next = new int[2];
        
        switch(op) {
            case 'N':
                next[0] = now[0] - n;
                next[1] = now[1];
                break;
            case 'S':
                next[0] = now[0] + n;
                next[1] = now[1];
                break;
            case 'W':
                next[0] = now[0];
                next[1] = now[1] - n;
                break;
            case 'E':
                next[0] = now[0];
                next[1] = now[1] + n;
        }
        
        return next;
    }
}