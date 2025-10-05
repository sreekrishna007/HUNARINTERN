import java.util.Scanner;

public class TicTacToe{
    static char[][] board={
        {' ',' ',' '},
        {' ',' ',' '},
        {' ',' ',' '}
    };
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        char currentPlayer='X';
        boolean gameOn=true;

        System.out.println("Welcome to Tic Tac Toe Game!");
        printBoard();

        while(gameOn){
            System.out.println("Player "+currentPlayer+", enter row and column(0,1 or 2):");
            int row=sc.nextInt();
            int col=sc.nextInt();

            if(row>=0 && row<3 && col>=0 && col<3 && board[row][col]==' '){
                board[row][col]=currentPlayer;
                printBoard();

                if(checkWinner(currentPlayer)){
                    System.out.println("Player "+currentPlayer+" wins!");
                    gameOn=false;
                }
                else if(isBoardFull()){
                    System.err.println("It's a tie!");
                    gameOn=false;
                }
                else{
                    currentPlayer=(currentPlayer=='X')?'O':'X';
                }
            }
            else{
                System.out.println("Invalid move. Try again!");
            }
        }
        System.out.println("Game over. Thanks for playing!");
    }
    
    public static void printBoard(){
        System.out.println("-------------");
        for(int i=0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public static boolean checkWinner(char player) {
        for(int i=0;i<3;i++){
            if((board[i][0]==player && board[i][1]==player && board[i][2]==player)||(board[0][i]==player && board[1][i]==player && board[2][i]==player)){
                return true;
            }
        }
        if((board[0][0]==player && board[1][1]==player && board[2][2]==player)||(board[0][2]==player && board[1][1]==player && board[2][0]==player)){
            return true;
        }
        return false;
    }

    public static boolean isBoardFull(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==' '){
                    return false;
                }
            }
        }
        return true;
    }
}