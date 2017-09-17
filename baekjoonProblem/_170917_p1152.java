package algo.baekjoonProblem;

import java.util.Scanner;
/* 
 * 17.09.17
 * https://www.acmicpc.net/problem/1152
 * 항상 예외인 경웅를 생각하는 습관을 가져야 한다. 이경우에서 예외는 단어를 입력하지 않았을 경우다
 */

public class _170917_p1152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().trim();
		
		int ans = 1;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==' ')ans++;
		}
		if(str.length()==0)
			ans=0;
		System.out.println(ans);
	}

}
