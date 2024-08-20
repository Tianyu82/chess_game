public class Board {
    private Block[][] blocks;

    public Board(){
        this.blocks = new Block[8][8];
        initialBoard();
    }

    private void initialBoard(){
        //white Pieces
        blocks[0][0] = new Block(0,0,new Rook(true, "W_Rook"));
        blocks[0][1] = new Block(0,1,new Knight(true, "W_Knight"));
        blocks[0][2] = new Block(0,2,new Bishop(true, "W_Bishop"));
        blocks[0][3] = new Block(0,3,new Queen(true, "W_Queen"));
        blocks[0][4] = new Block(0,4,new King(true, "W_King"));
        blocks[0][5] = new Block(0,5,new Bishop(true, "W_Bishop"));
        blocks[0][6] = new Block(0,6,new Knight(true, "W_Knight"));
        blocks[0][7] = new Block(0,7,new Rook(true, "W_Rook"));
        for(int j=0; j<8 ; j++){
            blocks[1][j] = new Block(1,j,new Pawn(true, "W_Pawn"));
        }
        //black Pieces
        blocks[7][0] = new Block(7,0,new Rook(false, "B_Rook"));
        blocks[7][1] = new Block(7,1,new Knight(false, "B_Knight"));
        blocks[7][2] = new Block(7,2,new Bishop(false, "B_Bishop"));
        blocks[7][3] = new Block(7,3,new Queen(false, "B_Queen"));
        blocks[7][4] = new Block(7,4,new King(false, "B_King"));
        blocks[7][5] = new Block(7,5,new Bishop(false, "B_Bishop"));
        blocks[7][6] = new Block(7,6,new Knight(false, "B_Knight"));
        blocks[7][7] = new Block(7,7,new Rook(false, "B_Rook"));
        for(int j=0; j<8 ; j++){
            blocks[6][j] = new Block(6,j,new Pawn(false, "B_Pawn"));
        }
        //rest of the blocks having no pieces
        for(int i=2;i<6;i++){
            for( int j=0; j<8; j++){
                blocks[i][j] = new Block(i,j,null);
            }
        }
    }

    public void printBoard(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(this.blocks[i][j].getPiece()!=null){
                    System.out.printf("%-12s", this.blocks[i][j].getPiece().getName());
                }
                else{
                    System.out.printf("%-12s", "null");
                }
                System.out.print("     ");
            }
            System.out.print("\n");
        }
        System.out.println("*****************************************************************************************************************************");
    }

    public Block getBlock(int x, int y){
        return blocks[x][y];
    }

    public void updateBoard(Move move){
        Block startBlock = move.getStartBlock();
        Block endBlock = move.getEndBlock();
        endBlock.setPiece(startBlock.getPiece());
        startBlock.setPiece(null);
    }
}
