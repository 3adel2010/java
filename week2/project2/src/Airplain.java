public class Airplain  extends Trip
{
    @Override
    public int calculateDuration()
    {
        int dur = (int) getDistance() / (int) getSpeed();
        return dur;
    }

    @Override
    public double priceTrip(double km)
    {
        double price = km / 50;
        return price;
    }
}
