public class Main
{
    public static void main(String[] args)
    {

        Car car = new Car();
        car.setSpeed(90);
        car.setDistance(120);
        car.setStartTime("09:10");

        Train train = new Train();
        train.setSpeed(200);
        train.setDistance(400);
        train.setStartTime("00:00");

        System.out.println("Car:");
        System.out.println("Duration: " + car.calculateDuration());
        System.out.println("Arrival time: " + car.calculateArriveTime());
        System.out.println("Price Ticket: " + car.priceTrip(car.getDistance()) + " SR\n");

        System.out.println("Train:");
        System.out.println("Duration: " + train.calculateDuration());
        System.out.println("Arrival time: " + train.calculateArriveTime());
        System.out.println("Price Ticket: " + train.priceTrip(train.getDistance()) + " SR\n");
    }
}