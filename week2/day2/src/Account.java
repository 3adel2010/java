public class Account
{
    private String id;
    private String name;
    private int balance = 0;

    public Account(String id, String name)
    {
        this.id = id;
        this.name = name;
    }
    public Account(String id, String name,int balance)
    {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int credit(int amount)
    {
        balance = balance + amount;
        System.out.println("Your balance now is " + balance);
        return balance;
    }
    public int debit(int amount)
    {
        if (balance > amount)
        {
            balance = balance - amount;
            System.out.println("Your balance now is " + balance);
            return amount;
        }
        else
            System.out.println("The balance " + amount + " is not available.!!");
        return balance;
    }
    public String tostring()
    {
        String account = "The account ID is " + id +"\nThe account Name is " + name + "\nThe account Balance is " + balance;
        System.out.println("-----------------------------------------------");
        System.out.println(account);
        System.out.println("-----------------------------------------------");
        return account;
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

    public int getBalance()
    {
        return balance;
    }

    public void setBalance(int balance)
    {
        this.balance = balance;
    }
}
