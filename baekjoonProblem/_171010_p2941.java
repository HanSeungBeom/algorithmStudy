package algo.baekjoonProblem;

import java.util.ArrayList;
import java.util.Scanner;
/* 
 * 17.10.10
 * https://www.acmicpc.net/problem/2941
 * �ֱ� �ô� ���迡�� ���ڿ� ���õ� ������ ���Ƽ� ���ڿ� ���õ� ������ Ǯ��Ҵ�.
 * �ð� ���⵵�� �޴� ���ڿ� N, ���ڿ� ���� M, ������ ���ڿ� ���� l�̶�� ������
 * O(NMl)�� �ȴ�.
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
