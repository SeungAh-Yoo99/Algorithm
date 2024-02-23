import java.util.ArrayList;

class UserSolution
    {

        static class SegmentTree {

            int[] tree;
            int treeSize;

            SegmentTree(int n) {

                // 트리의 높이 구하기
                int height = (int)Math.ceil(Math.log(n)/Math.log(2));

                // 트리의 노드 개수 구하기
                treeSize = (int)Math.pow(2, height + 1);

                // 트리 생성
                tree = new int[treeSize];
            }

            void init(int[] arr, int node, int s, int e) {

                if(s == e) {
                    tree[node] = arr[s];
                    return;
                }

                init(arr, node * 2, s, (s + e) / 2);
                init(arr, node * 2 + 1, (s + e) / 2 + 1, e);

                tree[node] = tree[node * 2] + tree[node * 2 + 1];
            }

            void update(int node, int s, int e, int idx, int diff) {

                if(s == e) {
                    tree[node] += diff;
                    return;
                }

                if(s <= idx && idx <= (s + e) / 2)
                    update(node * 2, s, (s + e) / 2, idx, diff);
                if((s + e) / 2 + 1 <= idx && idx <= e)
                    update(node * 2 + 1, (s + e) / 2 + 1, e, idx, diff);

                tree[node] += diff;
            }

            int sum(int node, int s, int e, int l, int r) {

                if(l <= s && e <= r) {
                    return tree[node];
                }

                int ret = 0;

                if(s <= r && (s + e) / 2 >= l)
                    ret += sum(node * 2, s, (s + e) / 2, l, r);
                if((s + e) / 2 + 1 <= r && e >= l)
                    ret += sum(node * 2 + 1, (s + e) / 2 + 1, e, l, r);

                return ret;
            }

            void updateByTree(SegmentTree diff) {
                for (int i = 0; i < treeSize; i++) {
                    tree[i] += diff.tree[i];
                }
            }
        }

        int N;
        int[] time; // 각 구간의 현재 통과 예상 시간
        ArrayList<ArrayList<Integer>> type; // 각 도로의 종류에 해당하는 지점 ID 리스트
        SegmentTree segTree;

        void init(int N, int M, int mType[], int mTime[])
        {
            this.N = N;
            time = mTime;

            type = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                type.add(new ArrayList<>());
            }

            for (int i = 0; i < N - 1; i++) {
                type.get(mType[i]).add(i);
            }

            segTree = new SegmentTree(N - 1);
            segTree.init(time, 1, 0, N - 2);
        }

        void destroy()
        {

        }

        void update(int mID, int mNewTime)
        {
            segTree.update(1, 0, N - 2, mID, mNewTime - time[mID]);
            time[mID] = mNewTime;
        }

        int updateByType(int mTypeID, int mRatio256)
        {
            int ret = 0;

            int[] diff = new int[N - 1];
            ArrayList<Integer> mTypeList = type.get(mTypeID);
            int idx;
            for (int i = 0; i < mTypeList.size(); i++) {
                idx = mTypeList.get(i);

                diff[idx] = (time[idx] * mRatio256 / 256) - time[idx];
                time[idx] = time[idx] * mRatio256 / 256;
                ret += time[idx];
            }

            SegmentTree tmp = new SegmentTree(N - 1);
            tmp.init(diff, 1, 0, N - 2);

            segTree.updateByTree(tmp);

            return ret;
        }

        int calculate(int mA, int mB)
        {
            int ret = 0;

            if(mA < mB) ret = segTree.sum(1, 0, N - 2, mA, mB - 1);
            else if(mB < mA) ret = segTree.sum(1, 0, N - 2, mB, mA - 1);

            return ret;
        }
    }
