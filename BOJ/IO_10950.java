import java.util.Scanner;

public class IO_10950 {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int totalNum = scan.nextInt();
      int num1 []=new int[totalNum];
      int num2 []=new int[totalNum];
 
      for (int i=0;i<totalNum;i++) {
    	  num1[i]=scan.nextInt();
    	  num2[i]=scan.nextInt();
      }
      
      for (int i=0;i<totalNum;i++)
    	 System.out.println(num1[i]+num2[i]);
   }
}