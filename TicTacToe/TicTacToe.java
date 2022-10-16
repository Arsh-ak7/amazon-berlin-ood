package TicTacToe;

import java.util.*;

class Player {
    Integer id;

    public Player(Integer id) {
        this.id = id;
    }
}

class Cell {
    Integer playerId;

    public Cell() {
        this.playerId = null;
    }

    public Integer getId() {
        return this.playerId;
    }

    public void markCell(Integer id) {
        this.playerId = id;
    }
}

class Board {
    Cell[][] board;
    int size;

    public Board(int size) {
        for (int i = 0; i < size; i += 1) {
            for (int j = 0; j < size; j += 1) {
                board[i][j] = new Cell();
            }
        }
        this.size = size;
    }

    public Boolean checkWinner(Integer id, int x, int y) {
        System.out.println(size + "size");
        for (int i = 0; i < size; i++) {
            if (board[i][y].getId() != id)
                return false;
            if (board[x][i].getId() != id)
                return false;
            if (board[i][i].getId() != id)
                return false;
            if (board[i][size - i - 1].getId() != id)
                return false;
        }

        return true;
    }
}

public class TicTacToe {
    int size;
    Board board;
    Queue<Player> players;

    public TicTacToe(int size) {
        this.size = size;
        this.board = new Board(size);
        this.players = new LinkedList<>();
    }

    public void initialisePlayers(int count) {
        for (int i = 0; i < count; i += 1) {
            Player newPlayer = new Player(i + 1);
            players.offer(newPlayer);
        }
    }

    public Boolean makeMove(Player playerId, int x, int y) {
        board.board[x][y].markCell(playerId.id);
        this.players.poll();
        this.players.add(playerId);
        return board.checkWinner(playerId.id, x, y);
    }

    public static void main(String[] args) {
        TicTacToe newGame = new TicTacToe(3);
        newGame.initialisePlayers(2);
        while (newGame.players.isEmpty() == false)
            newGame.makeMove(newGame.players.peek(), 0, 0);
    }
}
