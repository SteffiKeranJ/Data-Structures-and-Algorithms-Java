//https://atcoder.jp/contests/abs/tasks/abc087_b 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read input
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int x = scanner.nextInt();
        int result = 0;
        for(int i = 0; i <= a; ++i) {
            for(int j = 0; j <=b; ++j) {
                for(int k = 0; k <= c; ++k) {
                    int total = i*500 + j*100 + k*50;
                    if(total == x) result++;
                }
            }
        }
        System.out.println(result);
        scanner.close();
    }
}
