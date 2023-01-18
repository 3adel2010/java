public class Book extends Product
{
    private String author;
    public Book()
    {

    }

    public Book(String name, double price, String author)
    {
        super(name, price);
        this.author = author;
    }

    @Override
    public double getDiscount()
    {
        return price - (price * 0.1);
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }
}
