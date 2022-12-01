import java.util.*;

/* Goopert
* 1A Malloy
* 12/1/2022
* Program Description: implements the LinearFunctionMethods interface into the LinearFunction class for the lazy supervisor*/
public class LinearFunctionTester
{
    public static void main(String[] args)
    {
        Scanner kbReader = new Scanner(System.in);

        System.out.print("What is the slope of your line? ");
        double slope = kbReader.nextDouble();

        System.out.print("What is the y-intercept of your line? ");
        double yIntc = kbReader.nextDouble();

        LinearFunction line = new LinearFunction(slope, yIntc);
        System.out.println("\nSlope of this line is: " + line.getSlope());
        System.out.println("Y-intercept of this line is: " + line.getYintercept());
        System.out.println("Root of this line is: " + line.getRoot());

        System.out.print("\nWhat is an x value for which you wish to solve for y? ");
        double x = kbReader.nextDouble();
        double yValue = line.getYvalue(x);
        System.out.println("The y value corresponding to x = " + x + " is " + yValue);

        System.out.print("\nWhat is a y value for which you wish to solve for x? ");
        double y = kbReader.nextDouble();
        double xValue = line.getXvalue(y);
        System.out.println("The x value corresponding to y = " + y + " is " + xValue);

        kbReader.close();
    }
}

interface LinearFunctionMethods
{
    double getSlope();
    double getYintercept();
    double getRoot();

    double getYvalue(double x); //return the y value corresponding to x
    double getXvalue(double y); //return the x value corresponding to y
}

class LinearFunction implements LinearFunctionMethods
{
    private double slope;
    private double yIntercept;

    public LinearFunction(double slope, double yIntercept)
    {
        this.slope = slope;
        this.yIntercept = yIntercept;
    }

    public double getSlope()
    {
        return(slope);
    }

    public double getYintercept()
    {
        return(yIntercept);
    }

    public double getRoot()
    {
        return(-yIntercept/slope);
    }

    public double getYvalue(double x)
    {
        return(slope * x + yIntercept);
    }

    public double getXvalue(double y)
    {
        return((y - yIntercept) / slope);
    }
}