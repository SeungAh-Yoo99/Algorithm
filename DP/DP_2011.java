/*
일단 처음 수(c[1])가 0이면 암호 해석은 불가능하다.(ans=0)

 

i가 2~n.length() 일 때의 c[i]는 다음과 같은 경우가 발생할 수 있다.

우선 c[i]=0일 때는 c[i-1]가 1과 2일 때만 암호 해석이 가능하다. (10, 20)
그리고 이때는 무조건 c[i-1]가 c[i]와 묶여 하나의 경우만 가질 수 있으니
dp[i]=dp[i-2]이다.
만약 c[i-1]이 1이나 2가 아니라면 암호 해석은 불가능하다.(ans=0)

 

==> 처음에 c[i]=0일 때 10, 20이 아니더라도
c[i+1]와 합쳐져 01~09인 경우도 가능하다고 생각했다.

따라서 0이 연속으로 2번 올 때만 암호 해석이 불가능하다고 생각했다.

(이렇게 생각하면 0이 연속으로 2번 올 때도 1009 같은 경우는 또 해석 가능.

그래서 경우의 수가 엄청 많아진다.)

그런데 01~09인 경우도 안되는 경우라고 생각하는 것 같다.

 

==> c[i]=0이면 c[i-1]가 1이나 2일 때만 암호 해석이 가능하다.
이때 c[i-1]은 무조건 c[i]과 결합되어 한 가지 경우 밖에 될 수 없기 때문에
d[i]=d[i-2]이다.
이걸 처음에 d[i]=d[i-1]로 잘못 생각해서 오류가 났었다.


c[i]가 1~9일 때에는 3가지 경우가 있다.

1. c[i-1]=1일 때 (11~19)

이때는 c[i]이 단독으로 올 수도 있고, c[i-1]와 결합되어 올 수도 있다.
따라서 dp[i]=dp[i-1]+dp[i-2]
dp[i-1]은 c[i]가 단독으로 올 경우,
dp[i-2]은 c[i]와 c[i-1]이 결합되어 올 경우.

2. c[i-1]=2일 때

이때는 c[i]이 1~6일 때 1번의 경우와 같이 작용한다. (21~26)
따라서 dp[i]=dp[i-1]+dp[i-2]

c[i]가 7~9일 때는 c[i]는 단독으로 밖에 해석할 수 없다. (27~29)
따라서 dp[i]=dp[i-1]

3. c[i-1]=0,3~9일 때
이때는 c[i]가 무조건 단독으로 밖에 해석할 수 없다.(1~9, 31~99)
따라서 dp[i]=dp[i-1]

마지막으로 이미 ans가 0이라면 암호 해석이 불가능한 것이므로 0 출력.
0이 아니라면 ans는 dp[n.length()]

 

==>자꾸 15%에서 에러가 걸린다.
돌아가다가 테스트 중간에 어떤 값에서 오류가 생기는 거 같다...
뭔가 생각 못한 변수가 있는 거 같은데 진짜 뭔지 모르겠다ㅜㅜㅜㅜ

 

==> dp 배열과 ans를 long 타입으로 선언하여 답이 배열 안에 범위를 넘지 않고 잘 들어갈 거라고 잘못 생각했다.
근데 dp와 ans를 int 타입으로 선언해주고 답이 범위를 넘지 않도록, 저장할 때 1000000을 나누어 주었다.
이렇게 변수형을 바꾸어주니 다행히 잘 돌아갔다.

장장 11번 만에 풀었다!
*/
import java.util.Scanner;

public class DP_2011 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		String n=scan.next();
		int c[]=new int[n.length()+1];
		int dp[]=new int[n.length()+1];
		int ans=-1; //일단 ans은 -1로 초기화 해둔다.
		dp[0]=1;
		
		for (int i=1;i<=n.length();i++)
			c[i]=n.charAt(i-1)-'0';
		
		if (c[1]==0) //처음이 0이면 암호 해석 불가능.
			ans=0;
		else {
			dp[1]=1;
			for (int i=2;i<=n.length();i++) {
				if (c[i]==0) { //i번째 숫자가 0이라면,
					if((c[i-1]>0)&&(c[i-1]<3)) //i-1번째 숫자가 1,2일때만 암호 해석 가능. (10, 20일 때)
						dp[i]=dp[i-2];
					else { //i-1번째 숫자가 1,2가 아니면,
						ans=0; //암호 해석 불가능.
						break;
					}
				}
				else { //i번째 수가 1~9일 때,
					if (c[i-1]==1) //i-1번째 수가 1이면 (11~19일 때)
						dp[i]=(dp[i-1]+dp[i-2])%1000000;
					else if ((c[i-1]==2)&&(c[i]>=1)&&(c[i]<=6)) //(21~26일 때)
						dp[i]=(dp[i-1]+dp[i-2])%1000000;
					else //i-1번째 수와 i번째 수가 합쳐서 11~26이 안될때
						dp[i]=dp[i-1];
				}
			}
		}
		if (ans!=0) //ans가 이미 0이라면 암호 해석 불가능.
			ans=dp[n.length()];
		System.out.println(ans);
	}

}