class Solution {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        //         Arrays.sort(meetings, (a,b)->a[0]-b[0])
        Arrays.sort(meetings,  Comparator.comparingInt(o -> o[0]));
        int totalWorking = 0;
        int start = meetings[0][0];
        int end = meetings[0][1];
        for(int i = 1; i < n; ++i) {
            int currStart = meetings[i][0];
            int currEnd = meetings[i][1];
            if(currStart <= end) end = Math.max(currEnd, end);
            else {
                totalWorking += (end - start) + 1;
                start = currStart;
                end = currEnd;
            }
        }
        totalWorking += (end - start) + 1;
        return days - totalWorking;

    }
}
