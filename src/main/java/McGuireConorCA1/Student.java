package McGuireConorCA1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Student {

    private int studentNo;
    private int[] subjectIds;
    private double[] subjectGrades;

    public Student(int studentNo, int[] subjectIds, double[] subjectGrades)
    {
        this.studentNo = studentNo;
        this.subjectIds = subjectIds;
        this.subjectGrades = subjectGrades;
    }

    public Student()
    {
        this.studentNo = 0;
        this.subjectIds = null;
        this.subjectGrades = null;
    }

    public int getStudentNo()
    {
        return this.studentNo;
    }

    public int calculateAverageResult()
    {

    }


}
