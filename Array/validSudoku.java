import java.util.Set;

public class validSudoku {

    public boolean isValidS(int sr,int er,int sc,int ec,char[][] board){
        Set<Integer> set=new HashSet<>();
        for(int i=sr;i<=er;I++){
            for(int j=sc;j<=ec;j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }

        return true;
    }

    public boolean isValidSudoku(char[][] board){

        //for row validate
        for(int row = 0 ; row < 9 ;row++){
            Set<Integer> set=new HashSet<>();
            for(int col = 0 ; col < 9 ; col++){
                if(board[row][col] == '.') continue;
                if(set.conatins(board[row][col])) return false;
                set.add(board[row][col]);
            }
        }

        //for col validate
        for(int col=0;col < 9;col++){
            Set<Integer> set=new HashSet<>();
            for(int row=0;row < 9;row++){
                if(board[row][col] == '.') continue;
                if(set.conatins(board[row][col])) return false;
                set.add(board[row][col]);
            }
        }

        //for 3x3 board
        for(int sr=0;sr<9;sr += 3){
            int er=sr+2;
            for(int sc=0;sc<9;sc += 3){
                int ec=sc+2;
                if(!isValidS(sr,er,sc,ec,board)) return false;
            }
        }

        return true;
    }
}


//2nd - Method

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set=new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char num = board[i][j];
                if(num == '.') continue;
                
                String row = num + "_row_" + i;
                String col = num + "_col_" + j;
                String box = num + "_box_" + (i/3) + "_" + (j/3);

                if(!set.add(row) || !set.add(col) || !set.add(box)) return false;
            }
        }

        return true;
    }
}