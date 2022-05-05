import java.io.*;

public class IO_15552 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
			
			int t=Integer.parseInt(bf.readLine());
			
			for (int i=0;i<t;i++) {
				String s=bf.readLine();
				String arr[]=s.split(" ");
				int add=Integer.parseInt(arr[0])+Integer.parseInt(arr[1]);
				bw.write(add+"\n");
			}
			
			bw.flush();
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}