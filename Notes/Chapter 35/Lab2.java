import java.util.ArrayList;

/* Goopert
 * 1A Malloy
 * 10/17/22 
 * Program Description: BYOI project - demonstrates the relationship between various quadric surfaces (3D surfaces) 
 *                      What are quadric surfaces? https://tutorial.math.lamar.edu/classes/calciii/quadricsurfaces.aspx
 *                      TLDR: a paraboloid IS A quadric surface; a hyperboloid IS A quadric surface
 */

public class Lab2
{
    public static void main(String[] args)
    {
        //> create Paraboloid objects:
        QuadricSurface quadricSurface1 = new Paraboloid(1, 1, "HYPERBOLIC");
        QuadricSurface quadricSurface2 = new Paraboloid(1, 1, "ELLIPTIC");
        QuadricSurface quadricSurface3 = new Paraboloid(3, 9, "HYPERBOLIC");
        QuadricSurface quadricSurface4 = new Paraboloid(3, 9, "ELLIPTIC");
        QuadricSurface quadricSurface5 = new Paraboloid(28, 1126, "HYPERBOLIC");

        //> create Hyperboloid objects:
        QuadricSurface quadricSurface6 = new Hyperboloid(1, 2, 3, 1);
        QuadricSurface quadricSurface7 = new Hyperboloid(1, 2, 3, 2);
        QuadricSurface quadricSurface8 = new Hyperboloid(8, 16, 32, 1);
        QuadricSurface quadricSurface9 = new Hyperboloid(8, 16, 32, 2);
        QuadricSurface quadricSurface10 = new Hyperboloid(28, 28, 1126, 1);

        //> create PolymorphicSurface object:
        PolymorphicSurface quadricSurfaces = new PolymorphicSurface();
        quadricSurfaces.addPolymorphicSurface(quadricSurface1);
        quadricSurfaces.addPolymorphicSurface(quadricSurface2);
        quadricSurfaces.addPolymorphicSurface(quadricSurface3);
        quadricSurfaces.addPolymorphicSurface(quadricSurface4);
        quadricSurfaces.addPolymorphicSurface(quadricSurface5);
        quadricSurfaces.addPolymorphicSurface(quadricSurface6);
        quadricSurfaces.addPolymorphicSurface(quadricSurface7);
        quadricSurfaces.addPolymorphicSurface(quadricSurface8);
        quadricSurfaces.addPolymorphicSurface(quadricSurface9);
        quadricSurfaces.addPolymorphicSurface(quadricSurface10);

        //> test subclass objects:
        quadricSurfaces.printAll();
    }
}

//> superclass of Paraboloid and Hyperboloid
class QuadricSurface
{
    private double aValue;
    private double bValue;

    public QuadricSurface(double aValue, double bValue)
    {
        setAValue(aValue);
        setBValue(bValue);
    }

    //> accessor method for aValue
    public double getAValue()
    {
        return aValue;
    }

    //> accessor method for bValue
    public double getBValue()
    {
        return bValue;
    }

    //> mutator method for aValue
    public void setAValue(double aValue)
    {
        this.aValue = (aValue != 0) ? aValue : 1; //> a cannot be zero; otherwise, x will be divided by zero; defaults to 1
    }

    //> mutator method for bValue
    public void setBValue(double bValue)
    {
        this.bValue = (bValue != 0) ? bValue : 1; //> b cannot be zero; otherwise, y will be divided by zero; defaults to 1
    }

    //> prints a description of the object, including the fields
    public void printDetails()
    {
        System.out.print("aValue >>> " + aValue + " | bValue >>> " + bValue);
    }

}

//> subclass of QuadricSurface
class Paraboloid extends QuadricSurface
{
    private boolean isHyperbolic;
    private boolean isElliptic;

    public Paraboloid(double aValue, double bValue, String paraboloidType)
    {
        super(aValue, bValue);
        setParaboloidType(paraboloidType);
    }

    //> accessor method for isHyperbolic
    public boolean getIsHyperbolic()
    {
        return isHyperbolic;
    }

    //> accessor method for isElliptic
    public boolean getIsElliptic()
    {
        return isElliptic;
    }

    //> mutator method for both isHyperbolic and isElliptic; must be both because they are mutually exclusive
    //> the only two valid imputs for this method are (ignoring case) "HYPERBOLIC" or "ELLIPTIC"
    public void setParaboloidType(String paraboloidType)
    {
        //> these properties are mutually exclusive
        isHyperbolic = paraboloidType.equalsIgnoreCase("HYPERBOLIC");
        isElliptic = !isHyperbolic;
    }

    //> prints a description of the object, including the paraboloid equation and fields
    public void printDetails()
    {
        String ySign = isHyperbolic ? " - " : " + ";

        System.out.println("THE EQUATION: z = (x / " + getAValue() + ")^2" + ySign + "(y / " + getBValue() + ")^2");
        super.printDetails();
        System.out.println(" | isHyperbolic >>> " + isHyperbolic + " | isElliptic >>> " + isElliptic + "\n");
    }
}

//> subclass of QuadricSurface
class Hyperboloid extends QuadricSurface
{
    private double cValue;
    private int numOfSheets;

    public Hyperboloid(double aValue, double bValue, double cValue, int numOfSheets)
    {
        super(aValue, bValue);
        setCValue(cValue);
        setNumOfSheets(numOfSheets);
    }

    //> accessor method for cValue
    public double getCValue()
    {
        return cValue;
    }

    //> accessor method for numOfSheets
    public int getNumOfSheets()
    {
        return numOfSheets;
    }

    //> mutator method for cValue
    public void setCValue(double cValue)
    {
        this.cValue = (cValue != 0) ? cValue : 1; //> c cannot be zero; otherwise, z will be divided by zero; defaults to 1
    }

    //> mutator method for numOfSheets
    public void setNumOfSheets(int numOfSheets)
    {
        //> the number of sheets can only be 1 or 2; if the input is more than this, it set to 1 by default
        this.numOfSheets = (numOfSheets == 1 || numOfSheets == 2) ? numOfSheets : 1;
    }

    //> prints a description of the object, including the hyperboloid equation and fields
    public void printDetails()
    {
        String zSign = (numOfSheets == 1) ? " - " : " ";
        String xySign = (numOfSheets == 1) ? " + " : " - ";

        System.out.println("THE EQUATION: 1 =" + zSign + "(z / " + cValue + ")^2" + xySign + "(x / " + getAValue() + ")^2" + xySign + "(y / " + getBValue() + ")^2");
        super.printDetails();
        System.out.println(" | cValue >>> " + cValue + " | numOfSheets >>> " + numOfSheets + "\n");
    }
}

//> additional class as indicated by instructions
class PolymorphicSurface
{
    ArrayList<QuadricSurface> polymorphicSurfaces;

    public PolymorphicSurface()
    {
        polymorphicSurfaces = new ArrayList<QuadricSurface>();
    }

    //> adds a quadric surface to the arraylist of them
    public void addPolymorphicSurface(QuadricSurface polymorphicSurface)
    {
        polymorphicSurfaces.add(polymorphicSurface);
    }

    //> prints out the printDetails() method for each quadric surface in the arraylist
    public void printAll()
    {
        for(QuadricSurface polymorphicSurface : polymorphicSurfaces)
        {
            polymorphicSurface.printDetails();
        }
    }
}