package algo.baekjoonProblem;
import java.util.Scanner;

//백준 2869번
//분류 : 수학, 이진탐색
//나눗셈 개념과, 이진탐색할때 upper_bound 조건이 까다로웠다.

public class p2869 {

	static int A,B,V;

	public static boolean search(int d){
		if(d+A<V){
			return true;
		}
		else{
			return false;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		V = sc.nextInt();
		
		int low = 0;
		int high = V;
		
		while(low<high){
			int mid = (low+high+1)/2;
			if(search(mid)){
				low = mid;
			}
			else{
				high = mid-1;
			}
		}
		int answer = high/(A-B)+2;
		System.out.println(answer);
	}
}
