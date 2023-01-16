import java.util.Scanner;

public class Jongol_559 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		double[] score = {85.6, 79.5, 83.1, 80.0, 78.2, 75.0};
		
		int first = scan.nextInt();
		int second = scan.nextInt();
		
		System.out.printf(String.format("%.1f", score[first - 1] + score[second - 1]));
	}

}