package Elevator;

public class Request {
    int currFloor;
    int desiredFLoor;
    Direction direction;
    Location location;

    public Request(int currFloor, int desiredFLoor, Direction direction, Location location){
        this.currFloor = currFloor;
        this.desiredFLoor = desiredFLoor;
        this.direction = direction;
        this.location = location;
    }
}
