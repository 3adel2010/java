public class TeacherPartTime extends Teacher
{
    int hours;
    public TeacherPartTime(String firstName, String lastName, String phoneNumber, String email, int age, int salary, int hours)
    {
        super(firstName, lastName, phoneNumber, email, age, salary);
        this.hours = hours;
    }

    public void setSalary(int salary)
    {
        if (hours > 150)
            salary = hours * 50;
        else
            salary = hours * 30;
        this.salary = salary;
    }

    public int getHours()
    {
        return hours;
    }

    public void setHours(int hours)
    {
        this.hours = hours;
    }
    public String toPrint()
    {
        return "First name: " + getFirstName() + "\nLast name: " + getLastName() + "\nAge: " + getAge() + "\nEmail: " + getEmail()
                + "\nPhone number: " + getPhoneNumber() + "\nSalary: " + getSalary() + "\nHours: " + getHours();
    }
}
