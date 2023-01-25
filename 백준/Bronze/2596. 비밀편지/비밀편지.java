import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		char[][] abc = {{'0', '0', '0', '0', '0', '0', 'A'},
				{'0', '0', '1', '1', '1', '1', 'B'},
				{'0', '1', '0', '0', '1', '1', 'C'},
				{'0', '1', '1', '1', '0', '0', 'D'},
				{'1', '0', '0', '1', '1', '0', 'E'},
				{'1', '0', '1', '0', '0', '1', 'F'},
				{'1', '1', '0', '1', '0', '1', 'G'},
				{'1', '1', '1', '0', '1', '0', 'H'}};
		
		int n = scan.nextInt();
		char[][] arr = new char[n][6];
		String s = scan.next();
		
		int i = 0;
		while(i < s.length()) {
			for(int j = 0; j < 6; j++) {
				arr[(int)i / 6][j] = s.charAt(i);
				i++;
			}
		}
		
		char[] ans = new char[n];
		for(i = 0; i < n; i++)
			ans[i] = ' ';
			
		boolean err = false;
		int indexOfErr = 0;
		for(i = 0; i < n; i++) { // arr
			
			for(int j = 0; j < 8; j++) { // abc
				
				int cnt = 0;
				for(int k = 0; k < 6; k++) { // bit
					if(arr[i][k] != abc[j][k])
						cnt++;
					if(k == 5 && cnt <= 1) {
						ans[i] = abc[j][6];
					}
				}
				
				// 이미 값을 찾았다면 다음 문자 확인
				if(ans[i] != ' ')
					break;
				
				// 해당하는 문자를 찾지 못한 경우 index 저장
				if(j == 7 && ans[i] == ' ') {
						err = true;
						indexOfErr = i;
				}
			}
			
			// 해당하는 문자를 찾지 못했을 때 반복문 탈출
			if(err)
				break;
		}
		
		// 값을 모두 찾았다면 출력
		if(!err) {
			for(i = 0; i < n; i++) {
				System.out.print(ans[i]);
			}
		}
		// 찾지 못한 값이 있을 경우 인덱스 출력
		else
			System.out.println(indexOfErr + 1);
	}
	
}