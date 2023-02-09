import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	    int N = sc.nextInt();
	    int M = sc.nextInt();
	    int total = 0;
	    
	    char[] arr =  sc.next().toCharArray();
	    for (int i = 0; i < N; i++) {
	        boolean chk = true;
	        if(arr[i] == 'P') {
	            for (int j = M; 0 < j; j--) {
	                if(0 <= i - j  && arr[i - j] == 'H') {
	                    total++;
	                    arr[i - j] = '0';
	                    chk = false;
	                    break;
	                }
	            }
	            if(chk) {
	                for (int j = 1; j < M + 1 ; j++) {
	                    if(i + j < N && arr[i + j] == 'H') {
	                        total++;
	                        arr[i + j] =  '0';
	                        break;
	                    }
	                }
	            }
	        }
	    }
	    System.out.println(total);
	}
}