package Leetcode;

public class LC130_SurroundRegion {

    public static void solve(char[][] board) {
        if(board.length>2){


            boolean[][] label = new boolean[board.length][board[0].length];
            boolean[][] visited = new boolean[board.length][board[0].length];
            //top
            for(int i = 0; i<board[0].length;i++){
                if(board[0][i] == 'O'){
                    search(board,label,visited,0,i);
                }
            }

            //bottom
            for(int i = 0; i<board[0].length;i++){
                if(board[board.length-1][i] == 'O'){
                    search(board,label,visited,0,i);
                }
            }

            //left
            for(int i = 1; i<board.length-1;i++){
                if(board[i][0] == 'O'){
                    search(board,label,visited,0,i);
                }
            }

            //right
            for(int i = 1; i<board.length-1;i++){
                if(board[i][board[0].length-1] == 'O'){
                    search(board,label,visited,0,i);
                }
            }


            for(int x = 1; x< label.length-1;x++){
                for(int y = 1; y<label[0].length-1;y++){
                    if(label[x][y]==false)
                        board[x][y] = 'X';
                }
            }
        }

        System.out.println(board);


    }


    public static void search(char[][] board, boolean[][] label, boolean[][] visited,int x, int y){
        System.out.println(y);
        if(board[x][y] == 'O' &&visited[x][y]==false)
        {
            visited[x][y] = true;
            label[x][y] = true;
            if(x>0)
                search(board,label,visited,x-1,y);
            if(x<board.length-1)
                search(board,label,visited,x+1,y);
            if(y>0)
                search(board,label,visited,x,y-1);
            if(y<board[0].length-1)
                search(board,label,visited,x,y+1);

        }


    }
    public static void main(String [ ] args){
        char[][] test = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(test);
    }
}
