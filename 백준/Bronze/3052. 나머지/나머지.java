import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int arr[]=new int[10];
		int count=0;
		for (int i=0;i<10;i++) {
			arr[i]=scan.nextInt()%42; //처음부터 42의 나머지를 저장
			int j;
			for (j=0;j<i;j++) // index가 0~i-1까지 arr[i]와 같은 수가 있는지 확인
				if (arr[i]==arr[j])
					break;
			if (i==j) // 같은 수가 없다면 카운트 한다.
				count++;
		}
		
		System.out.println(count);
	}

}