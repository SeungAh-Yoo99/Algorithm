import java.util.Scanner;

public class Jongol_562 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = scan.nextInt();
		}
		
		int sum = 0, avg = 0;
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 1)
				sum += arr[i];
			else
				avg += arr[i];
		}
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + String.format("%.1f", avg / 5.0));
	}

}