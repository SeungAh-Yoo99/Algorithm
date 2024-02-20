import java.util.*;

class UserSolution {

        // 도로 정보
        Map<Integer, ArrayList<int[]>> in;
        Map<Integer, ArrayList<int[]>> out;

        public int init(int N, int sCity[], int eCity[], int mCost[]) {

            int ret = 0;

            in = new HashMap<>();
            out = new HashMap<>();

            for (int i = 0; i < N; i++) {
                // 출발 도시가 처음 나온 도시라면
                if(in.get(sCity[i]) == null) {
                    ret++;
                    in.put(sCity[i], new ArrayList<>());
                    out.put(sCity[i], new ArrayList<>());
                }
                // 도착 도시가 처음 나온 도시라면
                // 출발 도시가 처음 나온 도시라면
                if(in.get(eCity[i]) == null) {
                    ret++;
                    in.put(eCity[i], new ArrayList<>());
                    out.put(eCity[i], new ArrayList<>());
                }

                // 도로 정보 추가
                in.get(eCity[i]).add(new int[] {sCity[i], mCost[i]});
                out.get(sCity[i]).add(new int[] {eCity[i], mCost[i]});
            }

            return ret;
        }

        public void add(int sCity, int eCity, int mCost) {

            in.get(eCity).add(new int[] {sCity, mCost});
            out.get(sCity).add(new int[] {eCity, mCost});

        }

        public int cost(int mHub) {

            int ret = 0;

            // mHub에서 다른 도시들로 가는 거리 계산
            ret += dijkstra(out, mHub);

            // 다른 도시에서 mHub로 가는 거리 계산
            ret += dijkstra(in, mHub);

            return ret;
        }

        private int dijkstra(Map<Integer, ArrayList<int[]>> edges, int mHub) {

            int ret = 0;

            // 이미 최단 거리 계산 끝난 도시들 저장
            HashSet<Integer> hs = new HashSet<>();

            // 다익스트라 사용
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            pq.add(new int[] {mHub, 0});

            int[] now, next;
            ArrayList<int[]> edge;
            while(!pq.isEmpty()) {
                now = pq.poll();

                if(!hs.contains(now[0])) { // 최단 거리를 찾았다면
                    ret += now[1];
                    hs.add(now[0]);
                } else continue; // 이미 최단 거리를 찾은 도시라면 넘어감

                // now에 연결된 도시 리스트
                edge = edges.get(now[0]);
                for (int i = 0; i < edge.size(); i++) {
                    next = edge.get(i);
                    pq.add(new int[] {next[0], now[1] + next[1]});
                }
            }

            return ret;
        }
    }
