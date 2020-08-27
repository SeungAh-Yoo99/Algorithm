import java.util.*;

public class IO_10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String s=scan.next();
		int arr[]=new int[26];
		for (int i=0;i<26;i++) // 처음에 -1로 다 초기화
			arr[i]=-1;
		
		for (int i=0;i<s.length();i++) {
			int apb=(int)s.charAt(i)-97;
			if (arr[apb]==-1)
				arr[apb]=i;
		}
		
		for (int i=0;i<26;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

}