/* Goopert
 * 1A Malloy
 * 10/31/22 
 * Program Description: Extend class Monster to make a Gargoyle. A Gargoyle is a Monster.   
                        A Gargoyle has all of the properties and behaviors of a Monster and it has an 
                        additional property of type double that stores the agility of the Gargoyle. You 
                        must provide 3 constructors for class Gargoyle. You must provide a toString( ) method.
 */

public class GargoyleProj 
{
    public static void main(String[] args)
    {
        //> create test monsters
        Monster mon1 = new Monster();
        Monster mon2 = new Monster("Monster 2");

        //> create test gargoyles
        Gargoyle mon3 = new Gargoyle();
        Gargoyle mon4 = new Gargoyle("Moster 4");
        Gargoyle mon5 = new Gargoyle(1.031);
        Gargoyle mon6 = new Gargoyle("Moster 6", 10.31);

        //> test all monsters and gargoyles
        System.out.println(mon1.toString() + "\n~~~~~~~~~");
        System.out.println(mon2.toString() + "\n~~~~~~~~~");
        System.out.println(mon3.toString() + "\n~~~~~~~~~");
        System.out.println(mon4.toString() + "\n~~~~~~~~~");
        System.out.println(mon5.toString() + "\n~~~~~~~~~");
        System.out.println(mon6.toString());
    }
}

class Monster
{
    private String myName;

    public Monster()
    {
       myName = "Monster";
    }
    public Monster(String name)
    {
       myName = name;
    }
    public String toString()
    {
       return myName + "\n";
    }
}

class Gargoyle extends Monster
{
    private double agility;

    public Gargoyle()
    {
        super();
        setAgility(0);
    }

    public Gargoyle(String name)
    {
        super(name);
        setAgility(0);
    }

    public Gargoyle(double agility)
    {
        super();
        setAgility(agility);
    }

    public Gargoyle(String name, double agility)
    {
        super(name);
        setAgility(agility);
    }

    public void setAgility(double agility)
    {
        this.agility = agility;
    }

    public String toString()
    {
        return super.toString() + agility + "\n";
    }
}