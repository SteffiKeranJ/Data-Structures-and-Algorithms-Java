import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner br = new Scanner(System.in);
        PrintWriter pr = new PrintWriter(System.out);
        int[][] matrix = new int[5][5];
        int oneRowIndex = -1;
        int oneColIndex = -1;
        for(int i = 0; i < 5; ++i) {
            for(int j = 0; j < 5; ++j) {
                matrix[i][j] = br.nextInt();
                if(matrix[i][j] == 1) {
                    oneRowIndex = i;
                    oneColIndex = j;
                }
            }
        }

        System.out.print(Math.abs(2-oneRowIndex) + Math.abs(2-oneColIndex));
        
        pr.close();
        
    }
}