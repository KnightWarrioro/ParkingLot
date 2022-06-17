public class Driver {
    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(2);

        Vehicle v1 = new Vehicle("sanjay_rawat",VehicleType.CAR);
        Vehicle v2 = new Vehicle("sanjay_rawat2",VehicleType.CAR);
        Vehicle v3 = new Vehicle("sanjay_rawat3",VehicleType.CAR);

        Ticket ticket1 = parkingLot.parkVehicle(v1);
        System.out.println(ticket1);
        Ticket ticket2 = parkingLot.parkVehicle(v2);
        System.out.println(ticket2);
        Ticket ticket3 = parkingLot.parkVehicle(v3);
        System.out.println(ticket3);

        parkingLot.removeVehicle(ticket1);

    }
}
