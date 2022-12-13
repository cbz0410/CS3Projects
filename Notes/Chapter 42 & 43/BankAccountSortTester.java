import java.io.*;
import java.util.*;

/* Goopert
* 1A Malloy
* 12/9/22
* Program Description: processes BankInfo.dat into an ArrayList of type BankAccount, sorts
*                      it by the balance variable in ascending order, and prints the result 
*
*/

public class BankAccountSortTester
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<BankAccount> bankAccounts = fillBankAccounts();

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~\nPre-Sort bankAccounts:\n~~~~~~~~~~~~~~~~~~~~~~");
        printBankAccounts(bankAccounts);

        sortbankAccounts(bankAccounts);

        System.out.println("\n\n\n~~~~~~~~~~~~~~~~~~~~~~~\nPost-Sort bankAccounts:\n~~~~~~~~~~~~~~~~~~~~~~~");
        printBankAccounts(bankAccounts);
    }

    //> processes BankInfo.dat into an ArrayList of type BankAccount
    public static ArrayList<BankAccount> fillBankAccounts() throws FileNotFoundException
    {
        Scanner bankInfoReader = new Scanner(new File("BankInfo.dat"));
        ArrayList<BankAccount> bankAccounts = new ArrayList<BankAccount>();

        double tempBalance;
        String tempName;

        Scanner individualReader;

        while(bankInfoReader.hasNextLine())
        {
            individualReader = new Scanner(bankInfoReader.nextLine());
            tempName = individualReader.next() + " " + individualReader.next();
            tempBalance = individualReader.nextDouble();

            bankAccounts.add(new BankAccount(tempBalance, tempName));
        }

        bankInfoReader.close();

        return bankAccounts;
    }

    //> implements a simple bubble sort function in accordance with balance instance variable of type double
    public static void sortbankAccounts(ArrayList<BankAccount> bankAccounts)
    {
        int len = bankAccounts.size();

        for(int i = 0; i < len - 1; i++)
        {
            for(int u = 0; u < len - i - 1; u++)
            {
                if(bankAccounts.get(u).getBalance() > bankAccounts.get(u + 1).getBalance())
                {
                    Collections.swap(bankAccounts, u, u + 1);
                }
            }
        }
    }

    //> prints the contents of the bankAccounts ArrayList
    public static void printBankAccounts(ArrayList<BankAccount> bankAccounts)
    {
        for(BankAccount bankAccount : bankAccounts)
        {
            System.out.println(bankAccount.toString());
        }
    }
}

class BankAccount
{
    private double balance;
    private String name;

    public BankAccount(double balance, String name)
    {
        setBalance(balance);
        setName(name);
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getBalance()
    {
        return balance;
    }

    public String getName()
    {
        return name;
    }

    public void deposit(double amount)
    {
        balance += amount;
    }

    public void withdraw(double amount)
    {
        balance -= amount;
    }

    public String toString()
    {
        return name + " >>> $" + balance;
    }
}