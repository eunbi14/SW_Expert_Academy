import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

class Solution
{
    static int[][] fly;
    static int M;
    static int[] answer;
	public static void main(String args[]) throws Exception
	{
		
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.valueOf(bf.readLine());
		answer = new int[T];
		for(int test_case = 0; test_case < T; test_case++)
		{
			String[] s = bf.readLine().split(" ");
            int N = Integer.valueOf(s[0]);
            M = Integer.valueOf(s[1]);
            fly = new int[N][N];
            for(int i=0;i<N;i++){
             	s = bf.readLine().split(" ");   
                for(int j=0;j<N;j++){
                    fly[i][j] = Integer.valueOf(s[j]);
                }
            }
            
            for(int i=0;i<=N-M;i++){
                for(int j=0;j<=N-M;j++){
                    solution(i, j, test_case);
                }
            }
          
		}
        
        for(int i=0;i<T;i++) System.out.println("#"+(i+1)+" "+answer[i]);
	}
    
    public static void solution(int row, int col, int test_case){
        int sum = 0;
        for(int i=row;i<row+M;i++){
            for(int j=col;j<col+M;j++){
                sum += fly[i][j];
            }
        }
        
        if(answer[test_case]<sum) answer[test_case] = sum;
    }
}
