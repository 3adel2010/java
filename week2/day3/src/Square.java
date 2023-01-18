public class Square extends Rectangle
{

    public Square()
    {

    }

    public Square(double side)
    {
        super(side,side);
    }

    public Square(double side, String color, boolean filled)
    {
        super(color, filled,side,side);
    }

    public double getSide()
    {
        return super.getLength();
    }

    public void setSide(double side)
    {
        super.setLength(side);
    }

    public String toPrint()
    {
        return "\nSquare: \n" + "The side is: " + getSide();
    }
}
