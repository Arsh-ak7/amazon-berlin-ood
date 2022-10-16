package ParkingLot;

import java.util.ArrayList;
import java.util.List;

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

    public void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    public void removeVehicle(){
        this.vehicle = null;
        this.isEmpty = true;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Boolean getIsEmpty(){
        return isEmpty;
    }

    public Integer getSlotNumber(){
        return slotNumber;
    }

}

public class ParkingLot {
    private List<Slot> slots;
    private Integer floorNumber;

    public ParkingLot(Integer floorNumber){
        this.floorNumber = floorNumber;
        this.slots = new ArrayList<>();
    }

    public List<Slot> getSlots(){
        return slots;
    }

    public Integer getFloorNumber(){
        return floorNumber;
    }

    private Slot getNextEmptySlot(){
        for(Slot slot : slots){
            if(slot.getIsEmpty() == true)
                return slot;
        }

        return null;
    }

    public void addCar(Vehicle vehicle){
        Slot slot = getNextEmptySlot();
        if(slot != null){
            slot.parkVehicle(vehicle);
        } else {
            throw new Error("parking full");
        }
    }

    public List<String> registrationNumberOfCars(String color){
        List<String> carsList = new ArrayList<>();
        for(Slot slot : slots ){
            if(!slot.getIsEmpty()){
                if(slot.getVehicle().getVehicleColor() == color)
                    carsList.add(slot.getVehicle().getVehicleNumber());
            }
        }

        return carsList;
    }

    public Integer getSlotNumberOfCar(String registerNumber){
        for(Slot slot : slots){
            if(!slot.getIsEmpty()){
                if(slot.getVehicle().getVehicleNumber() == registerNumber)
                    return slot.getSlotNumber();
            }
        }

        return null;
    }

    public List<Integer> getSlotNumbers(String color){
        List<Integer> slotNumbers = new ArrayList<>();
        for(Slot slot : slots) {
            if(!slot.getIsEmpty()){
                if(slot.getVehicle().getVehicleColor() == color){
                    slotNumbers.add(slot.getSlotNumber());
                }
            }
        }

        return slotNumbers;
    }

    public void createParkingSlots(int numberOfSlots){
        for(int i=1;i<=numberOfSlots;i++){
            slots.add(new Slot(i));
        }
    }

    public List<Vehicle> getListOfVehicles(){
        return null;
    }

    public void processRequests(List<Vehicle> vehicles){
        for(Vehicle car : vehicles){
            addCar(car);
        }
    }

    public static void main(String[] args){
        ParkingLot parkingLot = new ParkingLot(0);
        parkingLot.createParkingSlots(100);

        List<Vehicle> vehicles = parkingLot.getListOfVehicles();

        parkingLot.processRequests(vehicles);
    
    }
}
