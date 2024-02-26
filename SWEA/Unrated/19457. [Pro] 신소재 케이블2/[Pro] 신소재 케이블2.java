import java.util.*;

class UserSolution
    {

        // 간선 정보
        HashMap<Integer, ArrayList<int[]>> edges;

        // 테스트 시에 사용할 방문 확인 해시셋
        HashSet<Integer> visited;


        public void init(int mDevice)
        {

            // 간선 정보 해시맵 생성
            edges = new HashMap<>();

            // 초기 장비 정보 입력
            edges.put(mDevice, new ArrayList<>());

            return;
        }


        public void connect(int mOldDevice, int mNewDevice, int mLatency)
        {

            // 새로운 장비 정보
            edges.put(mNewDevice, new ArrayList<>());
            ArrayList<int[]> newDeviceEdge = edges.get(mNewDevice);

            // 기존의 장비 정보
            ArrayList<int[]> oldDeviceEdge = edges.get(mOldDevice);

            // 간선 정보 입력
            newDeviceEdge.add(new int[] {mOldDevice, mLatency});
            oldDeviceEdge.add(new int[] {mNewDevice, mLatency});

            return;
        }

        public int measure(int mDevice1, int mDevice2)
        {
            // mDevice1에서 mDevice2로 가는 시간 다익스트라로 구하기
            Queue<int[]> q = new LinkedList<>();
            HashSet<Integer> hs = new HashSet<>();

            q.add(new int[] {mDevice1, 0});
            hs.add(mDevice1);

            int[] now, next;
            ArrayList<int[]> edge;
            while(!q.isEmpty()) {
                now = q.poll();
                edge = edges.get(now[0]);
                for (int i = 0; i < edge.size(); i++) {
                    next = edge.get(i);

                    // 이미 방문한 장비라면 넘어감
                    if(hs.contains(next[0])) continue;

                    // mDevice2에 도착한 경우 전송 시간 리턴
                    if(next[0] == mDevice2) {
                        return now[1] + next[1];
                    }

                    q.add(new int[] {next[0], now[1] + next[1]});
                    hs.add(next[0]);
                }
            }

            return -1;
        }

        public int test(int mDevice)
        {
            visited = new HashSet<>();

            int[] ret = getLength(mDevice);

            return ret[1];
        }

        private int[] getLength(int node) {

            visited.add(node);

            // node에 연결된 장치 정보
            ArrayList<int[]> edge = edges.get(node);

            // edge 사이즈
            int size = edge.size();

            // node에서 갈 수 있는 장치들의 거리를 담을 배열
            int[] length = new int[size + 1];

            int next[];
            for (int i = 0; i < size; i++) {
                next = edge.get(i);

                // 트리 위로 다시 올라가지 않음
                if(visited.contains(next[0])) continue;

                length[i] = getLength(next[0])[0] + next[1];
            }

            Arrays.sort(length);

            int[] ret = new int[2];
            ret[0] = length[size];
            ret[1] = length[size] + length[size - 1];
            return ret;
        }
    }
