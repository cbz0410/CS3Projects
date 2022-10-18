/* Goopert
 * 1A Malloy
 * 10/17/22 
 * Program Description: - put a mundane description here - */

public class Lab2
{
    public static void main(String[] args)
    {
        //> insert test code here...
    }
}

class QuadricSurface
{
    private double aValue;
    private double bValue;

    public QuadricSurface(double aValue, double bValue)
    {
        setAValue(aValue);
        setBValue(bValue);
    }

    public double getAValue()
    {
        return aValue;
    }

    public double getBValue()
    {
        return bValue;
    }

    public void setAValue(double aValue)
    {
        this.aValue = (aValue != 0) ? aValue : 1; //> a cannot be zero; otherwise, x will be divided by zero; defaults to 1
    }

    public void setBValue(double bValue)
    {
        this.bValue = (bValue != 0) ? bValue : 1; //> b cannot be zero; otherwise, y will be divided by zero; defaults to 1
    }

    public void printDetails()
    {
        System.out.print("aValue >>> " + aValue + " | bValue >>> " + bValue);
    }

}

class Paraboloid extends QuadricSurface
{
    private boolean isHyperbolic;
    private boolean isElliptic;

    public Paraboloid(double aValue, double bValue, String paraboloidType)
    {
        super(aValue, bValue);
        setParaboloidType(paraboloidType);
    }

    public boolean getIsHyperbolic()
    {
        return isHyperbolic;
    }

    public boolean getIsElliptic()
    {
        return isElliptic;
    }

    //> the only two valid imputs for this method are (ignoring case) "HYPERBOLIC" or "ELLIPTIC"
    public void setParaboloidType(String paraboloidType)
    {
        //> these properties are mutually exclusive
        isHyperbolic = paraboloidType.equalsIgnoreCase("HYPERBOLIC");
        isElliptic = !isHyperbolic;
    }

    public void printDetails()
    {
        String ySign = isHyperbolic ? " - " : " + ";

        System.out.println("THE EQUATION: z = (x / " + getAValue() + ")^2" + ySign + "(y / " + getBValue() + ")^2");
        super.printDetails();
        System.out.println(" | isHyperbolic >>> " + isHyperbolic + " | isElliptic >>> " + isElliptic);
    }
}

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

    public double getCValue()
    {
        return cValue;
    }

    public int getNumOfSheets()
    {
        return numOfSheets;
    }

    public void setCValue(double cValue)
    {
        this.cValue = (cValue != 0) ? cValue : 1; //> c cannot be zero; otherwise, z will be divided by zero; defaults to 1
    }

    public void setNumOfSheets(int numOfSheets)
    {
        //> the number of sheets can only be 1 or 2; if the input is more than this, it set to 1 by default
        this.numOfSheets = (numOfSheets == 1 || numOfSheets == 2) ? numOfSheets : 1;
    }

    public void printDetails()
    {
        String zSign = (numOfSheets == 1) ? " - " : " ";
        String xySign = (numOfSheets == 1) ? " + " : " - ";

        System.out.println("THE EQUATION: 1 =" + zSign + "(z / " + cValue + ")^2" + xySign + "(x / " + getAValue() + ")^2" + xySign + "(y / " + getBValue() + ")^2");
        super.printDetails();
        System.out.println(" | cValue >>> " + cValue + " | numOfSheets >>> " + numOfSheets);
    }
}