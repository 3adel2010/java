public class Rectangle extends Shape
{
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle()
    {

    }

    public Rectangle(double width, double length)
    {
        this.length = length;
        this.width = width;
    }
    public Rectangle(String color, boolean filled, double width, double length)
    {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getLength()
    {
        return length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }

    public double getArea()
    {
        return width * length;
    }

    public double getPerimeter()
    {
        return (width * 2) + (length * 2);
    }

    public String toPrint()
    {
        return "\nRectangle: \n" + "The width is: " + width + "\nThe length is: " + length + "\nThe area is: " + getArea() + "\nThe perimeter is: " + getPerimeter();
    }

}
