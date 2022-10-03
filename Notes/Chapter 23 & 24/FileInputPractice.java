/* Goopert
 * 1A Malloy
 * 9/13/22
 * Program Description: Class practice reading input from a file */

import java.io.*;
import java.util.*;

public class FileInputPractice
{
    //> IOException is a safeguard, prevents errors from input
    public static void main(String[] args) throws IOException
    {
        Scanner fileReader = new Scanner(new File("data.in"));

        Student[] roster = new Student[fileReader.nextInt()];
        int gradesPerStudent = fileReader.nextInt();
        fileReader.nextLine();

        for(int i = 0; i < roster.length; i++)
        {
            Scanner lineReader = new Scanner(fileReader.nextLine());
            String tempName = lineReader.next();
            double[] tempGrades = new double[gradesPerStudent];

            for(int u = 0; u < gradesPerStudent; u++)
            {
                tempGrades[u] = lineReader.nextDouble();
            }

            roster[i] = new Student(tempName, tempGrades);
        }

        fileReader.close();

        for(Student student : roster)
        {
            System.out.println(student.name + ": " + student.findAverage());
        }
    }
}

class Student
{
    String name;
    double[] grades;
    
    public Student(String name, double[] grades)
    {
        this.name = name;
        this.grades = grades;        
    }

    public double findAverage()
    {
        double sum = 0;

        for(int i = 0; i < grades.length; i++)
        {
            sum += grades[i];
        }

        return sum / grades.length;
    }
}