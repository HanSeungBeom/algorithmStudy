package algo.baekjoonProblem;


import java.util.Scanner;


/* 
 * 17.10.11
 * https://www.acmicpc.net/problem/9935
 * 시간 초과 오류가 났다. 내일 다시 도전.
 */
public class _171011_9935 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String bomb = sc.nextLine();
		char trigger = bomb.charAt(bomb.length() - 1);
		String ans = "";
		
		for (int i = 0; i < str.length(); i++) {
			ans += str.charAt(i);
			if (ans.length() >= bomb.length() && str.charAt(i)==trigger) {
				if (ans.substring(ans.length()-bomb.length()).equals(bomb)) {
					ans = ans.substring(0, ans.length() - bomb.length());
				}
			}
	
		}
		System.out.println(ans);
	}

}
