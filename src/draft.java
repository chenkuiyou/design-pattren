import java.util.ArrayList;
import java.util.List;

/**
 * @author cky
 * @create 2020 2 25 13:01
 */
public class draft {
    public static void main(String[] args) {
        List l=new ArrayList();
        List l2=new ArrayList();
        l.add(1);
        l.add(1);
        l.add(3);
        l2.add(4);
        l2.add(6);
        l2.add(5);
        l.add(l2);
        for (Object i:l)
            System.out.println(i);
    }
}

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null)
            return false;
        if(matrix.length==0||matrix[0].length==0)
            return false;
        int n=matrix.length;
        int m=matrix[0].length;
        int i=0;
        int j=m-1;
        while(i<n&&j>-1){
            if(target>matrix[i][j])
                i++;
            else if(target<matrix[i][j])
                j--;
            else return true;
        }
        return false;
    }
}