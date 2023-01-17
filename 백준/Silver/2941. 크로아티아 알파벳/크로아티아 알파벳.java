import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String cta[]= {"c=","c-","dz=","d-","lj","nj","s=","z="};
		String s=scan.next();
		int count=0;
		
		for (int i=0;i<s.length();) {
			if (i<s.length()-1) { // index가 i일 때 아직 뒤에 단어가 하나라도 남아있으면
				String toComp=s.substring(i, i+2);
				int j;
				for (j=0;j<cta.length;j++) // "dz="를 제외한 크로아티아 알파벳이 있는지 확인
					if (toComp.equals(cta[j])) {
						count++;
						i+=2;
						break;
					}
				if ((j==cta.length)&&(i<s.length()-2)) { // "dz="인지 확인
					toComp=s.substring(i,i+3);
					if (toComp.equals(cta[2])) {
						count++;
						i+=3;
					}
					else { // "dz="도 아니라면 일반 알파벳
						count++;
						i++;
					}
				}
				else if ((j==cta.length)){ // "dz="가 되기에는 뒤에 남아있는 단어가 없다면 일반 알파벳
					count++;
					i++;
				}
			}
			else { // index가 i일 때 아직 뒤에 단어가 하나라도 남아있지 않으면 자동으로 일반 알파벳
				count++;
				i++;
			}
		} 
		System.out.println(count);
	}

}