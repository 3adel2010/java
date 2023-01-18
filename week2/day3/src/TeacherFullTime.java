import java.util.SplittableRandom;

public class TeacherFullTime extends Teacher
{
    int annualSalary;
    public TeacherFullTime(String firstName, String lastName, String phoneNumber, String email, int age, int salary, int annualSalary)
    {
        super(firstName, lastName, phoneNumber, email, age, salary);
        this.annualSalary = annualSalary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary + annualSalary;
    }

    public int getAnnualSalary()
    {
        return annualSalary;
    }

    public void setAnnualSalary(int annualSalary)
    {
        this.annualSalary = annualSalary;
    }
    public String toPrint()
    {
        return "First name: " + getFirstName() + "\nLast name: " + getLastName() + "\nAge: " + getAge() + "\nEmail: " + getEmail()
                + "\nPhone number: " + getPhoneNumber() + "\nSalary: " + getSalary() + "\nAnnul salary: " + getAnnualSalary();
    }
}
