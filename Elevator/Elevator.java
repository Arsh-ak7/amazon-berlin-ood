package Elevator;

import java.util.PriorityQueue;

enum Direction {
    UP, DOWN, IDLE
}

enum Location {
    INSIDE_ELEVATOR, 
    OUTSIDE_ELEVATOR
}

public class Elevator {
    int currFloor;
    Direction currDirection;
    PriorityQueue<Request> upQueue;
    PriorityQueue<Request> downQueue;

    public Elevator(int currFloor){
        this.currFloor = currFloor;
        this.currDirection = Direction.IDLE;

        upQueue =  new PriorityQueue<>((a, b) -> a.desiredFLoor - b.desiredFLoor);
        downQueue = new PriorityQueue<>((a, b) -> b.desiredFLoor - a.desiredFLoor);
    }


    public void sendUpRequest(Request upRequest) {
        if(upRequest.location == Location.OUTSIDE_ELEVATOR){
            upQueue.offer(new Request(upRequest.currFloor,
            upRequest.currFloor,
            Direction.UP,
            Location.OUTSIDE_ELEVATOR));
            System.out.println("Append up request going to floor " + upRequest.currFloor + ".");
        }

        upQueue.offer(upRequest);
        System.out.println("Append up request going to floor " + upRequest.currFloor + ".");
    }

    public void sendDownRequest(Request downRequest){
        if(downRequest.location == Location.OUTSIDE_ELEVATOR){
            downQueue.offer(new Request(downRequest.currFloor,
            downRequest.currFloor,
            Direction.DOWN,
            Location.OUTSIDE_ELEVATOR));
            System.out.println("Append down request going to floor " + downRequest.currFloor + ".");
        }

        downQueue.offer(downRequest);
        System.out.println("Append down request going to floor " + downRequest.currFloor + ".");
    }

    public void run() {
        while (!upQueue.isEmpty() || !downQueue.isEmpty()) {
            processRequests();
        }
        System.out.println("Finished all requests.");
        this.currDirection = Direction.IDLE;
    }

    private void processRequests(){
        if(this.currDirection == Direction.UP || this.currDirection == Direction.IDLE){
            processUpRequests();
            processDownRequests();
        } else {
            processDownRequests();
            processUpRequests();
        }
    }

    private void processUpRequests(){
        while(!upQueue.isEmpty()){
            Request upRequest = upQueue.poll();
            this.currFloor = upRequest.desiredFLoor;
            System.out.println("Processing up requests. Elevator stopped at floor " + this.currFloor + ".");
        }

        if (!downQueue.isEmpty()) {
            this.currDirection = Direction.DOWN;
        } else {
            this.currDirection = Direction.IDLE;
        }
    }

    private void processDownRequests() {
        while(!downQueue.isEmpty()){
            Request downRequest = downQueue.poll();
            this.currFloor = downRequest.desiredFLoor;
            System.out.println("Processing down requests. Elevator stopped at floor " + this.currFloor + ".");
        }

        if(!upQueue.isEmpty()){
            this.currDirection = Direction.UP;
        } else {
            this.currDirection = Direction.DOWN;
        }
    }

    public static void main(String args[]){
        Elevator elevator = new Elevator(0);
        
        Request upRequest1 = new Request(elevator.currFloor, 5, Direction.UP, Location.INSIDE_ELEVATOR);
        Request upRequest2 = new Request(elevator.currFloor, 3, Direction.UP, Location.INSIDE_ELEVATOR);

        Request downRequest1 = new Request(elevator.currFloor, 1, Direction.DOWN, Location.INSIDE_ELEVATOR);
        Request downRequest2 = new Request(elevator.currFloor, 2, Direction.DOWN, Location.INSIDE_ELEVATOR);
        Request downRequest3 = new Request(4, 0, Direction.DOWN, Location.OUTSIDE_ELEVATOR);

        // Two people inside of the elevator pressed button to go up to floor 5 and 3.
        elevator.sendUpRequest(upRequest1);
        elevator.sendUpRequest(upRequest2);

        // One person outside of the elevator at floor 4 pressed button to go down to floor 0
        elevator.sendDownRequest(downRequest3);

        // Two person inside of the elevator pressed button to go down to floor 1 and 2.
        elevator.sendDownRequest(downRequest1);
        elevator.sendDownRequest(downRequest2);

        elevator.run();
    }
}