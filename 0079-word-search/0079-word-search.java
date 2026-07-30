class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    if(func(0,i,j,board,word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean func(int index,int i, int j, char[][] board, String word){
        if(index == word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(index) != board[i][j]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean ans = func(index+1,i + 1,j,board, word) ||
                      func(index+1,i - 1, j, board,word) ||
                      func(index+1,i, j + 1,board, word) ||
                      func(index+1, i, j - 1,board, word);
        board[i][j] = temp;

        return ans;
    }
}