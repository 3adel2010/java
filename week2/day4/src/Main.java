import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {

//        ArrayList<Vehicles> vehicles = new ArrayList<Vehicles>();
//
//        vehicles.add(new BMW("BMW","IX","2022","black"));
//        vehicles.add(new Toyota("Toyota","camry","2021","blue"));
//
//        for (Vehicles vehicles1:vehicles)
//        {
//            System.out.println("-----------------");
//            System.out.println("Brand: " + vehicles1.getBrand() + "    -Class: " + vehicles1.getTheClass() +
//                    "    -Module: " + vehicles1.getModule() + "    -Color: " + vehicles1.getColor());
//        }


        Book book = new Book("Java learning", 125.5,"majd nasser");
        Movie movie = new Movie("Spider man",250,"anything");

        System.out.println("Book:\n" + "Name is: " + book.getName() + ". Price is: " + book.getPrice() + ". Author is: " + book.getAuthor() + ".");
        System.out.println("Movie:\n" + "Name is: " + movie.getName() + ". Price is: " + movie.getPrice() + ". Director is: " + movie.getDirector() + ".");

        MovablePoint movablePoint = new MovablePoint(90,90,10,10);
        movablePoint.moveLeft();
        movablePoint.moveUp();
        System.out.println("X: " + movablePoint.getX());
        System.out.println("Y: " + movablePoint.getY());
        movablePoint.moveRight();
        movablePoint.moveDown();
        System.out.println("X: " + movablePoint.getX());
        System.out.println("Y: " + movablePoint.getY());
    }
}