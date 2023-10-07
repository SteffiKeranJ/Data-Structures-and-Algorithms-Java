/**
* https://leetcode.com/problems/top-k-frequent-elements/description/
*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for(int num: nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0)+1);
        int[] ans = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return freqMap.get(b) - freqMap.get(a);
            }
        });

        for(int it: freqMap.keySet()){
            pq.add(it);
        }

        for(int i=0; i<k; i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
}
