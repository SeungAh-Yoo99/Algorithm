class UserSolution {

        static class SegmentTree {

            int size;
            int[] tree; // node 범위를 전체에 올라온 블럭
            int[] minTree; // node 범위의 블럭 높이 중 가장 낮은 높이
            int[] maxTree; // node 범위의 블럭 높이 중 가장 높은 높이

            SegmentTree(int n) {

                // 트리 높이
                int height = (int)Math.ceil(Math.log(n) / Math.log(2));

                // 노드 개수
                size = (int)Math.pow(2, height + 1);

                // 트리 생성
                tree = new int[size];
                minTree = new int[size];
                maxTree = new int[size];
            }

            void update(int node, int s, int e, int l, int r, int h) {

                if(l <= s && e <= r) {
                    tree[node] += h;
                    minTree[node] += h;
                    maxTree[node] += h;
                    return;
                }

                int mid = (s + e) / 2;

                if(s <= r && l <= mid) update(node * 2, s, mid, l, r, h);
                if(mid + 1 <= r && l <= e) update(node * 2 + 1, mid + 1, e, l, r, h);

                minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]) + tree[node];
                maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]) + tree[node];
            }
        }

        SegmentTree segTree;
        int c;
        long count;

        void init(int C) {

            this.c = C;
            segTree = new SegmentTree(C);
            this.count = 0;
        }

        Solution.Result dropBlocks(int mCol, int mHeight, int mLength) {

            count += mHeight * mLength;
            segTree.update(1, 0, c - 1, mCol, mCol + mLength - 1, mHeight);

            Solution.Result ret = new Solution.Result();
            ret.top = segTree.maxTree[1] - segTree.minTree[1];
            ret.count = (int)((count - ((long)c * segTree.minTree[1])) % 1_000_000);

            return ret;
        }

    }
