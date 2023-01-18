public class Employee
{
    private String id;
    private String name;
    private int salary;

    public Employee (String id, String  name, int salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int annualSalary()
    {
        int annual = salary * 12;
        System.out.println("The employee annual salary is " + annual);
        return annual;
    }

    public double raisedSalary(double percent)
    {
        double newSalary = salary * percent / 100;
        System.out.println("The new employee salary is " + newSalary);
        return newSalary;
    }

    public String tostring()
    {
        String employee = "The employee ID is " + id + "\nThe employee Name is " + name + "\nThe employee Salary is " + salary;
        System.out.println("-----------------------------------------------");
        System.out.println(employee);
        System.out.println("-----------------------------------------------");
        return employee;
    }
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getSalary()
    {
        return salary;
    }

    public void setSalary(int salary)
    {
        this.salary = salary;
    }
}
