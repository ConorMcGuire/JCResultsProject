package McGuireConorCA1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args) {

        File results = new File("JC_Results.txt");

        System.out.println("Student Number\t\tAverage Grade");
        scanFile(results);
    }

    public static void scanFile(File results) {
        int[] subjectCodes = new int[8];
        int[] subjectGrades = new int[8];
        int[] selectedGrades = new int[5];
        int studentNo;
        double averageGrade;

        try {
            Scanner input = new Scanner(results);
            input.useDelimiter("[,\r\n]+");
            while (input.hasNext())
            {
                studentNo = input.nextInt();
                for (int i = 0; i < subjectCodes.length; i++) {
                    subjectCodes[i] = input.nextInt();
                    subjectGrades[i] = input.nextInt();
                }

                selectedGrades = selectFiveGrades(subjectCodes, subjectGrades);
                averageGrade = calculateAverage(selectedGrades);
                printResults(studentNo, averageGrade);

            }

        } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    }

    public static int[] selectFiveGrades(int[] subjectCodes, int[] subjectGrades)
    {
        int[] selectedGrades = new int[5];
        int gradePos = 0; //Variable used to select the index of the selectedGrades array
        int highestGrade = -1, secondHighest = -1; //Variables for storing the two highest grades other than English, Irish, Maths and CSPE

        for (int i = 0; i < subjectCodes.length; i++) {
            if (subjectCodes[i] == 218) //Checks if this subject is CSPE
            {
                subjectGrades[i] = 0; //Changes CSPE result to 0 so it won't be counted further on, result remains unchanged in original .txt file so I felt this was ok
            }
            else if (subjectCodes[i] == 1 || subjectCodes[i] == 2 || subjectCodes[i] == 3) //Checks if subject is English, Irish or Maths
            {
                selectedGrades[gradePos] = subjectGrades[i]; //Adds the English, Irish or Maths grade to the selectedGrades array
                subjectGrades[i] = 0; //Changes said result to 0, I think this is fair for reason mentioned a few lines above
                gradePos++; //Advances the index of the selectedGrades array so results aren't overwritten
            }
            else if (subjectGrades[i] > highestGrade)
            {
                secondHighest = highestGrade;
                highestGrade = subjectGrades[i];
            }
            else if (subjectGrades[i] > secondHighest)
            {
                secondHighest = subjectGrades[i];
            }
        }
        selectedGrades[3] = highestGrade;
        selectedGrades[4] = secondHighest;

        return selectedGrades;
    }

    public static double calculateAverage(int[] selectedGrades) {
        int total = 0;
        double average;

        for (int number:selectedGrades)
        {
            total += number;
        }

        average = (double)total/5;

        return average;
    }

    public static void printResults(int studentNo, double averageGrade)
    {
        System.out.printf("%d%20.2f\n",studentNo,averageGrade);
    }



//    public static void main( String[] args ) throws FileNotFoundException
//    {
//        File results = new File("JC_Results.txt");
//
//        ArrayList<Student> studentArray = scanFile(results);
//    }

//    public static ArrayList<Student> scanFile(File results) throws FileNotFoundException
//    {
//            ArrayList<Student> studentArray = new ArrayList<>();
//
//        try{
//            Scanner input = new Scanner(results);
//            input.useDelimiter("[,\r\n]+");
//
//            int studentNo;
//            int[] subjectCodes = new int[8];
//            int[] subjectGrades = new int[8];
//
//            while (input.hasNext()) {
//                studentNo = input.nextInt();
//                for (int i = 0; i < 8; i++) {
//                    subjectCodes[i] = input.nextInt();
//                    subjectGrades[i] = input.nextInt();
//                }
//                studentArray.add(new Student(studentNo, subjectCodes, subjectGrades));
//            }
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//
//            return studentArray;
//    }


}
