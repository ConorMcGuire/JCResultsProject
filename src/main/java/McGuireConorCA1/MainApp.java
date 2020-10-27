package McGuireConorCA1;
/*
Conor McGuire
D00230552
SD2B
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainApp
{
    public static void main(String[] args) {

        File results = new File("JC_Results.txt"); //References the text file we want to read from

        System.out.println("Student Number\t\tAverage Grade"); //Print table heading
        scanFile(results); //Method to begin reading from the file
    }

    public static void scanFile(File results) {
        /*scanFile() method reads one student at a time, passes the results into the selectFiveGrades() method*/
        int[] subjectCodes = new int[8]; //Create array to store subject codes from text file
        int[] subjectGrades = new int[8]; //Create array to store subject grades from text file
        int[] selectedGrades; //Create array to store 5 grades selected in selectFiveGrades() method
        int studentNo; //int to store student number
        double averageGrade; //Double to store value returned by calculateAverage() method

        try {
            Scanner input = new Scanner(results);
            input.useDelimiter("[,\r\n]+"); //Specifies the delimiter can be any combination of commas, carriage return or line break
            while (input.hasNext()) //Continues as long as there's more text to read in the file
            {
                studentNo = input.nextInt();
                for (int i = 0; i < subjectCodes.length; i++) { /*As we know the structure of the file is correct we can
                    use the definite length for the for loop. Each loop adds the next subject code and grade to the respective array*/
                    subjectCodes[i] = input.nextInt();
                    subjectGrades[i] = input.nextInt();
                }

                selectedGrades = selectFiveGrades(subjectCodes, subjectGrades); //After each student's data is read, select the five grades for averaging
                averageGrade = calculateAverage(selectedGrades); //Then average those results
                printResults(studentNo, averageGrade); //And print the answer

            }

        } catch (IOException e) {
                System.out.println(e.getMessage()); //try/catch in case file is missing
            }
    }

    public static int[] selectFiveGrades(int[] subjectCodes, int[] subjectGrades)
            /*selectFiveGrades takes the subject codes and grades for a particular student and selects the Irish, English
             and Maths grades, along with the best two other results besides CSPE*/
    {
        int[] selectedGrades = new int[5];
        int gradePos = 0; //Variable used to select the index of the selectedGrades array
        int highestGrade = -1, secondHighest = -1; /*Variables for storing the two highest grades other than English,
        Irish, Maths and CSPE. Since we know that the data is correct we can initialise these variables as -1 as the
        lowest possible value for a grade is 0*/

        for (int i = 0; i < subjectCodes.length; i++) {
            if (subjectCodes[i] == 218) //Checks if this subject is CSPE
            {
                subjectGrades[i] = 0; //Changes CSPE result to 0 so it won't be counted further on, result remains unchanged in original .txt file so I felt this was ok
            }
            else if (subjectCodes[i] == 1 || subjectCodes[i] == 2 || subjectCodes[i] == 3) //Checks if subject is English, Irish or Maths
            {
                selectedGrades[gradePos] = subjectGrades[i]; //Adds the English, Irish or Maths grade to the selectedGrades array
                subjectGrades[i] = 0; /*Changes said result to 0 so it is not read in the next 'else if' branch, I think
                this is fair for reason mentioned a few lines above*/
                gradePos++; //Advances the index of the selectedGrades array so results aren't overwritten
            }
            else if (subjectGrades[i] > highestGrade) //If the grade at the index i is greater than the current highest grade
            {
                secondHighest = highestGrade; //the previous highest grade becomes second highest
                highestGrade = subjectGrades[i]; //Highest grade becomes the value at index i in  the grades index
            }
            else if (subjectGrades[i] > secondHighest) //If a grade is not greater than the highest but is greater than the second highest
            {
                secondHighest = subjectGrades[i]; //second highest is replaced with grade at index i
            }
        }
        /*After all grades are read, the first three indexes of the selected grades array will contain the maths, irish
         and english result. The highest and second highest grades are therefore placed in the final two spots of the */
        selectedGrades[3] = highestGrade;
        selectedGrades[4] = secondHighest;

        return selectedGrades;
    }

    public static double calculateAverage(int[] selectedGrades) {
        /*Takes the selected grades and finds the average*/
        int total = 0;
        double average;

        for (int number:selectedGrades)
        {
            total += number;
        }

        average = (double)total/5; //(double) is used as total is an int

        return average;
    }

    public static void printResults(int studentNo, double averageGrade)
    {
        System.out.printf("%d%20.2f\n",studentNo,averageGrade); //Prints the student number and average to two decimal places
    }


}
