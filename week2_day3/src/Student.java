public class Student extends Person
{
    int level;
    double GPA;
    public Student(String firstName, String lastName, String phoneNumber, String email, int age, int level, double GPA)
    {
        super(firstName, lastName, phoneNumber, email, age);
        this.level = level;
        this.GPA = GPA;
    }

    public int getLevel()
    {
        return level;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public double getGPA()
    {
        return GPA;
    }

    public void setGPA(double GPA)
    {
        this.GPA = GPA;
    }

    public String toPrint()
    {
        return "First name: " + getFirstName() + "\nLast name: " + getLastName() + "\nAge: " + getAge() + "\nEmail: " + getEmail()
                + "\nPhone number: " + getPhoneNumber() + "Level: " + getLevel() + "GPA: " + getGPA();
    }
}
