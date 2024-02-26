import java.util.ArrayList;
import java.util.HashMap;

class UserSolution {

        static class Department {

            int id;
            int highLevel; // 상위 부서의 id
            int personnel; // 인원수
            ArrayList<Department> sub; // 하위 부서 리스트
            int subSize; // 하위 부서 개수

            Department(int subSize) {
                id = 0;
                personnel = 0;
                sub = new ArrayList<>();
                this.subSize = subSize;
            }

            Department(int id, int highLevel, int personnel) {
                this.id = id;
                this.highLevel = highLevel;
                this.personnel = personnel;
                this.sub = new ArrayList<>();
                this.subSize = 0;
            }
        }

        Department root; // 모든 그룹의 정보를 가지고 있는 최상위 부서
        HashMap<Integer, Department> hm; // id로 부서 정보를 가져오기 위한 hm

        public void init(int N, int mId[], int mNum[]) {

            hm = new HashMap<>();

            root = new Department(N);
            hm.put(0, root);

            Department d;
            for (int i = 0; i < N; i++) {
                d = new Department(mId[i], 0, mNum[i]);
                hm.put(mId[i], d);

                root.sub.add(d);
                root.personnel += mNum[i];
            }

            return;
        }

        public int add(int mId, int mNum, int mParent) {

            // 상위 부서
            Department p = hm.get(mParent);

            // 상위 부서에 이미 3개의 하위 부서가 존재하면 추가 실패
            if(p.subSize == 3) {
                return -1;
            }

            // 새로 추가될 부서
            Department d = new Department(mId, mParent, mNum);
            hm.put(mId, d);

            // 상위 부서 p의 하위 부서 리스트 sub에 새로 추가될 부서 d 추가
            p.sub.add(d);
            p.subSize++;

            // 상위 부서부터 root까지 위로 올라가며 인원수 추가해줌
            while(true) {
                p.personnel += mNum;

                // 현재 루트 부서라면 더 이상 올라가지 않음
                if(p == root) break;

                // 상위 부서로 이동
                p = hm.get(p.highLevel);
            }

            // mParent의 인원 수 리턴
            int ret = hm.get(mParent).personnel;
            return ret;
        }

        public int remove(int mId) {

            Department d = hm.get(mId);

            // mId 부서가 존재하지 않을 경우
            if(d == null) {
                return -1;
            }

            // 존재할 경우 mId 부서의 총 인원을 리턴
            int ret = d.personnel;

            // 상위 부서
            Department p = hm.get(d.highLevel);

            // 바로 상위 부서의 하위 부서 개수 줄여줌
            p.subSize--;

            // mId의 모든 상위 부서 인원 수 줄여줌
            while(true) {
                p.personnel -= d.personnel;

                if(p == root) break;

                p = hm.get(p.highLevel);
            }

            // mId를 포함한 모든 하위 부서를 hm에서 지워줌
            removeSub(mId);

            return ret;
        }

        private void removeSub(int mId) { // hm에서 mId를 포함한 모든 하위 부서들을 지우는 메소드

            Department d = hm.get(mId);

            if(d == null) return;

            Department s;
            for (int i = 0; i < d.sub.size(); i++) {
                s = d.sub.get(i);
                removeSub(s.id);
            }

            hm.remove(mId);
        }

        public int distribute(int K) {

            int ret = 0;

            // 총 인원이 K보다 적을 경우
            if(root.personnel <= K) {

                for (int i = 0; i < root.subSize; i++) {
                    ret = Math.max(ret, root.sub.get(i).personnel);
                }
            }
            // K보다 총 인원이 많을 경우
            else {
                // 이분 탐색으로 가장 큰 값 구하기
                int s = 0, e = K, m, count;
                Department group;
                while(s <= e) {
                    m = (s + e) / 2;

                    count = 0;
                    for (int i = 0; i < root.subSize; i++) {
                        group = root.sub.get(i);

                        if(group.personnel < m) count += group.personnel;
                        else count += m;

                        if(count > K) break;
                    }

                    // 딱 맞게 나누어주었다면
                    if(count == K) {
                        ret = m;
                        break;
                    }
                    // 더 나눠줄 수 있다면
                    else if(count < K) {
                        ret = m;
                        s = m + 1;
                    }
                    // 다 나눠줄 수 없다면
                    else {
                        e = m - 1;
                    }
                }
            }

            return ret;
        }
    }
