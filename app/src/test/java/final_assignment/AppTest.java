/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package final_assignment;


import org.junit.Test;
import static org.junit.Assert.*;


public class AppTest {

    @Test
    public void testPred() {
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double alpha = 0.3;
        Skewed_Binary_Search.Sorted_Array sortedArray = new Skewed_Binary_Search.Sorted_Array(inputArray, alpha);

        // Test for an existing element
        int existingElement = 5;
        assertEquals(existingElement, sortedArray.Pred(existingElement));

        // Test for a non-existing element
        int nonExistingElement = 15;
        int expectedResultForNonExisting = Integer.MAX_VALUE;
        assertEquals(expectedResultForNonExisting, sortedArray.Pred(nonExistingElement));

        // Add more test cases based on the specific behavior of your Pred method
    }

    //Tests for RankSelectNaive class
    @Test
    public void testNaiveRankMethodReturnsHowMany1sOnTherthNumberOn64LengthVector() {
    // Generate a vector of length 64 
        int n = 64;  
        int[] Fixed64Vector = new int[n];
        int[] inputArray = new int[] {0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1};
        for (int i = 0; i < Fixed64Vector.length; i++) {
            Fixed64Vector[i] = inputArray[i];
        }
        RankSelectNaive rs = new RankSelectNaive(Fixed64Vector);
        assertEquals(0, rs.rank(0));
        assertEquals(5, rs.rank(10));
        assertEquals(25, rs.rank(50));
        assertEquals(32, rs.rank(63));
    } 

    //Tests for RankSelectLookUp class
    @Test
    public void testRankMethodReturnsExpectedResultOn64LengthVector() {
    // Generate a vector of length 64 
        int n = 64;  
        int[] Fixed64Vector = new int[n];
        int[] inputArray = new int[] {0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1};
        for (int i = 0; i < Fixed64Vector.length; i++) {
            Fixed64Vector[i] = inputArray[i];
        }

        RankSelectLookUp rs = new RankSelectLookUp(Fixed64Vector);
        assertEquals(0, rs.rank(0));
        assertEquals(5, rs.rank(10));
        assertEquals(25, rs.rank(50));
        assertEquals(32, rs.rank(63));
    }

    @Test
    public void testSelectMethodRetrunsExpectedResultOn64LengthVector() {
    // Generate a vector of length 64 
        int n = 64;  
        int[] Fixed64Vector = new int[n];
        int[] inputArray = new int[] {0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1};
        for (int i = 0; i < Fixed64Vector.length; i++) {
            Fixed64Vector[i] = inputArray[i];
        }        
        RankSelectLookUp rs = new RankSelectLookUp(Fixed64Vector);
        assertEquals(0, rs.select(0));
        assertEquals(5, rs.select(3));
        assertEquals(23, rs.select(13));
        assertEquals(63, rs.select(33));
    }
}