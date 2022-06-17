public class ParkingSpot {

    Level level;
    Vehicle vehicle;
    ParkingSpotType parkingSpotType;
    Integer id;
    Boolean isEmpty;

    public ParkingSpot(Level level,  Integer id,ParkingSpotType parkingSpotType) {
        this.level = level;
        this.parkingSpotType = parkingSpotType;
        this.id = id;
        isEmpty = true;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                " parkingSpotType=" + parkingSpotType +
                ", id=" + id +
                '}';
    }

    boolean canFit(Vehicle vehicle){
        if(isEmpty == false){
            return false;
        }
        if(vehicle.vehicleType == VehicleType.CAR){
            if(parkingSpotType.equals(ParkingSpotType.LARGE))
                return true;
        }
        if(vehicle.vehicleType == VehicleType.MOTORCYCLE){
            if(parkingSpotType.equals(ParkingSpotType.COMPACT) || parkingSpotType.equals(ParkingSpotType.LARGE) )
                return true;
        }
        return false;
    }

    void fillSpot(Vehicle vehicle){

        this.isEmpty = false;
        this.vehicle = vehicle;
    }

    void clearSpot(){
        this.isEmpty = true;
        this.vehicle = null;
    }
}
