import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
    static boolean[][] line;
    static int N;
    static int[] answer;
	public static void main(String args[]) throws Exception
	{
       // System.setIn(new FileInputStream("C:/coding_test/SW_Expert_Academy/src/d3/sample_input.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(bf.readLine());
        answer = new int[T];
		
		
		
		for(int test_case = 0; test_case < T; test_case++)
		{
            String[] s = bf.readLine().split(" ");
            N = Integer.valueOf(s[0]);
            
            int M = Integer.valueOf(s[1]);
            
            if(M==0) {
                
                answer[test_case] = 1;
                continue;
            }
            
            line = new boolean[N+1][N+1];
            boolean[] visited = new boolean[N+1];
            
            for(int m=0;m<M;m++){
                s = bf.readLine().split(" ");
                line[Integer.valueOf(s[0])][Integer.valueOf(s[1])] = true;
                line[Integer.valueOf(s[1])][Integer.valueOf(s[0])] = true;
            }
          
            for(int i=1;i<=N;i++){
                solution(i, visited, 1, test_case);
                Arrays.fill(visited, false);
            }
            
            
		}
        
        for(int i=0;i<T;i++) System.out.println("#"+(i+1)+" "+answer[i]);
	}
    
    public static void solution(int from, boolean[] visited, int length, int test_case){
        visited[from] = true;
        
        for(int i=1;i<=N;i++){
            if(i==from) continue;
            if(line[from][i] && !visited[i]){
                solution(i, visited, length+1, test_case);
                visited[i] = false;
            }
        }
    
        
        if(answer[test_case]<length)  answer[test_case] = length;
    }
}
