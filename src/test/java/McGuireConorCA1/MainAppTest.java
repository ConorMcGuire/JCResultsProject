package McGuireConorCA1;
/*
Conor McGuire
D00230552
SD2B
 */

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MainAppTest
{
    /**
     * Test of selectFiveGrades method, of class MainApp to make sure method works correctly when all grades are unique.
     */
    @Test
    public void selectFiveGradesTest1()
    {
        System.out.println("selectFiveGrades");
        int[] subjectCodes = {1,2,3,4,5,12,42,46};
        int[] subjectGrades = {65,58,45,60,50,48,42,61};
        int[] expResult = {65,58,45,61,60};
        int[] result = MainApp.selectFiveGrades(subjectCodes, subjectGrades);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of selectFiveGrades method, of class MainApp to make sure method works correctly when CSPE is highest grade.
     */
    @Test
    public void selectFiveGradesTest2()
    {
        System.out.println("selectFiveGrades");
        int[] subjectCodes = {218,4,3,2,10,42,46,1};
        int[] subjectGrades = {94,38,95,75,0,33,66,17};
        int[] expResult = {95,75,17,66,38};
        int[] result = MainApp.selectFiveGrades(subjectCodes, subjectGrades);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of selectFiveGrades method, of class MainApp to make sure method works correctly when highest grade is duplicate.
     */
    @Test
    public void selectFiveGradesTest3()
    {
        System.out.println("selectFiveGrades");
        //783461,3,65,1,58,2,45,125,60,137,68,126,100,57,77,4,60
        int[] subjectCodes = {3,1,2,125,137,126,57,4};
        int[] subjectGrades = {65,58,45,60,68,100,100,60};
        int[] expResult = {65,58,45,100,100};
        int[] result = MainApp.selectFiveGrades(subjectCodes, subjectGrades);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of calculateAverage method, of class MainApp
     */
    @Test
    public void calculateAverageTest1()
    {
        System.out.println("calculateAverage");
        int[] selectedGrades = {65,58,45,100,100};
        double expResult = 73.6;
        double result = MainApp.calculateAverage(selectedGrades);
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of calculateAverage method, of class MainApp
     */
    @Test
    public void calculateAverageTest2()
    {
        System.out.println("calculateAverage");
        int[] selectedGrades = {95,75,17,66,38};
        double expResult = 58.2;
        double result = MainApp.calculateAverage(selectedGrades);
        assertEquals(expResult, result, 0.01);
    }
}
