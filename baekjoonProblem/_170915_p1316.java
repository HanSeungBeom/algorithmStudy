package algo.baekjoonProblem;

import java.util.Scanner;


/* 
 * 17.09.15
 * https://www.acmicpc.net/problem/1316
 * flag ������ ����ȭ ����� �ʿ��� �� ����. �ð����⵵�� O(N^2)��.
 * ���ڸ� �����ϸ� ���� ã�� �� ���� ������ N^2 �� �ּ��� ����� �� ����.
 */
public class _170915_p1316 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int ans = 0;
		for(int i=0;i<N;i++){
			String str = sc.nextLine();
			boolean isGroup = true;
			boolean[] check = new boolean[26];
			char lastC = '`';
			for(int j=0;j<str.length();j++){
				char c = str.charAt(j);
				if(c!=lastC){
					if(check[c-'a']){
						isGroup = false;
						break;
					}
					else{
						check[c-'a'] = true;
						lastC = c;
					}
				}
				else
					continue;
			}
			if(isGroup)ans++;
		}
		System.out.println(ans);
	}

}
