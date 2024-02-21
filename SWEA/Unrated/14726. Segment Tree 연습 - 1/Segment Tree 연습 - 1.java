import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static class SegmentTree {

        long[] minTree; // 최소값을 담고 있는 세그먼트 트리
        long[] maxTree; // 최대값을 담고 있는 세그먼트 트리

        int treeSize;

        SegmentTree(int n) {

            // 트리 높이 구하기
            int h = (int)Math.ceil(Math.log(n)/Math.log(2));

            // 트리 사이즈 구하기
            treeSize = (int)Math.pow(2, h + 1);

            // 배열 생성
            minTree = new long[treeSize];
            maxTree = new long[treeSize];
        }

        void init(int[] arr, int node, int s, int e) { // 초기 세그먼트 생성 메소드

            if(s == e) {
                minTree[node] = arr[s];
                maxTree[node] = arr[s];
                return;
            }

            init(arr, node * 2, s, (s + e) / 2);
            init(arr, node * 2 + 1, (s + e) / 2 + 1, e);

            minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
            maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
        }

        void update(int[] arr, int node, int s, int e, int idx) {

            if(s == e) {
                minTree[node] = arr[s];
                maxTree[node] = arr[s];
                return;
            }

            if(s <= idx && idx <= (s + e) / 2)
                update(arr, node * 2, s, (s + e) / 2, idx);
            if((s + e) / 2 + 1 <= idx && idx <= e)
                update(arr, node * 2 + 1, (s + e) / 2 + 1, e, idx);

            minTree[node] = Math.min(minTree[node * 2], minTree[node* 2 + 1]);
            maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
        }

        long getMin(int node, int s, int e, int l, int r) {

            if(l <= s && e <= r) {
                return minTree[node];
            }

            long ret = Long.MAX_VALUE;

            if(s <= r && (s + e) / 2 >= l) ret = Math.min(ret, getMin(node * 2, s, (s + e) / 2, l, r));
            if((s + e) / 2 + 1 <= r && e >= l) ret = Math.min(ret, getMin(node * 2 + 1, (s + e) / 2 + 1, e, l, r));

            return ret;
        }

        long getMax(int node, int s, int e, int l, int r) {

            if(l <= s && e <= r) {
                return maxTree[node];
            }

            long ret = 0;

            if(s <= r && (s + e) / 2 >= l) ret = Math.max(ret, getMax(node * 2, s, (s + e) / 2, l, r));
            if((s + e) / 2 + 1 <= r && e >= l) ret = Math.max(ret, getMax(node * 2 + 1, (s + e) / 2 + 1, e, l, r));
            return ret;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer;

        int T = Integer.parseInt(br.readLine());

        int n, q, c, i, x, l, r;
        int[] arr;
        long max, min;
        SegmentTree segTree;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            // 세그먼트 트리 생성
            segTree = new SegmentTree(n);

            // 초기 세그먼트 트리 세팅
            segTree.init(arr, 1, 0, n - 1);

            // 쿼리 시작
            answer = new StringBuilder();
            for (int j = 0; j < q; j++) {
                st = new StringTokenizer(br.readLine());
                c = Integer.parseInt(st.nextToken());
                if(c == 0) {
                    i = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());

                    arr[i] = x;
                    segTree.update(arr, 1, 0, n - 1, i);
                }
                else {
                    l = Integer.parseInt(st.nextToken());
                    r = Integer.parseInt(st.nextToken());

                    max = segTree.getMax(1, 0, n - 1, l, r - 1);
                    min = segTree.getMin(1, 0, n - 1, l, r - 1);
                    answer.append(" " + (max - min));
                }
            }

            System.out.println("#" + tc + answer);
        }
    }
}
