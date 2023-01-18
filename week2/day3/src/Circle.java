public class Circle extends Shape
{
    private double radius = 1.0;

    public Circle()
    {

    }
    public Circle(double radius)
    {
        this.radius = radius;
    }
    public Circle(String color, boolean filled, double radius)
    {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    public double getArea()
    {
        return Math.PI * Math.sqrt(radius);
    }
    public double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }
}
