public class Teacher extends Person
{
    int salary;
    public Teacher(String firstName, String lastName, String phoneNumber, String email, int age, int salary)
    {
        super(firstName, lastName, phoneNumber, email, age);
        this.salary = salary;
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }

    public String toPrint()
    {
        return "First name: " + getFirstName() + "\nLast name: " + getLastName() + "\nAge: " + getAge() + "\nEmail: " + getEmail()
                + "\nPhone number: " + getPhoneNumber() + "\nSalary: " + getSalary();
    }
}
