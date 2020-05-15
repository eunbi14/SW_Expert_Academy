package d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백만장자프로젝트_1859 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:/coding_test/SW_Expert_Academy/src/d2/input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		long[] answer = new long[T];
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(bf.readLine());
			String[] str = bf.readLine().split(" ");
			int[] price = new int[N];
			for(int j=0;j<price.length;j++) {
				price[j] = Integer.parseInt(str[j]);
			}
			
			answer[i] = solution(N, price);
		}
		
		for(int i=0;i<T;i++) System.out.println("#"+(i+1)+" "+answer[i]);
		
	}

	private static long solution(int N, int[] price) {
		// TODO Auto-generated method stub
		long answer = 0;
		int max = price[N-1];
		for(int i=N-2;i>=0;i--) {
			if(price[i]<max) answer += max-price[i];
			else max = price[i];
		}
		
		return answer;
	}

}
