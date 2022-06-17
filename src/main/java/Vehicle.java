public class Vehicle {

    String number;
    VehicleType vehicleType;

    @Override
    public String toString() {
        return "Vehicle{" +
                "number='" + number + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }

    public Vehicle(String number, VehicleType vehicleType) {
        this.number = number;
        this.vehicleType = vehicleType;

    }
}
