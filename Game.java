import java.util.Scanner;

public class Game {
    private Board board;
    private boolean isGameOver;
    private boolean isBlackTurn;

    public Game(){
        this.board = new Board();
        this.isGameOver = false;
        this.isBlackTurn=true;
    }

    public void start(){
        board.printBoard();
        System.out.println("The matrix is 0-indexed, the top-left index is (0,0).");
        System.out.println("The move command of the piece from 'row 6 col 1' to 'row 4 col 1' is 6 1 4 1");
        Scanner scanner = new Scanner(System.in);

        while(!isGameOver){
            int start_x, start_y, end_x, end_y;
            boolean validInput = false;
            Move move = null;

            while(!validInput){
                try{
                    if(isBlackTurn){
                        System.out.println("Black's turn: Enter your move (format: start_x start_y end_x end_y): ");
                    } 
                    else{
                        System.out.println("White's turn: Enter your move (format: start_x start_y end_x end_y): ");
                    }

                    start_x = scanner.nextInt();  
                    start_y = scanner.nextInt();  
                    end_x = scanner.nextInt();    
                    end_y = scanner.nextInt();  
                    
                    if (start_x < 0 || start_x >= 8 || start_y < 0 || start_y >= 8 || end_x < 0 || end_x >= 8 || end_y < 0 || end_y >= 8){
                        System.out.println("Invalid move. Coordinates must be within the 8x8 grid (0-7). Please try again.");
                        continue;
                    }

                    move = new Move(isBlackTurn, board.getBlock(start_x, start_y), board.getBlock(end_x, end_y));

                    validInput = true;
                } catch(Exception e){
                    System.out.println("Invalid input, please enter integers for coordinates.");
                    scanner.nextLine();
                }
            }

            if(isBlackTurn){
                if(move.generalMoveValidation(isBlackTurn) && move.getStartBlock().getPiece().canMove(board, move)){
                    if(move.isAWinningMove(isBlackTurn)){
                        isGameOver=true;
                        System.out.println("Black Wins !!!");
                    }
                    board.updateBoard(move);
                    display();
                }
                else{
                    System.out.println("The move is not a valid move, please try again");
                    continue;
                }
            }
            else{
                if(move.generalMoveValidation(isBlackTurn) && move.getStartBlock().getPiece().canMove(board, move)){
                    if(move.isAWinningMove(isBlackTurn)){
                        isGameOver=true;
                        System.out.println("White Wins !!!");
                    }
                    board.updateBoard(move);
                    display();
                    
                }
                else{
                    System.out.println("The move is not a valid move, please try again");
                    continue;
                }
            }

            isBlackTurn = !isBlackTurn;
        }

        scanner.close();
    }

    public void display(){
        this.board.printBoard();
    }
}
