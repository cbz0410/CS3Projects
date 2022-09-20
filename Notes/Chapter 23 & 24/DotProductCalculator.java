/* Goopert
 * 1A Malloy
 * 9/19/22
 * Program Discrioption: Uses a scanner and calculate the dot product of two vectors, unlimited in dimension 
 *                   IE: a • b = <a_1, a_2, ..., a_n> • <b_1, b_2, ..., b_n> 
 *                             = (a_1 * b_1) + (a_2 * b_2) + ... + (a_n * b_n) 
 * 
 * Example Formatting for the Input File:
 * 
 * 7 13 21
 * 64 37 82
 * 
 * Expected Example Result:
 *
 * 2651.0
 * 
 */

import java.io.*;
import java.util.*;

//> NOTE: This program only works for two vectors (ex. finding a • b)
public class DotProductCalculator 
{
    public static void main(String[] args) throws IOException
    {
        Scanner fileReader = new Scanner(new File("vectors.in"));
        ArrayList<Vector> queue = new ArrayList<Vector>(); //> list of vectors being processed

        //> loop controlling the current vector being processed
        while(fileReader.hasNextLine())
        {
            Scanner vectorReader = new Scanner(fileReader.nextLine());
            ArrayList<Double> vectorElements = new ArrayList<Double>(); //> current vector elements
            
            //> loop controlling the elements of the current vector being processed
            while(vectorReader.hasNextDouble())
            {
                vectorElements.add(vectorReader.nextDouble());
            }

            queue.add(new Vector(vectorElements));

            vectorReader.close();
        }

        fileReader.close();

        System.out.println(queue.get(0).calculateDotProduct(queue.get(1)));
    }
}

class Vector
{
    private ArrayList<Double> elements;

    public Vector(ArrayList<Double> elements)
    {
        this.elements = elements;
    }

    //> returns a • b if possible, otherwise returns -1
    public double calculateDotProduct(Vector b)
    {
        if(elements.size() == b.elements.size())
        {
            double result = 0;

            //> calculates any finite number of elements, n
            for(int i = 0; i < elements.size(); i++)
            {
                result += elements.get(i) * b.elements.get(i);
            }

            return result;
        }

        return -1;
    }
}
