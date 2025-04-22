import java.io.*;
import java.util.*;

public class boj_3079_입국심사_250422 {
   static int N, M;
   static int[] times;
   static int maxTime;

   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      input(br);
      System.out.println(findMinTime());
   }

   private static long findMinTime() {
      long min = 1;
      long max = (long) maxTime * M;
      long result = max;

      while(min <= max) {
         long mid = (min + max) / 2;
         long people = countProcessed(mid);

         if(people >= M) {
            result = Math.min(result, mid);
            max = mid - 1;
         } else {
            min = mid + 1;
         }
      }
      return result;
   }

   private static long countProcessed(long time) {
      long count = 0;
      for (int t : times) {
         count += time / t;
         if(count>=M) return count;
      }
      return count;
   }

   private static void input(BufferedReader br) throws Exception {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      times = new int[N];
      for (int i = 0; i < N; i++) {
         times[i] = Integer.parseInt(br.readLine());
         maxTime = Math.max(maxTime, times[i]);
      }
   }
}