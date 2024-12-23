class Solution {
    public int[] solution(String[] wallpaper) {
        
        // 바탕화면 정보
        int N = wallpaper.length;
        int M = wallpaper[0].length();
        
        int[] answer = new int[] {-1, -1, -1, -1};
        
        // 가장 위에 있는 파일 찾기
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    answer[0] = i;
                    break;
                }
            }
            if(answer[0] != -1) break;
        }
        
        // 가장 왼쪽에 있는 파일 찾기
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(wallpaper[j].charAt(i) == '#') {
                    answer[1] = i;
                    break;
                }
            }
            if(answer[1] != -1) break;
        }
        
        // 가장 밑에 있는 파일 찾기
        for(int i = N - 1; i >= 0; i--) {
            for(int j = 0; j < M; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    answer[2] = i + 1;
                    break;
                }
            }
            if(answer[2] != -1) break;
        }
        
        // 가장 오른쪽에 있는 파일 찾기
        for(int i = M - 1; i >= 0; i--) {
            for(int j = 0; j < N; j++) {
                if(wallpaper[j].charAt(i) == '#') {
                    answer[3] = i + 1;
                    break;
                }
            }
            if(answer[3] != -1) break;
        }
        
        return answer;
    }
}