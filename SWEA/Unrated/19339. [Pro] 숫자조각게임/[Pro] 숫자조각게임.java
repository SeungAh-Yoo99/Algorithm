import java.util.HashMap;
import java.util.PriorityQueue;

class UserSolution {

        static class Block implements Comparable<Block>{
            int x;
            int y;

            Block(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int compareTo(Block o) { // 행의 번호가 작을수록, 행의 번호가 같다면 열의 번호가 작을수록 우선순위가 높음.
                return this.x == o.x ? this.y - o.y : this.x - o.x;
            }
        }

        HashMap<Integer, PriorityQueue<Block>>[] blockHash; // 타입별로 기준 조각과의 차이를 해시로 저장
        int[][] board; // 게임판 정보
        int[][] mCells; // 초기 게임판 정보
        int H, W; // 게임판의 높이, 너비

        final int MOD = 11; // 해시값에 사용할 값

        final int[][][] type = { // 블럭 타입 정보
                {{0}, {1}},
                {{0, 0}, {1, 2}},
                {{1, 2}, {0, 0}},
                {{0, 1, 1}, {1, 1, 2}},
                {{1, 1, 1, 2}, {0, 1, 2, 2}}
        };

        public void init(int mRows, int mCols, int mCells[][])
        {
            this.H = mRows;
            this.W = mCols;

            this.mCells = mCells;

            clearPuzzles();
        }

        private void addHash(int idx, int hash, int x, int y) { // 해시값 저장 배열

            PriorityQueue<Block> pq = blockHash[idx].get(hash);
            if(pq == null) pq = new PriorityQueue<>();
            pq.add(new Block(x, y));
            blockHash[idx].put(hash, pq);
        }

        public Solution.Result putPuzzle(int mPuzzle[][])
        {
            Solution.Result ret = new Solution.Result(-1, -1);

            // mPuzzle의 타입 구하기
            int typeOFBlock = getBlockType(mPuzzle);

            // mPuzzle의 해시값 구하기
            int hash = 0;
            for (int i = 0; i < type[typeOFBlock][0].length; i++) {
                hash = hash * MOD + (mPuzzle[0][0] - mPuzzle[type[typeOFBlock][0][i]][type[typeOFBlock][1][i]] + 4);
            }

            // 해시값에 해당하는 위치 후보 가져오기
            PriorityQueue<Block> pq = blockHash[typeOFBlock].get(hash);

            // 후보가 없다면 그대로 리턴
            if(pq == null || pq.size() == 0) {
                return ret;
            }

            // 후보가 있다면 하나씩 꺼내서 해당 위치에 놓을 수 있는지 확인
            Block b;
            while(!pq.isEmpty()) {
                b = pq.poll();

                boolean flag = true;

                // 기준점에 이미 블록이 놓아진 상태라면 다음 후보 확인하러
                if(board[b.x][b.y] == 0) continue;

                for (int i = 0; i < type[typeOFBlock][0].length; i++) {
                    // 이미 블럭이 놓아져 있는 상태라면 다음 후보 확인하러
                    if(board[b.x + type[typeOFBlock][0][i]][b.y + type[typeOFBlock][1][i]] == 0) {
                        flag = false;
                        break;
                    }
                }

                // 해당 위치에 블럭을 놓을 수 있다면
                if(flag) {
                    ret.row = b.x;
                    ret.col = b.y;

                    // 해당 위치에 블럭을 놓았다는 뜻으로 0으로 바꿔줌
                    board[b.x][b.y] = 0;
                    for (int i = 0; i < type[typeOFBlock][0].length; i++) {
                        board[b.x + type[typeOFBlock][0][i]][b.y + type[typeOFBlock][1][i]] = 0;
                    }

                    // 리턴
                    return ret;
                }
            }

            return ret;
        }

        int getBlockType(int[][] block) { // 블럭의 타입 구하기

            boolean flag;
            for (int i = 4; i >= 0; i--) {
                flag = true;
                for (int j = 0; j < type[i][0].length; j++) {
                    if(block[type[i][0][j]][type[i][1][j]] == 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) return i;
            }

            return -1;
        }

        public void clearPuzzles()
        {
            // 현재 보드판을 초기 게임판 상태로 만든다.
            board = new int[H][];
            for (int i = 0; i < H; i++) {
                board[i] = mCells[i].clone();
            }

            // 5가지 타입의 블럭 해쉬 값을 담아둘 배열 생성
            blockHash = new HashMap[5];
            for (int i = 0; i < 5; i++) {
                blockHash[i] = new HashMap<>();
            }

            // 블럭들의 해시값 구하기
            int hash;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < H; j++) {
                    // 블럭 범위 체크
                    if(j + type[i][0][type[i][0].length - 1] >= H) break;
                    for (int k = 0; k < W; k++) {
                        // 블럭 범위 체크
                        if(k + type[i][1][type[i][1].length - 1] >= W) break;

                        // (j, k)를 기준으로 하는 i 타입 블럭의 해시값 구하기
                        hash = 0;
                        for (int l = 0; l < type[i][0].length; l++) {
                            hash = hash * MOD + (board[j][k] - board[j + type[i][0][l]][k + type[i][1][l]] + 4);
                        }

                        // 해시값 저장
                        addHash(i, hash, j, k);
                    }
                }
            }
        }
    }
