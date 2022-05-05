import java.util.Scanner;

public class IO_11022 {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int totalNum = scan.nextInt();
      int num1;
      int num2;
 
      for (int i=0;i<totalNum;i++) {
    	  num1=scan.nextInt();
    	  num2=scan.nextInt();
    	  
    	  System.out.println("Case #"+(i+1)+": "+num1+" + "+num2+" = "+(num1+num2));
      }
      
    	 
   }
}