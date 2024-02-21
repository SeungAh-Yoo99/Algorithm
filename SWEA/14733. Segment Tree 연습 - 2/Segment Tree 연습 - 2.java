import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static class SegmentTree {

        long[] tree;
        int treeSize;

        SegmentTree(int arrLength) {

            if(arrLength == 0) {
                treeSize = 0;
                return;
            }

            // 세그먼트 트리 높이 구하기
            int height = (int) Math.ceil(Math.log(arrLength) / Math.log(2));

            // 세그먼트 트리 노드 개수 구하기
            treeSize = (int) Math.pow(2, height + 1);

            // 세그먼트 트리 생성
            tree = new long[treeSize];
        }

        void init(int[] arr, int node, int s, int e) { // 세그먼트 트리 초기화

            if(treeSize == 0) return;

            if (s == e) {
                tree[node] = arr[s];
                return;
            }

            init(arr, node * 2, s, (s + e) / 2);
            init(arr, node * 2 + 1, (s + e) / 2 + 1, e);

            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }

        void update(int node, int s, int e, int idx, int diff) { // idx 위치의 수가 diff만큼 변화

            if(treeSize == 0) return;

            if (s == e) {
                tree[node] += diff;
                return;
            }

            if (s <= idx && idx <= (s + e) / 2)
                update(node * 2, s, (s + e) / 2, idx, diff);

            if ((s + e) / 2 + 1 <= idx && idx <= e)
                update(node * 2 + 1, (s + e) / 2 + 1, e, idx, diff);

            tree[node] += diff;
        }

        long sum(int node, int s, int e, int l, int r) { // l ~ r까지의 구간 합을 리턴하는 메소드

            if(treeSize == 0) return 0;

            if (l <= s && e <= r) return tree[node];

            long ret = 0;

            if (s <= r && l <= (s + e) / 2)
                ret += sum(node * 2, s, (s + e) / 2, l, r);
            if ((s + e) / 2 + 1 <= r && l <= e)
                ret += sum(node * 2 + 1, (s + e) / 2 + 1, e, l, r);

            return ret;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer;

        int T = Integer.parseInt(br.readLine());

        int n, q, c, i, x, l, r;
        int es, ee, os, oe;
        long ret;
        int[] evenArr, oddArr;
        SegmentTree evenSegTree, oddSegTree;
        for (int tc = 1; tc <= T; tc++) {
            answer = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            evenArr = new int[n / 2 + (n % 2)]; // 짝수 인덱스 담는 배열
            oddArr = new int[n / 2]; //  홀수 인덱스 담는 배열

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n / 2 + (n % 2); j++) {
                evenArr[j] = Integer.parseInt(st.nextToken());
                if(j != n / 2) oddArr[j] = Integer.parseInt(st.nextToken());
            }

            evenSegTree = new SegmentTree(n / 2 + (n % 2));
            oddSegTree = new SegmentTree(n / 2);

            evenSegTree.init(evenArr, 1, 0, evenArr.length - 1);
            oddSegTree.init(oddArr, 1, 0, oddArr.length - 1);

            for (int j = 0; j < q; j++) {
                st = new StringTokenizer(br.readLine());
                c = Integer.parseInt(st.nextToken());
                if(c == 0) {
                    i = Integer.parseInt(st.nextToken());
                    x = Integer.parseInt(st.nextToken());

                    if(i % 2 == 0) {
                        evenSegTree.update(1, 0, evenArr.length - 1, i / 2, x - evenArr[i / 2]);
                        evenArr[i / 2] = x;
                    }
                    else {
                        oddSegTree.update(1, 0, oddArr.length - 1, i / 2, x - oddArr[i / 2]);
                        oddArr[i / 2] = x;
                    }
                }
                else {
                    l = Integer.parseInt(st.nextToken());
                    r = Integer.parseInt(st.nextToken());

                    if(l % 2 == 0) {
                        es = os = l / 2;
                    } else {
                        es = l / 2 + 1;
                        os = l / 2;
                    }

                    if((r - 1) % 2 == 0) {
                        ee = (r - 1) / 2;
                        oe = (r - 1) / 2 - 1;
                    } else {
                        ee = oe = (r - 1) / 2;
                    }

                    if(l % 2 == 0)
                        ret = evenSegTree.sum(1, 0, evenArr.length - 1, es, ee)
                                - oddSegTree.sum(1, 0, oddArr.length - 1, os, oe);
                    else
                        ret = oddSegTree.sum(1, 0, oddArr.length - 1, os, oe)
                                - evenSegTree.sum(1, 0, evenArr.length - 1, es, ee);


                    answer.append(" " + ret);
                }
            }

            System.out.println("#" + tc + answer);
        }
    }
}
