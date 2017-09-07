package algo.baekjoonProblem;
import java.util.Scanner;

//푼 날짜:17.09.06
//백준 2935번
//분류 : 큰수 처리, 예외경우 생각
// * 일때는 예외가 없었는데, +일때는 같은자리수일때 2가 된다는 경우를 생각하는게 어려웠다.
public class _170906_p2935 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String c = sc.nextLine();
		String B = sc.nextLine();
		
		String ans;
		
		if(c.equals("*")){
			int a0Count = A.length()-1;
			int b0Count = B.length()-1;
			
			ans="1";
			for(int i=0;i<(a0Count+b0Count);i++){
				ans+="0";
			}
		}
		else{ //"+"
			if(A.length()==B.length()){
				ans = "2";
				for(int i=0;i<A.length()-1;i++){
					ans+="0";
				}
			}
			else{
				String big,small;
				if(A.length()>B.length()){
					big = A;
					small = B;
				}
				else{
					big = B;
					small = A;
				}
				ans = big;
				char[] ansToChar = ans.toCharArray();
				ansToChar[big.length()-small.length()]='1';
				ans = String.valueOf(ansToChar);
			}
		}
		System.out.println(ans);
		
	}
}
