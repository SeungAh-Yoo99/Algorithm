import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int monthToDay[]=new int[12]; //(해당 달-1)에 며칠까지 있는지 저장.
		monthToDay[0]=31; monthToDay[1]=28; monthToDay[2]=31;
		monthToDay[3]=30; monthToDay[4]=31; monthToDay[5]=30;
		monthToDay[6]=31; monthToDay[7]=31; monthToDay[8]=30;
		monthToDay[9]=31; monthToDay[10]=30; monthToDay[11]=31;
		int inputMonth=scan.nextInt();
		int inputDate=scan.nextInt();
		int day=0;
		
		for (int i=0;i<(inputMonth-1);i++) //1~inputMonth까지의 날짜 수 더하고
			day+=monthToDay[i];
		day+=inputDate; //inputDate 더한 후 
		day%=7; //7로 나눈 나머지가
		
		switch (day) {
		case 1: //1일때 MON
			System.out.println("MON");
			break;
		case 2: //2일때 TUE
			System.out.println("TUE");
			break;
		case 3: //3일때 WED
			System.out.println("WED");
			break;
		case 4: //4일때 THU
			System.out.println("THU");
			break;
		case 5: //5일때 FRI
			System.out.println("FRI");
			break;
		case 6: //6일때 SAT
			System.out.println("SAT");
			break;
		case 0: //0일때 SUN
			System.out.println("SUN");
			break;
		}
	}

}