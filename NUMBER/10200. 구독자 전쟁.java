import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input.txt"));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(bf.readLine());
	
		int[] min = new int[T];
        int[] max = new int[T];
		for(int test_case = 0; test_case < T; test_case++)
		{
			String[] s = bf.readLine().split(" ");
            int N = Integer.valueOf(s[0]);
            int A = Integer.valueOf(s[1]);
            int B = Integer.valueOf(s[2]);
            
            
            if(A+B<=N){
                min[test_case] = 0;
                max[test_case] = Math.min(A, B);
            }
            else { // A+B>N
                min[test_case] = (A+B) - N;
                max[test_case] = Math.min(A, B);
            }
		}
        
        for(int i=0;i<T;i++){
            System.out.println("#"+(i+1)+" "+max[i]+" "+min[i]);
        }
	}
}
