/*
ó������ �Ҽ��� ���ؾ� �Ѵٰ� �����ߴ�.
�׷��� ���� �Ҽ��� �������� �ʾƵ� �ȴ�.
2�� ���� �� ���� ������ �����ְ�, �״��� 3�� �����ָ� 4�� ���� ���ʰ� �Ǿ��� �� ������ 2�� ���� �� ���� ������ �����־��� ������ �� �̻� ���� �� ���� 5�� �Ѿ�� �ȴ�.
�̷��� 2���� ������� �����ָ� ���� �Ҽ��� ���� �ʿ� ���� ���μ����ظ� �� �� �ִ�. 
*/

import java.util.Scanner;

public class BOJ_11653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int i = 2;
		
		while(i <= n) {
			if (n%i == 0) {
				System.out.println(i);
				n = n/i;
			}
			else
				i++;
		}
	}

}
