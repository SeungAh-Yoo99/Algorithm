import java.util.*;

public class IO_1157 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String s=scan.next();
		int arr[]=new int[26];
		
		for (int i=0;i<s.length();i++) {
			int c=(int)s.charAt(i);
			if ((c>=65)&&(c<=90)) {// 대문자라면
				c-=65;
				arr[c]++;
			}
			else { // 소문자라면
				c-=97;
				arr[c]++;
			}
		}
		
		int max=-1; // 가장 많이 나온 횟수
		int max_index=-1; // 가장 많이 나온 알파벳의 index
		for (int i=0;i<26;i++) {
			if (max<arr[i]) {
				max=arr[i];
				max_index=i;
			}
			else if (max==arr[i])
				max_index=26; // max_index가 26이라면 가장 많이 사용된 알파벳이 여러 개 존재하는 경우.
		}
		
		if (max_index==26)
			System.out.println("?");
		else
			System.out.println((char)(max_index+65));
	}

}