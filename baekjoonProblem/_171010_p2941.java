package algo.baekjoonProblem;

import java.util.ArrayList;
import java.util.Scanner;
/* 
 * 17.10.10
 * https://www.acmicpc.net/problem/2941
 * 최근 봤던 시험에서 문자열 관련된 시험이 많아서 문자열 관련된 문제를 풀어보았다.
 * 시간 복잡도는 받는 문자열 N, 문자열 개수 M, 각각의 문자열 길이 l이라고 했을때
 * O(NMl)이 된다.
 */
public class _171010_p2941 {

	public static final String[] croatianStr ={"c=","c-","dz=","d-","lj","nj","s=","z="};
	public static final int croatianWordNum = 8;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		int ans = 0;
		
		for(int i=0;i<str.length();i++){
			boolean findCroatianWord = false;
			
			for(int j=0;j<croatianWordNum;j++){
				boolean isCroatianWord = true;
				for(int k=0;k<croatianStr[j].length();k++){
					if(i+k>=str.length() || str.charAt(i+k)!=croatianStr[j].charAt(k))
						isCroatianWord = false;
				}
				if(isCroatianWord){
					ans ++;
					i+=croatianStr[j].length()-1;
					findCroatianWord = true;
					break;
				}
			}
			if(!findCroatianWord)
				ans++;	
		}
		
		System.out.println(ans);
	}

}
