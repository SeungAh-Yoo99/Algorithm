import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] info;

    static long maxHP;
    static long curHP;
    static long atk;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        info = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken());
        }


        // 이분 탐색
        long result = Long.MAX_VALUE;
        long sHP = 0; long eHP = Long.MAX_VALUE, mHP;
        while(sHP <= eHP) {
            mHP = (sHP + eHP) / 2;

            atk = H;
            maxHP = mHP;
            curHP = mHP;

            if(play()) {
                result = mHP;
                eHP = mHP - 1;
            } else {
                sHP = mHP + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean play() {

        for (int i = 0; i < N; i++) {
            if(info[i][0] == 1) { // 전투
                if(!fight(info[i][1], info[i][2])) return false;
            }
            else { // 포션
                potion(info[i][1], info[i][2]);
            }
        }

        return true;
    }

    private static boolean fight(long a, long h) {

        // 몬스터가 죽는 턴
        long monster = h / atk + (h % atk == 0 ? 0 : 1);

        // 용사가 죽는 턴
        long player = curHP / a + (curHP % a == 0 ? 0 : 1);

        if(monster <= player) {
            curHP -= a * (monster - 1);
            return true;
        }
        else return false;
    }

    private static void potion(int a, int h) {

        atk += a; // 공격력 증가
        curHP = (curHP + h >= maxHP) ? maxHP : curHP + h; // 생명력 증가
    }
}