package algo.baekjoonProblem;
import java.util.Scanner;

//Ǭ ��¥:17.09.06
//���� 2935��
//�з� : ū�� ó��, ���ܰ�� ����
// * �϶��� ���ܰ� �����µ�, +�϶��� �����ڸ����϶� 2�� �ȴٴ� ��츦 �����ϴ°� �������.
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
