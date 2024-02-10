/**
You are given the integer numArrows and an integer array aliceArrows of size 12, which represents the number of arrows Alice shot on each scoring section from 0 to 11. Now, Bob wants to maximize the total number of points he can obtain.

Return the array bobArrows which represents the number of arrows Bob shot on each scoring section from 0 to 11. The sum of the values in bobArrows should equal numArrows.

If there are multiple ways for Bob to earn the maximum total points, return any one of them.

Example 1:

Input: numArrows = 9, aliceArrows = [1,1,0,1,0,0,2,1,0,1,2,0]
Output: [0,0,0,0,1,1,0,0,1,2,3,1]
Explanation: The table above shows how the competition is scored. 
Bob earns a total point of 4 + 5 + 8 + 9 + 10 + 11 = 47.
It can be shown that Bob cannot obtain a score higher than 47 points.

Example 2:

Input: numArrows = 3, aliceArrows = [0,0,1,0,0,0,0,0,0,0,0,2]
Output: [0,0,0,0,0,0,0,0,1,1,1,0]
Explanation: The table above shows how the competition is scored.
Bob earns a total point of 8 + 9 + 10 = 27.
It can be shown that Bob cannot obtain a score higher than 27 points.

**/


class Solution {
    private int[] maxBob = new int[12];
    private int maxBobPoint = 0;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        
        int[] tempBob = new int[12];
        backTrack(aliceArrows, tempBob, numArrows, 11, 0);
        return maxBob;
    
    }

    private void backTrack(int[] aliceArrows, int[] temp, int bobArrowsLeft, int index, int point) {
        if(bobArrowsLeft <= 0 || index < 0) {
            if(bobArrowsLeft > 0) {
                temp[0] += bobArrowsLeft;
            } 
            if(point > maxBobPoint) {
                maxBobPoint = point;
                maxBob = temp.clone();
            }
            return;
        }

        int arrowsReq = aliceArrows[index]+1;
        if(arrowsReq <= bobArrowsLeft) {
            temp[index] = arrowsReq;
            backTrack(aliceArrows, temp, bobArrowsLeft-arrowsReq, index-1, point + index);
            temp[index] = 0;
        }

        backTrack(aliceArrows, temp, bobArrowsLeft, index-1, point);
        temp[index] = 0;
    }
}

