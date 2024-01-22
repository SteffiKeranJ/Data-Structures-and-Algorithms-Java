/**
1338. Reduce Array Size to The Half
You are given an integer array arr. You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.
Example 1:

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has a size greater than half of the size of the old array.

Example 2:

Input: arr = [7,7,7,7,7,7]
Output: 1
Explanation: The only possible set you can choose is {7}. This will make the new array empty.
**/

class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int result = 0;
        int i = 0, l = arr.length, half = l/2;
        while(i < l) {
            freqMap.merge(arr[i++], 1, Integer::sum);
        }
        int[] frequencies = new int[freqMap.values().size()];
        i = 0;
        for(int val: freqMap.values()) frequencies[i ++] = val;
        Arrays.sort(frequencies);
        int sum = 0, removed = 0;
        i = frequencies.length - 1;
        while(removed < half) {
            result++;
            removed += frequencies[i--];
        }
        return result;
    }
}
