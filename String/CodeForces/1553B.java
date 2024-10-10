/**
B. Reverse String

Problem link: https://codeforces.com/problemset/problem/1553/B

**/

import java.io.BufferedReader;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int TC = Integer.parseInt(br.readLine());
    while(TC-- > 0) {
      boolean flag = false;
      char[] S = br.readLine().toCharArray();
      char[] T = br.readLine().toCharArray();
      for(int i = 0; i < S.length; ++i) {
        for(int j = 0; j < T.length; ++j) {
          if(S[i] != T[j]) continue;
          int s = 0;
          while(i - s >= 0 && j - s >= 0 && S[i-s] == T[j-s]) s++;
          int e = 1;
          while(i - e >= 0 && j + e < T.length && S[i - e] == T[j+e]) e++;
          if(s+e-1 == T.length) flag = true;
        }
      }
      sb.append(flag ? "YES": "NO");
      sb.append("\n");
    }
    System.out.println(sb);
  }

}
