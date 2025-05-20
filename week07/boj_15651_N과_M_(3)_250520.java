import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<Integer> sel = new ArrayList<>();
	static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		input();
		
		func(0);
		
		bw.write(sb.toString());
		bw.close();
	}

	private static void func(int cnt) {
		
		if(cnt == M) {
			printNums();
			return;
		}
		
		for(int i=1; i<=N; ++i) {
			sel.add(i);
			func(cnt+1);
			sel.remove(sel.size()-1);
		}
		
	}

	private static void printNums() {
		for(int i=0; i<sel.size(); ++i) {
			sb.append(sel.get(i)).append(' ');
		}
		sb.append('\n');
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
	}

}
