/* Goopert
 * 1A Malloy
 * 9/27/22
 * Program Description: Class practice writing to a file */

import java.io.*;

public class FileWritingPractice
{
    //> IOException is a safeguard, prevents errors from input
    public static void main(String[] args) throws IOException
    {

        FileWriter gradeWriter = new FileWriter(new File("grades.in"));
        PrintWriter output = new PrintWriter(gradeWriter);

        output.println("5 7");
        output.println("Calvert 80 85 95 50 52 63 98");
        output.println("Goppert 99 99 99 99 50 98 50");
        output.println("Solt 78 96 85 74 73 85 86");
        output.println("Morrow 100 100 100 100 100 100 100");
        output.println("Chacko 95 98 85 92 97 85 78");

        gradeWriter.close();
        output.close();

    }    
        
}
