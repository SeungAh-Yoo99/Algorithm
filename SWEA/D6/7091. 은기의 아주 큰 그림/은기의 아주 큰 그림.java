import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception{

        // 가로 해시를 위한 모듈러
        final BigInteger MOD1 = new BigInteger("2");
        // 세로 해시를 위한 모듈러
        final BigInteger MOD2 = new BigInteger("3");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int H, W, N, M, result;
        char[][] dream, full;
        BigInteger dreamHash, row, tmp, subMul1, subMul2;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 은기가 꿈에서 본 그림
            dream = new char[H][W];
            for (int i = 0; i < H; i++) {
                dream[i] = br.readLine().toCharArray();
            }

            // 선생님이 그린 그림
            full = new char[N][M];
            for (int i = 0; i < N; i++) {
                full[i] = br.readLine().toCharArray();
            }

            /**
             * 라빈-카프 알고리즘으로 선생님이 그린 그림을 해시 값으로 바꾸기
             */

            // 은기의 꿈그림의 해시값 구하기
            dreamHash = new BigInteger("0");
            for (int i = 0; i < H; i++) {
                row = new BigInteger("0");
                for (int j = 0; j < W; j++) {
                    row = row.multiply(MOD1);
                    if(dream[i][j] == 'o') row = row.add(new BigInteger("1"));
                }
                dreamHash = dreamHash.multiply(MOD2).add(row);
            }

            BigInteger[] hash = new BigInteger[N];
            for (int i = 0; i < N; i++) {
                hash[i] = new BigInteger("0");
                for (int j = 0; j < W; j++) {
                    hash[i] = hash[i].multiply(MOD1);
                    if(full[i][j] == 'o') hash[i] = hash[i].add(new BigInteger("1"));
                }
            }

            subMul1 = MOD1.pow(W - 1);
            subMul2 = MOD2.pow(H - 1);

            result = 0;
            for (int i = 0; i < M - W + 1; i++) {
                tmp = new BigInteger("0");
                for (int j = 0; j < H; j++) {
                    tmp = tmp.multiply(MOD2).add(hash[j]);
                }
                if(dreamHash.compareTo(tmp) == 0) result++;
                for (int j = 0; j < N - H; j++) {
                    tmp = tmp.subtract(hash[j].multiply(subMul2)).multiply(MOD2).add(hash[j + H]);
                    if(dreamHash.compareTo(tmp) == 0) result++;
                }

                if(i != M - W) {
                    for (int j = 0; j < N; j++) {
                        if(full[j][i] == 'o') hash[j] = hash[j].subtract(subMul1);
                        hash[j] = hash[j].multiply(MOD1);
                        if(full[j][i + W] == 'o') hash[j] = hash[j].add(new BigInteger("1"));
                    }
                }
            }

            System.out.println("#" + tc + " " + result);
        }
    }
}