/**
3484. Design Spreadsheet
Solved
Medium
Companies
Hint

A spreadsheet is a grid with 26 columns (labeled from 'A' to 'Z') and a given number of rows. Each cell in the spreadsheet can hold an integer value between 0 and 105.

Implement the Spreadsheet class:

    Spreadsheet(int rows) Initializes a spreadsheet with 26 columns (labeled 'A' to 'Z') and the specified number of rows. All cells are initially set to 0.
    void setCell(String cell, int value) Sets the value of the specified cell. The cell reference is provided in the format "AX" (e.g., "A1", "B10"), where the letter represents the column (from 'A' to 'Z') and the number represents a 1-indexed row.
    void resetCell(String cell) Resets the specified cell to 0.
    int getValue(String formula) Evaluates a formula of the form "=X+Y", where X and Y are either cell references or non-negative integers, and returns the computed sum.

Note: If getValue references a cell that has not been explicitly set using setCell, its value is considered 0.

 

Example 1:

Input:
["Spreadsheet", "getValue", "setCell", "getValue", "setCell", "getValue", "resetCell", "getValue"]
[[3], ["=5+7"], ["A1", 10], ["=A1+6"], ["B2", 15], ["=A1+B2"], ["A1"], ["=A1+B2"]]

Output:
[null, 12, null, 16, null, 25, null, 15]

Explanation
Spreadsheet spreadsheet = new Spreadsheet(3); // Initializes a spreadsheet with 3 rows and 26 columns
spreadsheet.getValue("=5+7"); // returns 12 (5+7)
spreadsheet.setCell("A1", 10); // sets A1 to 10
spreadsheet.getValue("=A1+6"); // returns 16 (10+6)
spreadsheet.setCell("B2", 15); // sets B2 to 15
spreadsheet.getValue("=A1+B2"); // returns 25 (10+15)
spreadsheet.resetCell("A1"); // resets A1 to 0
spreadsheet.getValue("=A1+B2"); // returns 15 (0+15)
*/

class Spreadsheet {
    int[][] excel;
    public Spreadsheet(int rows) {
        excel = new int[rows][26];
        
    }
    
    public void setCell(String cell, int value) {
        int alph = (int)cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1)) -1;
        excel[row][alph] = value;
    }
    
    public void resetCell(String cell) {
        int alph = (int)cell.charAt(0)-'A';
        int row = Integer.parseInt(cell.substring(1))-1;
        excel[row][alph] = 0;
    }
    
    public int getValue(String formula) {
        int sum = 0;
        // If getValue references a cell that has not been explicitly set using setCell, its value is considered 0.
        String[] splitString = formula.substring(1).split("\\+");
        for(String term: splitString) {
            term = term.trim();
            // check if it is int
            if (term.matches("\\d+")) {
                sum += Integer.parseInt(term);
            } else {
                int alph = (int)term.charAt(0)-'A';
                int row = Integer.parseInt(term.substring(1)) -1;
                sum+=excel[row][alph];
            }
        }
        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
