import java.util.*;

public class IO_5622 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String s=scan.next();
		int time=0;
		
		for (int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			
			if ((c=='A')||(c=='B')||(c=='C'))
				time+=3;
			else if ((c=='D')||(c=='E')||(c=='F'))
				time+=4;
			else if ((c=='G')||(c=='H')||(c=='I'))
				time+=5;
			else if ((c=='J')||(c=='K')||(c=='L'))
				time+=6;
			else if ((c=='M')||(c=='N')||(c=='O'))
				time+=7;
			else if ((c=='P')||(c=='Q')||(c=='R')||(c=='S'))
				time+=8;
			else if ((c=='T')||(c=='U')||(c=='V'))
				time+=9;
			else
				time+=10;
		}
		
		System.out.println(time);
	}

}