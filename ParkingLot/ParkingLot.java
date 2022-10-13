package ParkingLot;

class Vehicle {
    private String vehicleNumber;
    private String vehicleColor;

    public Vehicle(String vehicleNumber, String vehicleColor){
        this.vehicleNumber = vehicleNumber;
        this.vehicleColor = vehicleColor;
    }

    void setVehicleColor(String vehicleColor){
        this.vehicleColor = vehicleColor;
    }

    String getVehicleColor(){
        return vehicleColor;
    }

    void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    String getVehicleNumber() {
        return vehicleNumber;
    }
}

class Slot {
    private Integer slotNumber;
    private Boolean isEmpty;
    private Vehicle vehicle;

    public Slot(Integer slotNumber){
        this.slotNumber = slotNumber;
        this.isEmpty = true;
    }

    public void setVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

public class ParkingLot {
    
}
