import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static class SegmentTree {

        long[] tree;
        long[] lazy;

        SegmentTree(int size) {
            this.tree = new long[size * 4];
            this.lazy = new long[size * 4];
        }

        void propagate(int l, int r, int index) {

            // 현재 노드에 lazy 값이 있는 경우 없데이트
            tree[index] += lazy[index] * (r - l + 1);

            // 현재 lazy 값을 자식에게 상속 (리프 노드일 경우 상속하지 않음)
            if(l != r) {
                lazy[index * 2] += lazy[index];
                lazy[index * 2 + 1] += lazy[index];
            }

            lazy[index] = 0;
        }

        // s := 변경하고자 하는 범위의 시작 인덱스
        // e := 변경하고자 하는 범위의 끝 인덱스
        // l := 현재 인덱스가 담고 있는 구간합의 시작 범위
        // r := 현재 인덱스가 담고 있는 구간합의 끝 범위
        // index := tree 배열에서 접근해야 하는 인덱스
        // num := 바꾸려고 하는 값의 크기
        long update(int s, int e, int l, int r, int index, long num) {

            // lazy값 업데이트
            if(lazy[index] != 0) propagate(l, r, index);

            // lazy propagation을 적용하여
            // l~가 s~e에 포함되는 구간만 업데이트 해준다.

            // l~r가 s~e에 포함되는 구간인 경우
            if(s <= l && r <= e) {
                this.tree[index] += num * (r - l + 1);
                // 자식 노드의 lazy값 업데이트
                if(l != r) {
                    this.lazy[index * 2] += num;
                    this.lazy[index * 2 + 1] += num;
                }
                return num * (r - l + 1);
            }

            // 중간 지점
            int mid = (l + r) / 2;

            long ret = 0;

            // 왼쪽 자식 트리도 갱신해야 하는지 확인
            if(s <= mid && e >= l)
                ret += update(s, e, l, mid, index * 2, num);
            // 오른쪽 자식 트리도 갱신해야 하는지 확인
            if(s <= r && e > mid)
                ret += update(s, e, mid + 1, r, index* 2 + 1, num);

            this.tree[index] += ret;
            return ret;
        }

        // s := 얻고자하는 구간합 범위의 시작 인덱스
        // e := 얻고자 하는 구간합 범위의 끝 인덱스
        // l := 현재 인덱스가 담고 있는 구간합의 시작 범위
        // r := 현재 인덱스가 담고 있는 구간합의 끝 범위
        // index := tree 배열에서 접근해야 하는 인덱스
        long getSum(int s, int e, int l, int r, int index) {

            // lazy값 업데이트
            if(lazy[index] != 0) propagate(l, r, index);

            // l~r가 s~e 안에 포함된다면 바로 리턴
            if(s <= l && r <= e) return this.tree[index];

            long ret = 0;

            // 중간 지점
            int mid = (l + r) / 2;

            // 왼쪽 자식 트리도 포함되는지 확인
            if(s <= mid && e >= l)
                ret += getSum(s, e, l, mid, index * 2);
            // 오른쪽 자식 트리도 포함되는지 확인
            if(s <= r && e > mid)
                ret += getSum(s, e, mid + 1, r, index * 2 + 1);

            return ret;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        SegmentTree seg = new SegmentTree(N);

        // 세그먼트 트리 초기 세팅
        for (int i = 1; i <= N; i++) {
            seg.update(i, i, 1, N, 1, Long.parseLong(br.readLine()));
        }

        StringBuilder answer = new StringBuilder();
        int a, b, c; long d;
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            // 세그먼트 트리 값 변경
            if(a == 1) {
                d = Long.parseLong(st.nextToken());
                seg.update(b, c, 1, N, 1, d);
            }
            // 누적 합 구하기
            else if(a == 2) {
                answer.append(seg.getSum(b, c, 1, N, 1)).append("\n");
            }
        }

        // 출력
        System.out.print(answer);
    }
}