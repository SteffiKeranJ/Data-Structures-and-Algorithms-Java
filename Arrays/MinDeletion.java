class Solution {
    public int minDeletion(String s, int k) {
        Map<Character, Integer> hmap = new HashMap<>();
        int uniq = 0;
        for(int i = 0; i < s.length(); ++i) {
            Integer val = hmap.get(s.charAt(i));
            if(val == null) {
                uniq+=1;
                hmap.put(s.charAt(i), 1);
            }
            else hmap.put(s.charAt(i), val+1);
        }
        
        if(uniq == k) return 0;
        int result = 0;
        
        List<Integer> vals = new ArrayList<>(hmap.values());
        Collections.sort(vals);
        
        for(int i = 0; i < uniq-k; ++i ){
            result+=vals.get(i);
        }
        return result;

    }
}
