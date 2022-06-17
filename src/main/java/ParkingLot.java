import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParkingLot {

    List<Level> levels;
    Integer floors;
    static Integer ticketCounter= 1;

    public ParkingLot(Integer floors) {
        this.floors = floors;
        levels = new ArrayList<>();
        IntStream.range(0,floors).forEach(i -> {
                levels.add(new Level(i));
        });

    }

    Ticket parkVehicle(Vehicle vehicle){

        for(int i=0;i<floors;i++){
            ParkingSpot parkingSpot = levels.get(i).getParkingSpot(vehicle);
            if( parkingSpot != null){
                Ticket ticket = new Ticket();
                ticket.parkingSpot = parkingSpot;
                ticket.vehicle= vehicle;
                ticket.ticketNumber = "T_" + ticketCounter.toString();
                ticketCounter++;
                return ticket;
            }
        }
        System.out.println("Parking is full");
        return null;
    }

    void removeVehicle(Ticket ticket){
        if(ticket == null)
        {
            System.out.println("Invalid ticket");
            return;
        }
        Level parkingLevel = levels.get(ticket.parkingSpot.level.floor);
        parkingLevel.freeParkingSpot(ticket.vehicle);
        System.out.println("Removed vehicle from parking");
    }
}
