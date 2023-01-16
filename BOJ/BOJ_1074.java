import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
	static int count = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		z((int) Math.pow(2, n), r, c);
		System.out.println(count);
	}
	
	static void z(int size, int x, int y) {
		if (size == 1)
			return;
		// 정사각형을 크게 4등분 했을 때, 왼쪽 위(1사분면), 오른쪽 위(2사분면), 왼쪽 아래(3사분면), 오른쪽 아래(4사분면) 이라고 하자.
		// 1사분면에 위치
		if ((x >= 0) && (x < size / 2) && (y >= 0) && (y < size / 2)) {
			z(size / 2, x, y);
		}
		// 2사분면에 위치
		else if ((x >= 0) && (x < size / 2) && (y >= size / 2) && (y < size)) {
			count += size * size / 4;
			z(size / 2, x, y - size / 2);
		}
		// 3사분면에 위치
		else if ((x >= size / 2) && (x < size) && (y >= 0) && (y < size / 2)) {
			count += size * size / 4 * 2;
			z(size / 2, x - size / 2, y);
		}
		// 4사분면에 위치
		else {
			count += size * size / 4 * 3;
			z(size / 2, x - size / 2, y - size / 2);
		}
	}

}