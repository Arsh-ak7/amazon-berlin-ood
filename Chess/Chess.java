package Chess;

import java.util.ArrayList;
import java.util.List;

class Slot {
    private Piece piece;
    private Integer x;
    private Integer y;

    public Slot(Piece piece, Integer x, Integer y){
        this.piece = piece;
        this.x = x;
        this.y = y;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public Integer getX(){
        return this.x;
    }

    public Integer getY(){
        return this.y;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

}

abstract class Piece {
    private Boolean white;
    private Boolean isAlive;

    public void setColor(Boolean isWhite){
        this.white = isWhite;
    }

    public void isCaptured() {
        this.isAlive = false;
    }

    public Boolean isWhite() {
        return this.white;
    }

    public Boolean isAlive() {
        return this.isAlive;
    }

    public abstract Boolean canMove(Board board, Slot start, Slot end);
}

class King extends Piece {
    public Boolean canMove(Board board, Slot start, Slot end) {
        if(end.getPiece().isWhite() == this.isWhite())
            return false;

        Integer x = Math.abs(end.getX() - start.getX());
        Integer y = Math.abs(end.getY() - start.getY());

        if(x + y == 1)
            return true;

        return false;
    }
}

class Pawn extends Piece {
    public Boolean canMove(Board board, Slot start, Slot end) {
        if(end.getPiece().isWhite() == this.isWhite())
            return false;

        Integer x = end.getX() - start.getX();
        Integer y = end.getY() - start.getY();

        if(y == 1 && (x >= -1 || x <= 1))
            return true;

        return false;
    }
}


class Board {
    Slot[][] board;

    public Board() {
        this.resetBoard();
    }

    public void resetBoard() {
        // logic to reset the board
    }


    public Slot getBox(int x, int y)
    {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Error();
        }
        return board[x][y];
    }
}

class Move {
    private Piece piece;
    private Slot start;
    private Slot end;

    public Move(Piece piece, Slot start, Slot end) {
        this.piece = piece;
        this.start = start;
        this.end = end;
    }

    public Piece getPiece(){
        return this.piece;
    }

    public Slot getStart(){
        return this.start;
    }

    public Slot getEnd(){
        return this.end;
    }
}


public class Chess {
    Board board;
    List<Move> moves;

    public Chess() {
        this.board.resetBoard();
        this.moves = new ArrayList<>();
    }

    public void handleRequest(Move move) {
        if(move.getPiece().canMove(this.board, move.getStart(), move.getEnd())){
            // handle valid move
            if(move.getEnd().getPiece().isWhite() != move.getPiece().isWhite()) {
                move.getEnd().getPiece().isCaptured();
            }
        } else {
            throw new Error();
        }
    }

    public void processRequests(List<Move> moves) {
        for(Move move : moves) {
            handleRequest(move);
        }
    }
}
