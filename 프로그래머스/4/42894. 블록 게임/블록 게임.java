import java.util.*;

class Solution {

    // 블록 모양 저장 배열
    private final int[][][] blocks = {
        {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, // type 0
        {{0, 0}, {0, 1}, {1, 0}, {2, 0}}, // type 1
        {{0, 0}, {1, 0}, {1, 1}, {1, 2}}, // type 2
        {{0, 0}, {1, 0}, {2, -1}, {2, 0}}, // type 3
        {{0, 0}, {0, 1}, {0, 2}, {1, 0}}, // type 4
        {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, // type 5
        {{0, 0}, {1, -2}, {1, -1}, {1, 0}}, // type 6
        {{0, 0}, {0, 1}, {1, 1}, {2, 1}}, // type 7
        {{0, 0}, {1, -1}, {1, 0}, {1, 1}}, // type 8
        {{0, 0}, {1, 0}, {1, 1}, {2, 0}}, // type 9
        {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, // type 10
        {{0, 0}, {1, -1}, {1, 0}, {2, 0}} // type 11
    };

    private int x, y;
    private int[][] board;

    public int solution(int[][] board) {

        this.x = board.length;
        this.y = board[0].length;
        this.board = board;

        // cantDropBlackBlock[i] : = true라면 i번째 열에 더 이상 검은 블럭을 떨어뜨릴 수 없다는 뜻
        boolean[] cantDropBlackBlock = new boolean[y];

        // 없앨 수 있는 블럭의 몇 번째 열들에 검은 블럭을 떨어뜨려야 하는지에 대한 정보 저장
        Map<Integer, int[]> needs = new HashMap<>();
        needs.put(2, new int[] {1, 2});
        needs.put(3, new int[] {-1});
        needs.put(5, new int[] {1});
        needs.put(6, new int[] {-1, -2});
        needs.put(8, new int[] {-1, 1});
        // 나머지 블럭들은 구조상 절대 없앨 수 없음

        // 블럭의 타입과 몇 번째 칸을 확인했는지에 대한 정보
        Map<Integer, int[]> blockInfo = new HashMap<>();

        int answer = 0;

        int[] info, need; int type, rootY; boolean flag;
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                // 블럭 발견
                if(board[i][j] > 0) {
                    
                    info = blockInfo.get(board[i][j]);
                    
                    // 새로 발견한 블럭인 경우
                    if(info == null) {
                        
                        // 블럭의 타입 구하기
                        type = typeCheck(i, j);
                        
                        // 없앨 수 없는 타입의 블럭을 발견한 경우
                        if(needs.get(type) == null) {
                            // 현재 블럭이 걸쳐 있는 모든 열에 더 이상 검은 블럭을 떨어뜨릴 수 없음
                            for(int k = 0; k < 4; k++) {
                                cantDropBlackBlock[j + blocks[type][k][1]] = true;
                            }
                        }
                        
                        blockInfo.put(board[i][j], new int[] {type, 1});
                    }
                    // 블럭의 마지막 칸을 발견한 경우
                    else if(info[1] == 3) {
                        
                        // 블럭의 첫째 칸의 가로 좌표
                        rootY = j - blocks[info[0]][3][1];
                        
                        // 블럭 타입에 따라 없앨 수 있는 블럭인지 아닌지 가져오기
                        need = needs.get(info[0]);
                        
                        // 없앨 수 있는 블럭인 경우
                        if(need != null) {
                            
                            // 블럭이 걸쳐있는 모든 열에 검은 블럭을 떨어트릴 수 있는지 확인
                            flag = true;
                            
                            for(int k = 0; k < need.length; k++) {
                                if(cantDropBlackBlock[rootY + need[k]]) {
                                    flag = false;
                                    break;
                                }
                            }
                            
                            // 검은 블럭을 떨어뜨릴 수 있다면
                            if(flag) {
                                answer++;
                            }
                            // 떨어뜨릴 수 없다면
                            else {
                                // 현재 블럭이 걸쳐 있는 모든 열에 더 이상 검은 블럭을 떨어뜨릴 수 없음
                                for(int k = 0; k < 4; k++) {
                                    cantDropBlackBlock[rootY + blocks[info[0]][k][1]] = true;
                                }
                            }
                        }
                    }
                    else info[1]++;
                }
           }
        }
        
        return answer;
    }

    private int typeCheck(int bx, int by) { // index 블럭의 타입 확인

        int ret = -1;

        boolean flag;
        for(int i = 0; i < 12; i++) { // 12개의 타입 중

            flag = true;

            int nx, ny;
            for(int j = 0; j < 4; j++) { // 블럭 모양 확인
                nx = bx + blocks[i][j][0];
                ny = by + blocks[i][j][1];

                if(nx >= 0 && nx < x && ny >= 0 && ny < y) { // 범위 체크
                    if(board[nx][ny] != board[bx][by]) {
                        flag = false;
                        break;
                    }
                }
                else {
                    flag = false;
                    break;
                }
            }

            if(flag) { // 모든 블럭 모양이 일치하면
                ret = i; // index 블럭은 i 타입
                break;
            }
        }

        return ret;
    }
}