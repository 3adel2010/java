public class Main
{
    public static void main(String[] args)
    {
//        Students s1 = new Students();
//        Students s2 = new Students();
//        Students s3 = new Students();
//
//        s1.setFirst_name("first name for first student: " + "Adel");
//        s1.setLast_name("last name for first student: " + "Abdullah");
//        s1.setPhone_number("Phone number  for first student: " + "0595433944");
//        s1.setEmail("Email  for first student: " + "adilalshaya@gmail.com");
//
//        System.out.println();
//
//        System.out.println(s1.getFirst_name());
//        System.out.println(s1.getLast_name());
//        System.out.println(s1.getPhone_number());
//        System.out.println(s1.getEmail());
//
//        System.out.println();
//
//        s2.setFirst_name("first name for second student: " + "Ali");
//        s2.setLast_name("last name for second student: " + "Fahad");
//        s2.setPhone_number("Phone number  for second student: " + "0594587774");
//        s2.setEmail("Email  for second student: " + "alifahad@gmail.com");
//
//        System.out.println();
//
//        System.out.println(s2.getFirst_name());
//        System.out.println(s2.getLast_name());
//        System.out.println(s2.getPhone_number());
//        System.out.println(s2.getEmail());
//
//        System.out.println();
//
//        s3.setFirst_name("first name for third student: " + "nora");
//        s3.setLast_name("last name for third student: " + "saad");
//        s3.setPhone_number("Phone number  for third student: " + "0556655231");
//        s3.setEmail("Email  for third student: " + "norasaad@gmail.com");
//
//        System.out.println(s3.getFirst_name());
//        System.out.println(s3.getLast_name());
//        System.out.println(s3.getPhone_number());
//        System.out.println(s3.getEmail());

        Account account1 = new Account("123","Adel",8500);

        System.out.println("\nFor account:\n");
        System.out.println("Your account ID is " + account1.getId());
        System.out.println("Your account Name is " + account1.getName());
        System.out.println("Your account Balance is " + account1.getBalance());

        account1.credit(350);
        account1.debit(1500);
        account1.tostring();

        System.out.println("***********************************************\n-----------------------------------------------");

        Employee employee = new Employee("123", "Ali", 9000);

        System.out.println("\nFor employee:\n");
        System.out.println("Your employee ID os " + employee.getId());
        System.out.println("Your employee Name is " + employee.getName());
        System.out.println("Your employee Salary is " + employee.getSalary());

        employee.annualSalary();
        employee.raisedSalary(10);
        employee.tostring();
    }
}