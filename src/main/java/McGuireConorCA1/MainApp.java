package McGuireConorCA1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainApp
{
    public static void main( String[] args ) throws FileNotFoundException
    {
        File results = new File("JC_Results.txt");

        ArrayList<Student> studentArray = scanFile(results);
    }

    public static ArrayList<Student> scanFile(File results) throws FileNotFoundException
    {
        ArrayList<Student> studentArray = new ArrayList<>();

        Scanner input = new Scanner(results);

        int studentNo;
        int[] subjectCodes = new int[8];
        double[] subjectGrades = new double[8];

        while (input.hasNext())
        {
            studentNo = input.nextInt();
            for (int i = 0; i < 8; i++)
            {
                subjectCodes[i] = input.nextInt();
                subjectGrades[i] = input.nextDouble();
            }
            studentArray.add(new Student (studentNo, subjectCodes, subjectGrades));
        }

        return studentArray;
    }
}
