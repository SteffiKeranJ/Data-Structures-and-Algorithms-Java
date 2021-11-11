class Solution {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> opMap = new HashMap<>();
    
    static {
        opMap.put("+", (a, b) -> a+b);
        opMap.put("-",(a, b) -> a-b);
        opMap.put("*",(a, b) -> a*b);
        opMap.put("/",(a, b) -> a/b);
    }
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token: tokens) {
            if(opMap.containsKey(token)) {
                int second = st.peek();
                st.pop();
                int first = st.peek();
                st.pop();
                BiFunction<Integer, Integer, Integer> op = opMap.get(token);
                int res = op.apply(first, second);
                st.push(res);
            } else {
                st.push(Integer.valueOf(token));
            }
        }
        return st.peek();
        
    }
}
