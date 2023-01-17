import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String jh = bf.readLine();
		String doctor = bf.readLine();
		
		if (jh.length() >= doctor.length())
			System.out.println("go");
		else
			System.out.println("no");
	}

}
