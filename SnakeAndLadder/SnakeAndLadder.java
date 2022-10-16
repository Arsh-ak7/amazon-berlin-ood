package SnakeAndLadder;

import java.util.*;

/*
 * Player
 * player id
 * player position
 */

/*
 * Snake
 * Snake id
 * Snake start , end
 */

 /*
  * Ladder 
  ladder id
  start end
  */


/*
 * Board
 * 
 * board id
 * piecies location
 */

 /* 
  * Dice
    Dice id
    method return random number
  */

class Player {
    private Integer id;
    private Integer playerPosition;

    public Integer getId() {
        return id;
    }
}

class Snake {
    private Integer start;
    private Integer end;

    public Snake(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

class Ladder {
    private Integer start;
    private Integer end;

    public Ladder(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

class Dice {
    String id;

    public Integer roll() {
        return new Random().nextInt(6) + 1;
    }
}

class Board {
    Integer size;
    Map<Integer, Integer> playerPieces;
    List<Ladder> ladders;
    List<Snake> snakes;

    public Board(Integer size) {
        this.size = size;
        this.playerPieces = new HashMap<>();
        this.ladders = new ArrayList<>();
        this.snakes = new ArrayList<>();
    }

    public void setPlayerPieces(Integer Index, Integer playerId) {
        playerPieces.put(playerId, Index);
    }

    public Map<Integer, Integer> getPlayerPieces() {
        return playerPieces;
    }
}

public class SnakeAndLadder {
    private Board board;
    private Integer numOfPlayers;
    private Queue<Player> players;
    private Dice dice;
    
    private static final int BOARD_SIZE = 100;
    private static final int NUMBER_OF_DICE = 1;

    public SnakeAndLadder(int numberOfPlayers) {
        this.board = new Board(BOARD_SIZE);
        this.numOfPlayers = numberOfPlayers;
        this.players = new LinkedList<>();
    }

    public void initialisePlayers(List<Player> players) {
        for(Player player : players) {
            this.players.add(player);
            this.board.setPlayerPieces(player.getId(), 0);
        }
    }

    public int getPositionIfSnakeLadder(int pos) {
        for(Snake snake : this.board.snakes) {
            if(snake.getStart() == pos){
                return snake.getEnd();
            }
        }

        for(Ladder ladder : this.board.ladders) {
            if(ladder.getStart() == pos) {
                return ladder.getEnd();
            }
        }

        return pos;
    }

    public void movePlayer(Player player, int diceRoll) {
        int oldPosition = this.board.getPlayerPieces().get(player.getId());
        int newPosition = oldPosition + diceRoll;

        if(newPosition > this.board.size)
            newPosition = oldPosition;
        else {
            newPosition = getPositionIfSnakeLadder(newPosition);
        }

        this.board.playerPieces.put(player.getId(), newPosition);
    }
}
