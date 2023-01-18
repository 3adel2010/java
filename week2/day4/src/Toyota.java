public class Toyota implements Vehicles
{
    String brand;
    String theClass;
    String module;
    String colorl;

    public Toyota(String brand, String theClass, String module, String colorl)
    {
        this.brand = brand;
        this.theClass = theClass;
        this.module = module;
        this.colorl = colorl;
    }

    @Override
    public String getBrand()
    {
        return brand;
    }

    @Override
    public String getTheClass()
    {
        return theClass;
    }

    @Override
    public String getModule()
    {
        return module;
    }

    @Override
    public String getColor()
    {
        return colorl;
    }
}
