public class Ticket {

    String ticketNumber;
    Vehicle vehicle;
    ParkingSpot parkingSpot;

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", vehicle=" + vehicle +
                ", parkingSpot=" + parkingSpot +
                '}';
    }
}
