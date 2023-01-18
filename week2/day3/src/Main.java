public class Main
{
    public static void main(String[] args)
    {
//     Student student1 = new Student("Adel", "abdullah", "0595433944", "adilalshaya@gmail.com", 36, 5, 5.00);
//     System.out.println("Student: ");
//     System.out.println(student1.toPrint());
//     System.out.println("--------------------------------------");
//     Teacher teacher1 = new Teacher("Majd", "nasser", "0554466889", "majdnasser@gmail.com", 30, 15000);
//     System.out.println("Teacher: ");
//     System.out.println(teacher1.toPrint());
//     System.out.println("--------------------------------------");
//     TeacherFullTime teacherFullTime1 = new TeacherFullTime("Majd", "nasser", "0554466889", "majdnasser@gmail.com", 30, 15000,500);
//     //teacherFullTime1.setSalary(15000);
//     System.out.println("Teacher full time: ");
//     System.out.println(teacherFullTime1.toPrint());
//     System.out.println("--------------------------------------");
//     TeacherPartTime teacherPartTime1 = new TeacherPartTime("Majd", "nasser", "0554466889", "majdnasser@gmail.com", 30, 15000,180);
//     //teacherPartTime1.setSalary(15000);
//     System.out.println("Teacher part time: ");
//     System.out.println(teacherPartTime1.toPrint());

     Shape shape1 = new Shape();
     Circle circle1 = new Circle();
     Rectangle rectangle1 = new Rectangle();
     Square square1 = new Square();

     shape1.setColor("White");
     shape1.setFilled(true);

     circle1.setRadius(5.2);
     circle1.setColor("Green");
     circle1.setFilled(true);

     rectangle1.setColor("Red");
     rectangle1.setFilled(true);
     rectangle1.setLength(4.5);
     rectangle1.setWidth(2.5);

     square1.setColor("Blue");
     square1.setFilled(false);
     square1.setSide(3);
     square1.setLength(square1.getSide());
     square1.setWidth(square1.getSide());

     System.out.println(shape1.toPrint());
     System.out.println("----------------------------");
     System.out.println("\nCircle:");
     System.out.println("Area is: " + circle1.getArea());
     System.out.println("Radius is: " + circle1.getRadius());
     System.out.println("Perimeter is: " + circle1.getPerimeter());
     System.out.println("Color is: " + circle1.getColor());
     System.out.println("Filled is: " + circle1.isFilled());
     System.out.println("----------------------------");
     System.out.println(rectangle1.toPrint());
     System.out.println("Color is: " + rectangle1.getColor());
     System.out.println("Filled is: " + rectangle1.isFilled());
     System.out.println("----------------------------");
     System.out.println(square1.toPrint());
     System.out.println("Color is: " + square1.getColor());
     System.out.println("Filled is: " + square1.isFilled());
     System.out.println("Length is: " + square1.getLength());
     System.out.println("Width is: " + square1.getWidth());
     System.out.println("----------------------------");
    }
}