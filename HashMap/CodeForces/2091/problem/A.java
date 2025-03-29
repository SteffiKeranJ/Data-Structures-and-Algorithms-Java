// problem: https://codeforces.com/contest/2091/problem/A

import java.util.HashMap;
    import java.util.Scanner;
     
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            // Read input
            int t = scanner.nextInt();
            for(int i = 0; i < t; ++i) {
                int n = scanner.nextInt();
                int[] arr = new int[n];
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                hashMap.put(0, 3);
                hashMap.put(1, 1);
                hashMap.put(2,2);
                hashMap.put(3,1);
                hashMap.put(5,1);
                for(int j = 0; j < n; ++j) {
                    arr[j] = scanner.nextInt();
                }
                System.out.println(computeMinOp(arr,n,hashMap));
            }
            scanner.close();
        }
     
        private static int computeMinOp(int[] arr, int n, HashMap<Integer, Integer> hashMap) {
            for (int i = 0; i < n; ++i) {
                if(!hashMap.containsKey(arr[i])) continue;
                hashMap.computeIfPresent(arr[i], (key, val) -> val-1);
                if(hashMap.get(arr[i]) == 0) hashMap.remove(arr[i]);
                if(hashMap.isEmpty()) return i+1;
            }
            return 0;
        }
    }
