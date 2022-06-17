import java.util.*;
import java.util.stream.IntStream;

public class Level {

    Integer floor;
    UUID id;
    List<ParkingSpot> parkingSpotList;
    Map<String, ParkingSpot> parketVehicleMap;

    public Level(Integer floor) {
        this.id = UUID.randomUUID();
        this.floor = floor;
        parkingSpotList  = new ArrayList<>();
        IntStream.range(0,2).forEach(i->{
            //System.out.println("Created LARGE PARKING on level :" + floor);
            parkingSpotList.add(new ParkingSpot(this,i,ParkingSpotType.LARGE));
        });
        IntStream.range(3,5).forEach(i->{
            //System.out.println("Created MOTORBIKE PARKING on level :" + floor);
            parkingSpotList.add(new ParkingSpot(this,i,ParkingSpotType.MOTORBIKE));
        });
        IntStream.range(6,8).forEach(i->{
            //System.out.println("Created COMPACT PARKING on level :" + floor);
            parkingSpotList.add(new ParkingSpot(this,i,ParkingSpotType.COMPACT));
        });
        parketVehicleMap = new HashMap<>();

    }

    ParkingSpot getParkingSpot(Vehicle vehicle){

        Optional<ParkingSpot> parkingSpot= parkingSpotList.stream().filter(a -> a.canFit(vehicle)).findFirst();
        if(parkingSpot.isPresent()){
            ParkingSpot allocatedParkingSpot = parkingSpot.get();
            parketVehicleMap.put(vehicle.number,allocatedParkingSpot);
            allocatedParkingSpot.fillSpot(vehicle);
            return allocatedParkingSpot;
        }
        else{
            System.out.println("No parking spot available on level " + floor);

        }
        return null;
    }

    void freeParkingSpot(Vehicle vehicle){
        ParkingSpot parkingSpot = parketVehicleMap.get(vehicle.number);
        parketVehicleMap.remove(vehicle.number);
        parkingSpot.clearSpot();
    }

}
